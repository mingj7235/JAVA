package Application.FreindList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ResourceBundle;

import Application.Login.LoginController;
import Application.Method.CalTimeClass;
import Application.Method.FindMemberClass;
import Application.findFriend.findFriendController;
import Application.friendlist.FriendController;
import Application.model.ChattingRoom;
import Application.model.Customer;
import Application.model.MessageFormat;
import Application.model.MessageProcessing;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;

// 처음 로그인시 친구와 채팅 목록을 보여주는 화면 Controller
public class FriendShowController implements Initializable  {

	@FXML private Button friendList; // 친구 버튼
	@FXML private Button ChattingList; // 채팅 버튼
	@FXML private Button GameList; // 목록 버튼

	@FXML private TextField Search; // 검색 필드
	@FXML private ListView<String> friends; // 친구, 채팅 목록 ListView
	@FXML private Label show; 
	@FXML private Button addChat; // 새로운 채팅방 만들기 버튼
	@FXML private StackPane stackpane;

	ArrayList<Customer> Friends ; // 사용자의 친구목록을 저장할 리스트
	ArrayList<ChattingRoom> ChattingRoom ; // 사용자의 채팅 방을 저장할 hashset
	Rectangle2D primaryScreenBounds ;


	int currentWin = 1; // 현재 사용자고 보고 있는 리스트 -> 친구 리스트 목록 : 1 , 채팅 리스트 목록 : 2


	Customer customer = Customer.getCustomer() ;
	String id;

	Socket socket;
	int nCnt=0;

	String fileName;
	String filePath;
	FileWriter fw;

	ObjectInputStream ois = LoginController.ois;
	ObjectOutputStream oos = LoginController.oos;

	BufferedReader br = LoginController.br;
	PrintWriter pw = LoginController.pw;


	@FXML private AnchorPane anchorPane;

	// 앱 종료 메서드
	@FXML
	public void exitApplication(ActionEvent event) {
		stopClient();
		
		Stage primaryStage = (Stage)stackpane.getScene().getWindow();
		primaryStage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 처음 로그인 했을 때의 socket 받아오기
		this.socket = LoginController.socket;
		addChat.setVisible(false);

		primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		// 서버로부터 받은 채팅방 변수 저장
		ChattingRoom = customer.getChattingRoom();

		// 서버로부터 메시지를 받을 Thread 실행
		startClient();

		try{
			customer = Customer.getCustomer();
		}catch(Exception e){e.printStackTrace();
		}

		// 처음 로그인시 친구 목록을 보여줌
		FriendBtnAction(null);
	}
	// 클라이언트 종료
	void stopClient(){
		try{
			if( (socket!= null) &&!socket.isClosed()){
				socket.close();
			}
		}catch(IOException e){}
	}

	// 클라이언트 시작
	void startClient()
	{
		Thread thread = new Thread(){
			@Override
			public void run() {
				try{
					Platform.runLater(()->{
						System.out.println("[연결 완료 ㅣ "+socket.getRemoteSocketAddress()+"]");
					});
				}catch(Exception e){
					Platform.runLater(()-> {
						stopClient();
						System.out.println("연결 끊김");
					});
				}
				receive();
			}
		};
		thread.start();
	}


	void receive() { // 데이터 받는 스레드 
		while(true){
			try{
				MessageFormat message = (MessageFormat)ois.readObject();	

				if(message.getType() == 3  || message.getType() == 4){ // id와 번호로 찾은 친구 리턴
					Customer c = (Customer) ois.readObject();
					findFriendController.cus = c;
					if(c.getId().equals("#")){ // 존재하지 않는 회원

					}else if(c.getFriendList().contains(c)){ //이미 존재한 친구
						System.out.println("이미 존재하는 회원 입니다.");
					}else{
						Platform.runLater(()->{
							Customer.getCustomer().getFriendList().add(c);
							FriendBtnAction(null);
						});
					}
					continue;
				}
				
				// 채팅내용 업데이트
				UpdateChat(message); 

				// 해당 채팅방이 내용 읽을 수 있도록 push *after updateChat
				MessageFormat message1 = new MessageFormat(message.getFrom(), message.getChatId(), message.getMessage(), message.getTime());
				MessageProcessing.getIndex().put(message.getChatId(), message1); 

				// 메세지가 오면 알람을 띄움 * 마지막
				Stage primaryStage = (Stage)stackpane.getScene().getWindow();
				if(!primaryStage.isFocused() && !message.getFrom().equals(customer.getId()) )
					// 사용자가 채팅방을 보고있지 않을때 , 사용자가 보낸 메시지가 아닐때 popup
				{
					Popup popup = new Popup();

					Parent parent = FXMLLoader.load(getClass().getResource("../alarm/chatYou.fxml"));
					ImageView img = (ImageView) parent.lookup("#img");
					
					try{
					FileInputStream inputstream = new FileInputStream("C:\\profils\\"+message.getFrom()+".jpg") ; 
					img.setImage(new Image(inputstream));
					}catch(Exception e){}
					
					StringBuffer str = new StringBuffer(message.getMessage());
					int length = str.length()/13;
					for (int i = 0; i < length; i++) {
						str.insert(13*(i+1), "\n"); // 13번쨰 문자(한글기준) 마다  \n을  넣어 개행  13크기 만큼 동적할당
					}

					// 프로필 이미지 설정
					img.setOnMouseClicked(event->popup.hide());
					Label lmessage = (Label)parent.lookup("#message");
					lmessage.setText(str.toString());

					Label lname = (Label)parent.lookup("#name");
					lname.setText(fm.FindMemberById(message.getFrom()).getName());

					popup.getContent().add(parent);

					Platform.runLater(()-> {		
						popup.show(primaryStage,primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight()); 
					});
				}


			}catch(Exception e){
				System.out.println("접속 해제");
				stopClient();
				e.printStackTrace();
				break;
			}
		}
	}
	FindMemberClass fm = new FindMemberClass();

	void UpdateChat(MessageFormat message){

		if(fm.FindChat(message.getChatId()).getChatId().equals("#")) // 기존방이 없다면 방 새로 만들고
			customer.getChattingRoom().add(new ChattingRoom(message.getChatId(), new ArrayList<>()));

		// 방에 새로운 메시지를 입력한다.
		fm.FindChat(message.getChatId()).chattingMessage.add(message);
		fm.FindChat(message.getChatId()).setCal(message.getTime()); // 채팅방 시간 최신화
		fm.FindChat(message.getChatId()).setMessageNum(
		fm.FindChat(message.getChatId()).getMessageNum()+1); //읽지 않은 메시지 수 증가

		Collections.sort(customer.getChattingRoom(), new ClassChatComparator());
		// 리스트 뷰 업데이트
		if(currentWin == 2){
			Platform.runLater(()->{
				// 기존에 있는 채팅방이라면 제거 한다 (중복 허용 하지 않음)
				stackpane.getChildren().remove(addChat);
				ListView listView;
				try {
					listView = (ListView) FXMLLoader.load(getClass().getResource("../chattinglist/chattinglist.fxml"));
					stackpane.getChildren().add(listView);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stackpane.getChildren().add(addChat);
			});
		}


	}

	public void handleProfile(ActionEvent e){
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass() //ChatWindow.fxml
					.getResource("../profile/profile.fxml"));

			Scene scene = new Scene(root);
			primaryStage.setX(350);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();


		}catch(Exception e1)
		{
			System.out.println("무대 발생 실패");
			e1.printStackTrace();
		}
	}

	public void intviteBtnAction(ActionEvent e){
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass() //ChatWindow.fxml
					.getResource("../Invite/Invite.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setX(250);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();


		}catch(Exception e1)
		{
			System.out.println("무대 발생 실패");
			e1.printStackTrace();
		}

	}
	
	public static String searchName="";
	public void FriendBtnAction(ActionEvent e)
	{
		friendList.setFont(new Font("Cambria", 18));
		ChattingList.setFont(new Font("Cambria", 13));
		GameList.setFont(new Font("Cambria", 13));
		addChat.setDisable(true);
		addChat.setVisible(false);
		currentWin = 1;

		Search.setPromptText("친구 검색");
		show.setText("친구");
		
		Search.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				// TODO Auto-generated method stub

				if (ke.getCode().equals(KeyCode.ENTER)) {

					if (Search.getText().trim().equals("")) {
						// 모든 친구 다 보여주기
						searchName = "";
						ListView listView;
						try {
							listView = (ListView) FXMLLoader.load(getClass().getResource("../friendlist/friendlist.fxml"));
							stackpane.getChildren().add(listView);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						ListView listView;
						searchName = Search.getText().trim();
						
						try {
							listView = (ListView) FXMLLoader.load(getClass().getResource("../friendlist/friendlist.fxml"));
							stackpane.getChildren().add(listView);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				} 
			}

		});

		ListView listView;
		try {
			listView = (ListView) FXMLLoader.load(getClass().getResource("../friendlist/friendlist.fxml"));
			stackpane.getChildren().add(listView);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static String searchChat = "";
	public void ChattingBtnAction(ActionEvent e) {
		friendList.setFont(new Font("Cambria", 13));
		ChattingList.setFont(new Font("Cambria", 18));
		GameList.setFont(new Font("Cambria", 13));

		currentWin = 2; // 채팅 리스트 보고 있음

		addChat.setVisible(true);
		addChat.setDisable(false);

		Search.setPromptText("채팅방 검색");
		show.setText("채팅방");
		
		// 기존에 있는 채팅방이라면 제거 한다 (중복 허용 하지 않음)
		stackpane.getChildren().remove(addChat);
		ListView listView;
		try {
			listView = (ListView) FXMLLoader.load(getClass().getResource("../chattinglist/chattinglist.fxml"));
			stackpane.getChildren().add(listView);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		stackpane.getChildren().add(addChat);
		
		Search.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				// TODO Auto-generated method stub

				if (ke.getCode().equals(KeyCode.ENTER)) {

					if (Search.getText().trim().equals("")) {
						// 모든 채팅방목록 다 보여주기
						searchChat = "";
						ListView listView;
						try {
							listView = (ListView) FXMLLoader.load(getClass().getResource("../chattinglist/chattinglist.fxml"));
							stackpane.getChildren().add(listView);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else{
						searchChat="#";
						String name = Search.getText().trim();
						Iterator<Customer> itor = customer.getFriendList().iterator();
						while(itor.hasNext()){
							Customer cus = itor.next();
							if(cus.getName().equals(name)){
								searchChat = cus.getId();
							}
						}
						
						ListView listView;
						try {
							listView = (ListView) FXMLLoader.load(getClass().getResource("../chattinglist/chattinglist.fxml"));
							stackpane.getChildren().add(listView);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					stackpane.getChildren().remove(addChat);
					stackpane.getChildren().add(addChat);
				} 
			}
		});

	}
	public void GameBtnAction(ActionEvent e) {
		friendList.setFont(new Font("Cambria", 13));
		ChattingList.setFont(new Font("Cambria", 13));
		GameList.setFont(new Font("Cambria", 18));

		addChat.setVisible(false);
		addChat.setDisable(true);
	}
	public void handleAddChat(ActionEvent e){
		intviteBtnAction(null);
	}
	public void lionInfo(ActionEvent e ){
		try{
			Stage primaryStage = new Stage();

			Parent root = FXMLLoader.load(getClass().getResource("../profile/lionInfo.fxml"));
			Scene scene = new Scene(root);

			primaryStage.setTitle("라이언톡 정보");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	public void handleAddFriend(ActionEvent e){
		try{
			Stage primaryStage = new Stage();

			Parent root = FXMLLoader.load(getClass().getResource("../findFriend/findFriendView.fxml"));
			Scene scene = new Scene(root);

			primaryStage.setTitle("친구 찾기");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	public void handleLogout(ActionEvent e){
		Stage primaryStage = new Stage();
		try {
			stopClient();
			Stage stage = (Stage) friendList.getScene().getWindow();
			stage.close();

			Parent root = FXMLLoader.load(getClass().getResource("../layout/Login.fxml"));
			Scene scene = new Scene(root);

			primaryStage.setTitle("LionTalk");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();


		}catch(Exception e1)
		{
			System.out.println("무대 발생 실패");
			e1.printStackTrace();
		}

	}

	class ClassChatComparator implements Comparator<ChattingRoom> { 
		public int compare(ChattingRoom s1, ChattingRoom s2) { 	
			return -CalTimeClass.CalTime(s1.getCal(), s2.getCal());
		} 
	}

}
//@Override