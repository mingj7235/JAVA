package Application.Join;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import Application.Login.LoginController;
import Application.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JoinController implements Initializable {
	Customer cus = new Customer() ;

	 Socket socket = LoginController.socket;
	 ObjectInputStream ois = LoginController.ois;
	 ObjectOutputStream oos = LoginController.oos;



	@FXML private TextField id;
	@FXML private TextField ph;
	@FXML private TextField name;
	@FXML private Label result;

	@FXML private PasswordField pw1;
	@FXML private PasswordField pw2;

	@FXML private Button cancel;
	@FXML private Button joinMember;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public void handleJoinAction(ActionEvent e) { // 회원 가입 버튼
		try {
			if(checkJoinException()){ // 회원가입 기본 정보 예외 처리 
				socket = new Socket("localhost", 9980);
				oos = new ObjectOutputStream(socket.getOutputStream());
				cus.setId(id.getText().trim()+"#");
				
				cus.setPw(pw1.getText().trim());
				cus.setName(name.getText().trim());
				cus.setPhoneNumber(ph.getText().trim());
				cus.setTalkName("#");
				
				oos.writeObject(cus);//보낸다.
				ois = new ObjectInputStream(socket.getInputStream());

				Customer checkCus = null;
				try{
					checkCus = (Customer)ois.readObject(); // 받는다.
				}catch(IOException e1){
					return;
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				
				if(checkCus.getId().equals("#")) // 기존에 회원이 있음
				{
					result.setText("회원 아이디가 이미 존재 합니다.");
				}else{
					socket.close();
					oos.close();
					handleBtnExitAction(null);
				}

			}

		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
	}

	private boolean checkJoinException() {
		// TODO Auto-generated method stubr
		String str = id.getText();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if( !( (ch >= 48 && ch <= 57 ) || (ch>=65 && ch<=90) || ( ch>=97 && ch<=122)) )  // 48~57, 65~90, 97~122
			{// 영문 및 숫자가 아니라면 false
				result.setText("아이디는 영문 및 숫자로 구성되어야 합니다.");
				return false;
			}
		}
		
		if(id.getText().length()<1){ // 아이디 검사
			result.setText("아이디는 1글자 이상 여야 합니다.");
			return false;
		}
		if(pw1.getText().length()<1){ // 비밀번호는 검사
			result.setText("비밀번호는 한글자 이상이어야 합니다.");
			return false;
		}
		if(name.getText().length()<1){
			result.setText("이름은 1글자 이상이어야 합니다.");
			return false;
		}
		if(! (ph.getText().length() == 11) ){
			result.setText("핸드폰 번호는 11글자 이어야 합니다.");
			return false;
		}
		
		System.out.println(id.getText().length());
		
		if( id.getText().length() > 10 ){ // 아이디 검사
			System.out.println("검사 1");
			result.setText("아이디는 10글자 이하 여야 합니다.");
			return false;
		}
		if(!pw1.getText().equals(pw2.getText())){ // 비밀번호 검사 
			result.setText("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		return true;

	}
	public void handleBtnExitAction(ActionEvent e) { // 취소 버튼
		Stage stage = (Stage) cancel.getScene().getWindow();
		stage.close();
	}
	@FXML
	public void exitApplication(ActionEvent event) {
		handleBtnExitAction(null);
	}
}