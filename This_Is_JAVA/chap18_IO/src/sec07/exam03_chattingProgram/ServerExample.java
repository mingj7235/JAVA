package sec07.exam03_chattingProgram;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ServerExample extends Application {
	ExecutorService executorService; //스레드풀을 생성하기위해 생성
	ServerSocket serverSocket; //클라이언트 연결요청 수락위해 
	List<Client> connections = new Vector<Client>(); //벡터를 쓴이유는 스레드동기화때문에
	
	void startServer() {
		//서버 시작 코드
		executorService = Executors.newFixedThreadPool(
					Runtime.getRuntime().availableProcessors()
				); //스레드의 최대 실행갯수		//현재는 내 pc의 cpu가 지원하는 코어의 수만큼 생성하는 것임
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
		} catch (Exception e) {
			if (!serverSocket.isClosed()) {
				stopServer(); //서버 종료 메소드
			}
			return; //예외 났을시 return  
		}
		
		Runnable runnable = new Runnable() { //연결 수락 객체
			@Override
			public void run() {
				//연결 수락을 위한 코드. 스레드로 작업
				Platform.runLater( () -> {	//ui 변경 요청을 하는 코드 //ui변경을 위해서 이걸 써야하고,
					// ui 변경을 하는 코드를 여기에 쓰는 것이다. 쉽게생각하자. ui start버튼을 stop으로 변경하는 것임 
					displayText("[서버 시작]"); //TestArea에 글을 써주는 메소드 호출. 매개값을 출력함
					btnStartStop.setText("stop"); //버튼의 글자를 바꿈
				});
				
				while (true) {
					try {
						Socket socket = serverSocket.accept();//클라이언트의 서버를 수락함
						String message = "[연결 수락 : "  + socket.getRemoteSocketAddress() +": " +
														Thread.currentThread().getName() + "]"; 
																	//클라ip,포트정보와 현재 스레드풀의 담당스레드 이름 출력함
						Platform.runLater(()->
							displayText(message)
						);
						
						Client client = new Client(socket);
						connections.add(client);
						Platform.runLater(()->
							displayText("[연결 개수 : " + connections.size() + "]")
						);
					} catch (IOException e) {
						if(!serverSocket.isClosed()) {
							stopServer();
						}
						break;
					} 
				}
			}
		};
		executorService.submit(runnable); //스레드풀에 작업하도록 하는 것임. 
	}
	void stopServer() {
		//서버 종료 코드 //연결된 모든 client의 연결을 끊는 것임
			try {
				Iterator<Client> iterator = connections.iterator();
				while (iterator.hasNext()) {
					Client client = iterator.next();
					client.socket.close();
					iterator.remove(); //모든 클라이언트 제거
				}
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
				if (executorService!= null && !executorService.isShutdown()) {
					executorService.shutdown();
				}
				Platform.runLater(() -> {
					displayText("[서버 멈춤]");
					btnStartStop.setText("start"); //다시 버튼을 스타트로 변경
				});
			} catch (IOException e) {}
		}	
	
	class Client {
		//데이터 통신 코드를 가지고 있음. //클라이언트를 관리하기위해 
		Socket socket;
		Client (Socket socket) { //생성자
			this.socket = socket;
			receive ();
		}
		
		void receive () { //클라이언트가 데이터를 보내게되면 통신소켓을 이용! 
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					//클라이언트가 메세지를 보내게끔
					try {
						while (true) { //계속해서 메세지를 보낼수 있어야하므로 무한루프
							byte [] byteArr = new byte [100];
							InputStream is = socket.getInputStream(); //클라이언트로부터 온 데이터를 읽어야하므로
							
							int readByteCount = is.read(byteArr);
							if (readByteCount == -1) { //클라이언트가 정상적으로 종료했다면
								throw new IOException () ; //강제적으로 일부러 IOException 발생시킴
										//그래서 catch로 빠질 수 있도록 ! -> 종료하는 코드를 catch에 넣어서 편하게 관리하기위해
							}
							
							String message = "[요청 처리 : " + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]";
							Platform.runLater(() ->
								displayText(message)
							); 
							String data = new String (byteArr, 0, readByteCount, "UTF-8");
							//이 받은 데이터를 send해야함 -> 모든 client에게! 그래서 반복문써서 보내야함.올...ㅋ 
							for (Client client : connections) {
								client.send(data);
							}
						}
					}catch (Exception e) {
						try {
							connections.remove(Client.this); //이 클라이언트 객체를 제거함
							String message = "클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]";
							Platform.runLater( () ->
								displayText(message)
							);
							socket.close();
						} catch (IOException e1) {	}
					}
				}
			};
			executorService.submit(runnable); //스레드풀에 스레드를 작업 큐에 넣는 것임!!!
		}
		
		void send (String data) {
			Runnable runnable = new Runnable () {
				@Override
				public void run() {
					try {
						byte[] byteArr = data.getBytes("UTF-8"); //매개값 data에서 byte를 가져옴
						//클라이언트로 보내야하므로 output필요
						OutputStream os = socket.getOutputStream();
						os.write(byteArr);
						os.flush();
					} catch (Exception e) {
						try {
							String message = "클라이언트 통신 안됨 : " + socket.getRemoteSocketAddress() + ":"
									+ Thread.currentThread().getName() + "]";
							Platform.runLater( () ->
								displayText(message)
							);
							connections.remove(Client.this);
							socket.close();
						} catch (IOException e1) {}
					} 
				}
			};
			executorService.submit(runnable);
		}
	}
	
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction(e->{
			if(btnStartStop.getText().equals("start")) {
				startServer();
			} else if(btnStartStop.getText().equals("stop")){
				stopServer();
			}
		});
		root.setBottom(btnStartStop);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event->stopServer());
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
