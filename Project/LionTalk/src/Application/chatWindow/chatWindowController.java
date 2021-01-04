package Application.chatWindow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.ResourceBundle;

import Application.Login.LoginController;
import Application.Method.CalTimeClass;
import Application.Method.FindMemberClass;
import Application.model.Customer;
import Application.model.MessageFormat;
import Application.model.MessageProcessing;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class chatWindowController implements Initializable {

	// @FXML private TextArea textArea;
	@FXML
	private Button send;
	@FXML
	private TextField name;
	@FXML
	private ListView messagelist;
	@FXML
	private TextArea message;

	Button exitButton = new Button("Exit");

	FindMemberClass fm = new FindMemberClass();

	// private Stage primaryStage = FriendShowController.primaryStage;

	boolean Listener = false; // false 일때는 해당 메시지가 오지 않음.

	public static String ChattingMember;
	Customer customer = Customer.getCustomer();

	Socket socket = LoginController.socket;

	ObjectInputStream ois = LoginController.ois;
	ObjectOutputStream oos = LoginController.oos;

	BufferedReader br = LoginController.br;
	PrintWriter pw = LoginController.pw;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		name.setFocusTraversable(false);
		name.setId(ChattingMember); //
		
		messagelist.setEditable(false);

		Platform.runLater(() -> message.requestFocus());

		name.setText(ChatMember);
		name.setEditable(false);
		name.setStyle("-fx-alignment: CENTER;");

		ArrayList<MessageFormat> totalMessage = null;
		if(!fm.FindChat(chatId).getChatId().equals("#"))
			totalMessage = fm.FindChat(chatId).chattingMessage;
		
		if (totalMessage != null) { // 채팅내용이 있다면 ListView에 기존 내용 넣어놓음

			// textArea.setWrapText(true);
			for (MessageFormat message : totalMessage) {
				displayText(message, true);
			}
		}
		send.setDisable(true);

		receive(); // 데이터 리시브 하는 스레드 호출

		message.setWrapText(true);

		message.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				// TODO Auto-generated method stub

				if (ke.getCode().equals(KeyCode.ENTER)) {

					if (message.getText().trim().equals("")) {
						return;
					}

					message.setText(message.getText().trim());
					SendBtnAction(null);

					send.setDisable(true);
				} else if (ke.getCode().equals(KeyCode.ESCAPE)) {
					Stage a = (Stage) message.getScene().getWindow();
					thread.stop();
					a.close();
				} else if (ke.getCode().equals(KeyCode.SPACE)) {
					message.appendText(" ");

				}
			}

		});
		message.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				// message.setText(message.getText().trim());

				if (message.getLength() > 0) {
					send.setDisable(false);
				}

			}
		});
	}

	void displayText(MessageFormat message, boolean init) { // TextArea에 문자열
															// 추가하는 메서드

		// Platform.runLater(()->
		// textArea.appendText(FindMember(message.getFrom())
		// .name+" : "+message.message+ "\n"));

		try {
			if (message.getFrom().equals(customer.getId())) { // 여기서부터
				AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("chatMe1.fxml"));
				
				Label time = (Label) pane.lookup("#time");
				time.setFont(new Font(9));
				time.setText(CalTimeClass.CalTime(message.getTime()));
				HBox hbox = (HBox) pane.lookup("#hbox");
				hbox.setAlignment(Pos.TOP_RIGHT);
				
				BubbledLabel bl = new BubbledLabel(BubbleSpec.FACE_RIGHT_BOTTOM);
				bl.setPading(0);// 
				
				StringBuffer str = new StringBuffer(message.getMessage());
				int length = str.length()/13;
				for (int i = 0; i < length; i++) {
					str.insert(13*(i+1), "\n"); // 13번쨰 문자(한글기준) 마다  \n을  넣어 개행  13크기 만큼 동적할당
				}

				pane.setPrefHeight(50 +  30* length) ; 
				hbox.setPrefHeight(40 + 20 * length);
				bl.setPrefHeight(40 + 20 * length) ; 
				
				bl.setText(str.toString());
				bl.setBackground(new Background(new BackgroundFill(Color.PALETURQUOISE, null, null)));
				hbox.getChildren().add(bl);

				pane.getStylesheets().add(getClass().getResource("chatWindow.css").toExternalForm());
				
				Platform.runLater(() -> messagelist.getItems().add(pane));
			} else {
				// 여기
				AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("chatYou.fxml"));
				pane.setBackground(Background.EMPTY);
				Label name = (Label) pane.lookup("#name");
				name.setText(fm.FindMemberById(message.getFrom()).getName());
				HBox hbox = (HBox) pane.lookup("#hbox");
				
				ImageView image = (ImageView)pane.lookup("#img");
				FileInputStream inputstream = null;
				if(! fm.FindMemberById(message.getFrom()).getId().equals("#")){
					inputstream = new FileInputStream("C:\\profils\\"+fm.FindMemberById(message.getFrom()).getId()+".jpg"); 
					image.setImage(new Image(inputstream));
				}

				BubbledLabel bl1 = new BubbledLabel(BubbleSpec.FACE_LEFT_CENTER);
				bl1.setText(message.getMessage());
				bl1.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
				Label time = new Label(CalTimeClass.CalTime(message.getTime()));
				time.setFont(new Font(9));
				
				StringBuffer str = new StringBuffer(message.getMessage());
				int length = str.length()/13;
				for (int i = 0; i < length; i++) {
					str.insert(13*(i+1), "\n"); // 13번쨰 문자(한글기준) 마다  \n을  넣어 개행  13크기 만큼 동적할당
				}

				pane.setPrefHeight(50 +  30* length) ; 
				hbox.setPrefHeight(40 + 20 * length);
				bl1.setPrefHeight(40 + 20 * length) ; 
				
				
				bl1.setText(str.toString());
				bl1.setBackground(new Background(new BackgroundFill(Color.PALETURQUOISE, null, null)));
				
				hbox.getChildren().add(bl1);
				hbox.getChildren().add(time);

				pane.getStylesheets().add(getClass().getResource("chatWindow.css").toExternalForm());
				Platform.runLater(() -> messagelist.getItems().add(pane));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 채팅창에 채팅 내용 입력후 내용 다시 초기화.
		if (init == false) {
			Platform.runLater(() -> MessageProcessing.getIndex().get(chatId).setMessage(""));
		}
	}

	Customer FindMember(String cusId) {
		if (cusId.equals(customer.getId()))
			return customer;

		Iterator<Customer> iter = customer.getFriendList().iterator();

		while (iter.hasNext()) {
			Customer c = iter.next();
			if (c.getId().equals(cusId)) { // 아이디와 pw가 일치하는것이 있다면
				return c;
			}
		}
		return new Customer("#", "#", "알수 없는 사람");
	}

	String chatId = ChattingMember;
	String ChatMember = "";
	{
		String str[] = chatId.split("/");
		for (int i = 0; i < str.length; i++) {
			if (!str[i].equals(customer.getId())) {
				if (ChatMember.length() > 10) {
					ChatMember.substring(0, ChatMember.length() - 2);

					ChatMember += "... (" + chatId.split("/").length + ")..";
					break;
				}
				ChatMember += FindMember(str[i]).getName() + ", ";
			}
		}
		ChatMember = ChatMember.substring(0, ChatMember.length()-2);
	}

	public void SendBtnAction(ActionEvent e) {
		String msg = message.getText();
		message.setText("");
		
		MessageFormat message = new MessageFormat(customer.getId(), name.getId(), msg,
				CalTimeClass.CalToTime(Calendar.getInstance()));
		send(message);

	}

	static public Thread thread;

	void receive() {
		thread = new Thread() {
			{
				Platform.runLater(() -> MessageProcessing.getIndex().get(chatId).setMessage(""));
			}
			@Override
			public void run() {
				while (true) {

					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if (MessageProcessing.getIndex().get(chatId).getMessage().equals(""))
							continue;

						fm.FindChat(chatId).setMessageNum(-1); // 대화창이 켜져 있으면 채팅창 메시지 수 -1 초기화.
						displayText(MessageProcessing.getIndex().get(chatId), false);
					} catch (NullPointerException e1) {
						MessageProcessing.getIndex().put(chatId, new MessageFormat(""));
						e1.printStackTrace();
						continue;
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}

				}
			}
		};
		thread.start();
	}

	void send(MessageFormat data) { // 센드 스레드 발생
		Thread thread = new Thread() {
			public void run() {
				try {
					oos.writeObject(data);

				} catch (NotSerializableException e) {

					System.out.println("서버 통신 안됨.1");
					e.printStackTrace();
					// stopClient();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("서버 통신 안됨2");
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}

}
