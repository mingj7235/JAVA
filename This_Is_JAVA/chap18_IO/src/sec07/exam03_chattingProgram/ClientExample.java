package sec07.exam03_chattingProgram;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClientExample extends Application {
	Socket socket;
	
	void startClient() {
		//연결 시작 코드
		Thread thread = new Thread () {
			@Override
			public void run() {
				try {
					socket = new Socket();
					socket.connect(new InetSocketAddress("localhost", 5001));//연결 요청할 서버의 정보를 넣어서 connect메소드 매개값으로 넣음
					Platform.runLater( () -> {
						displayText("[연결완료" + socket.getRemoteSocketAddress() + "]"); //어디에연결되어있는지 서버를 보여줌
						btnConn.setText("stop"); //버튼 변경
						btnSend.setDisable(false); //send버튼 활성화하기 (기본적으로 비활성화 되어있었음)
					});
				} catch (IOException e) {
					Platform.runLater( () ->displayText("[서버 통신 안됨]") );
					if (!socket.isClosed()) {stopClient();}
					return; //run 종료
				}
				receive(); //서버가 보낸 메세지를 받도록 하는 메소드
			}
		};
		thread.start();
	}
	
	void stopClient() {
		try {
			Platform.runLater( () ->{
				displayText("[연결 끊음]");
				btnConn.setText("start");
				btnSend.setDisable(true);
			});
			
			if(socket !=null && !socket.isClosed()) {
				socket.close();
			}
		} catch (Exception e) {}
	}	
	
	void receive() {
		while (true) {
			try {
				byte [] byteArr = new byte [100];
				InputStream is = socket.getInputStream(); //서버에서 메세지를 받아야하므로
				
				int readByteCount = is.read(byteArr);
				if (readByteCount == -1) { //-1인경우는 정상적 종료임
					throw new IOException(); //강제적 예외 발생 -> 예외 처리 코드로 갈수있도록
				}
				//정상적으로 데이터를 읽었을 경우
				String data = new String (byteArr, 0, readByteCount, "UTF-8");
				
				Platform.runLater( () -> displayText("[받기 완료] " + data) );
			}catch (Exception e ) {
				//정상적인 종료거나 비정상적 종료인경우
				Platform.runLater( () -> displayText("[연결 안됨") );
				stopClient();
				break;
			}
		}
	}
	
	void send(String data) {
		//send로 서버에 보냄 서버에 보내면 서버가 받고 서버가 다시 모든 클라한테 보냄 그러면 클라는 그걸 다시 받음 이게 반복
		
		Thread thread = new Thread() {
			public void run() {
				try {
					byte[] byteArr = data.getBytes("UTF-8");
					OutputStream os = socket.getOutputStream();
					os.write(byteArr);
					os.flush();
					Platform.runLater(() -> displayText("[보내기 완료]"));
				} catch (Exception e) {
					Platform.runLater(() -> displayText("[서버 통신 안됨]"));
					stopClient();
				}
			}
		} ;
		thread.start();
	}
	
	//////////////////////////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		BorderPane bottom = new BorderPane();
			txtInput = new TextField();
			txtInput.setPrefSize(60, 30);
			BorderPane.setMargin(txtInput, new Insets(0,1,1,1));
			
			btnConn = new Button("start");
			btnConn.setPrefSize(60, 30);
			btnConn.setOnAction(e->{
				if(btnConn.getText().equals("start")) {
					startClient();
				} else if(btnConn.getText().equals("stop")){
					stopClient();
				}
			});
			
			btnSend = new Button("send"); 
			btnSend.setPrefSize(60, 30);
			btnSend.setDisable(true);
			btnSend.setOnAction(e->send(txtInput.getText()));
			
			bottom.setCenter(txtInput);
			bottom.setLeft(btnConn);
			bottom.setRight(btnSend);
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.setOnCloseRequest(event->stopClient());
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
