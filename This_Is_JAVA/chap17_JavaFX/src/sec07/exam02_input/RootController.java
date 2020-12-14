package sec07.exam02_input;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable{
	
	@FXML private TextField txtTitle;
	@FXML private PasswordField txtPassword;
	@FXML private ComboBox <String> comboPublic;
	//combobox에 들어간 타입이 스트링이므로
	@FXML private DatePicker dateExit;
	@FXML private TextArea txtContent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void handleBtnRegAction (ActionEvent e) {
		String title = txtTitle.getText();
		System.out.println("제목 : " + title);
		
		String password = txtPassword.getText();
		System.out.println("비밀번호 : " + password);
		
		String strPublic = comboPublic.getValue();
		System.out.println("공개 여부 :" + strPublic);
		
		LocalDate strDateExit = dateExit.getValue(); //LocalDate 타입으로 담아야한다. 날짜가 선택되지 않은 경우 null이 출력된다. 
		if(strDateExit !=null){
			System.out.println("게시 종료일 : " + strDateExit.toString());
		}
		String content = txtContent.getText();
		System.out.println("내용 : " + content);
	}
	
	public void handleBtnCancelAction (ActionEvent e) { //취소버튼 누르면 종료되게끔 
		Platform.exit();
	}
	
}
