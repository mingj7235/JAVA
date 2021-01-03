package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import javax.sound.sampled.SourceDataLine;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServerController implements Initializable{
	
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connection = new Vector<>();
	
	@FXML private TextArea logText;
	@FXML private Button btnServerStart;
	@FXML private TextField portField;

	public class Client {
		Socket socket;
		String name;
		SourceDataLine sourcedateline;
		
		public Client (Socket socket) {
			this.socket = socket;
			this.sourcedateline = null;
			receive();
		}
		
		//메세지 받기 메소드
		void receive () {
			Runnable thread = new Runnable() {
				@Override
				public void run() {
					try {
						while(true) {
							byte[] arr = new byte[100];
							InputStream inputStream = socket.getInputStream();
							
							int readByteCount = inputStream.read(arr);
							if(readByteCount == -1) {
								throw new IOException();
							}
							String message = new String(arr,0,readByteCount, "UTF-8");
							Platform.runLater(() -> logText.appendText(message));
							
							for(Client client : connection) {
								client.send(message);
							}
						}
					}catch (Exception e) {
						connection.remove(Client.this);
						String message = "[Client connection Error : " +socket.getRemoteSocketAddress() + "]\n";
						Platform.runLater(() -> logText.appendText(message));
						try {
							socket.close();
						} catch (IOException e1) {
						}
					}
				}
			};
			executorService.submit(thread);
		}
		
		//클라이언트한테 데이터 보냄
		void send (String message) {
			
		}
		
		
	}


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
