package Application.Login;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import Application.model.Customer;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable {
	Customer cus = new Customer() ;

	public static Socket socket ;
	public static ObjectInputStream ois;
	public static ObjectOutputStream oos;
	public static BufferedReader br ;
	public static PrintWriter pw;
	public static BufferedWriter bw ;


	@FXML private TextField textField;
	@FXML private PasswordField passwordField;
	@FXML private Button btn;
	@FXML private AnchorPane anchorPane;
	@FXML private Button join;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn.setDisable(true);

		passwordField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if(passwordField.getLength() > 0){
					btn.setDisable(false);
				}
				else{
					btn.setDisable(true);
				}

			}
		});
		passwordField.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent ke)
			{
				if (ke.getCode().equals(KeyCode.ENTER))
				{
					ActionEvent e = new ActionEvent();
					try {
						handleBtnAction(e);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(ke.getCode().equals(KeyCode.ESCAPE))
				{
					Stage a = (Stage)passwordField.getScene().getWindow();
					a.close();
				}
			}
		});
	}
	public void handleJoinAction(ActionEvent e) {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass()
					.getResource("../Join/joinView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../Join/Join.css").toString());

			primaryStage.setScene(scene);
			primaryStage.setTitle("회원가입");
			primaryStage.setX(750);
			primaryStage.setY(10);

			primaryStage.show();
			primaryStage.setResizable(false);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("무대 발생 에러");
			e1.printStackTrace();
		}
	}

	public void handleBtnAction(ActionEvent e) throws Exception {
		cus = new Customer() ;
		
		cus.setId(textField.getText().trim());
		cus.setPw(passwordField.getText().trim());

		try {
			socket = new Socket("localhost", 9980);

			oos = new ObjectOutputStream(socket.getOutputStream());
			
			//로그인 했을 시 서버로 ID와 PW정보를 보낸다.
			oos.writeObject(cus);//보낸다.
	
			ois = new ObjectInputStream(socket.getInputStream());
			
			bw = new BufferedWriter(new OutputStreamWriter( // 이미지 전송 
					socket.getOutputStream()));

			try{
				//서버로 부터 로그인 성공 유무를 받는다.
				Customer.setCustomer( (Customer)ois.readObject()); // 받는다.
			}catch(IOException e1){
				e1.printStackTrace();
				return;
			}

			cus = Customer.getCustomer();

			InputStreamReader is = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(is);

			OutputStreamWriter os = new OutputStreamWriter(socket.getOutputStream());
			pw = new PrintWriter(os);


		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 

		if(cus.getName().equals("#")){
			Stage stage = (Stage) textField.getScene().getWindow();
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(stage);
			dialog.setTitle("라이언톡");

			Parent parent = FXMLLoader.load(getClass().getResource("../alarm/login_dialog.fxml"));
			Label txtTitle = (Label) parent.lookup("#txtTitle");
			if(cus.getId().equals("#")){
				txtTitle.setText("존재하지 않는 회원 입니다.");
				socket.close();
			}else{
			txtTitle.setText("비밀번호를 확인해 주세요.");
			socket.close();
			}
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(event->dialog.close());	
			Scene scene = new Scene(parent);

			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		}else if(cus.getId().equals("##")){
			Stage stage = (Stage) textField.getScene().getWindow();
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(stage);
			dialog.setTitle("라이언톡");

			Parent parent = FXMLLoader.load(getClass().getResource("../alarm/login_dialog.fxml"));
			Label txtTitle = (Label) parent.lookup("#txtTitle");
			txtTitle.setText("이미 로그인이 되어 있는 회원 입니다.");
			
			Button btnOk = (Button) parent.lookup("#btnOk");
			btnOk.setOnAction(event->dialog.close());	
			Scene scene = new Scene(parent);

			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		}
		else if(!cus.getId().equals("#") && !cus.getName().equals("#")){
			
			// 해당 로그인이 성공한 후 서버로부터 프로필 이미지를 받는다.
			while(true){
				//먼저 이미지의 파일 이름을 받는다.
				String imageFileName = br.readLine();
				
				if(imageFileName.equals("End")){
					break;
				}
				// 받은 것을 바탕으로 파일 객체 생성
				File createdFile = new File("C:/profils", imageFileName); 
				
				File desDir = new File("C:/profils");
				if(!desDir.exists()){
					desDir.mkdir();
					System.out.println("폴더 생성 완료");
				}
				FileOutputStream fos = null;
				BufferedOutputStream bos = null;

				int data = -1;

				fos = new FileOutputStream(createdFile);
				bos = new BufferedOutputStream(fos);

				while(true){
					if((data = br.read()) == 65535){
						break;
					}
					bos.write(data);
				}

				bos.close();
				fos.close();
				System.out.println("THE END --- makeImage");
			}
			
			Stage stage = (Stage) btn.getScene().getWindow();
			Stage primaryStage = new Stage();
			try {
				Parent root = FXMLLoader.load(getClass()
						.getResource("../FreindList/FriendShow.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setX(750);
				primaryStage.setY(10);
				primaryStage.setTitle(cus.getName()+"님의 채팅창");

				primaryStage.show();
				primaryStage.setResizable(false);
				primaryStage.setOnCloseRequest(event->exitApplication(null));

				stage.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("무대 발생 에러");
				e1.printStackTrace();
			}

		}
	}	
	@FXML
	public void exitApplication(ActionEvent event) {
		System.out.println("클라이언트 서버 연결 종료");
		try {
			Stage stage = (Stage) btn.getScene().getWindow();
			stage.close();

			socket.close();
			ois.close();
			oos.close();
			br.close();
			pw.close();
			
			Platform.exit();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handleBtnExitAction(ActionEvent e) {
		Platform.exit();
	}
}