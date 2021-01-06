package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.MessagePane;

public class Chat_w_01_controller implements Initializable{
	@FXML private Label Chats_time;
	@FXML private Label chat_chat_name_label;
	@FXML private BorderPane chat_w_01_mainpane;
	@FXML private Pane chat_w_01_pane;
	@FXML private Slider chat_slider_opacity;
	@FXML private TextField chat_write_messages;
	@FXML private ScrollPane chat_pane;
	@FXML private TextArea chat_textarea;
	@FXML private Button chat_send_button;
	@FXML private Button chat_back_btn;
	@FXML private Button chat_start_button;
	@FXML private VBox chat_vbox;
		
	Socket socket;
	
	void startClient () {
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket();
					socket.connect(new InetSocketAddress("localhost", 5001));
					Platform.runLater(() -> {
						chat("[Connection]" 
								+ socket.getRemoteSocketAddress() + "]");
						chat_start_button.setText("stop");
						chat_send_button.setDisable(false);
						
					});
				}catch (IOException e) {
					Platform.runLater(() -> chat("[Connection Error]"));
					if(!socket.isClosed()) {stopClient();}
					return;
				}
				receive();
			}
		};
		thread.start();
	}
	
	void stopClient() {
		try {
			Platform.runLater(() -> {
				chat("[Connection Error]");
				chat_start_button.setText("start");
				chat_send_button.setDisable(true);
			});
			
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		}catch (Exception e) {}
	}
	
	void receive () {
		while (true) {
			try {
				byte [] byteArr = new byte [100];
				InputStream is = socket.getInputStream();
				
				int readByteCount = is.read(byteArr);
				if (readByteCount == -1) {
					throw new IOException();
				}
				
				String data = new String (byteArr, 0, readByteCount, "UTF-8");
				MessagePane mp = new MessagePane(data);
//				chat_vbox.getChildren().add(mp.getPane());
				
				Platform.runLater(() -> 
					chat_vbox.getChildren().add(mp.getPane()));
//					chat_textarea.appendText(data+"\n"));
				
			}catch (Exception e) {
				Platform.runLater(() -> chat("[Connection Error]"));
				stopClient();
				break;
			}
		}
	}
	
	void send (String data) {
		Thread thread = new Thread () {
			public void run() {
				try {
					byte[] byteArr = data.getBytes("UTF-8");
					OutputStream os = socket.getOutputStream();
					os.write(byteArr);
					os.flush();
					Platform.runLater(() -> chat("[send Success]"));
				}catch (Exception e) {
					Platform.runLater(() -> chat("[Server connection Error]"));
				}
			}
		};
		thread.start();
	}
	
	
	public void chat (String msg) {
		chat_textarea.appendText(msg+"\n");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chat_send_button.setOnAction(e->handleBtnSend(e));
		chat_back_btn.setOnAction(e->handleBtnBack(e));
		chat_start_button.setOnAction(e->handleBtnStart(e));
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Chats_time.setText(sdf.format(date));
		
		chat_slider_opacity.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, 
					Number oldValue, Number newValue) {
				chat_w_01_mainpane.setOpacity(chat_slider_opacity.getValue() /100.0);
			}
		});
		
	}
	
	public void handleBtnStart (ActionEvent event) {
		if(chat_start_button.getText().equals("start")) {
			startClient();
		} else if(chat_start_button.getText().equals("stop")){
			stopClient();
		}
	}
	
	public void handleBtnBack(ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Chats.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) chat_back_btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String writeMessages () {
		return chat_write_messages.getText();
	}


	public void handleBtnSend(ActionEvent event) {
		MessagePane mp = new MessagePane("메세지");
		chat_vbox.getChildren().add(mp.getPane());
		
		send(chat_write_messages.getText());
		chat_write_messages.setText("");
	}
		
}
