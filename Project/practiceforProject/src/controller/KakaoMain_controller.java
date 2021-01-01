package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KakaoMain_controller implements Initializable{
	@FXML private Button kakaoMain_login_btn;
	@FXML private TextField KakaoMain_login_email;
	@FXML private PasswordField KakaoMain_login_password;

	@FXML private Button kakaoMain_signin_btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kakaoMain_login_btn.setOnAction(e->handleBtnLogin(e));
		kakaoMain_signin_btn.setOnAction(e->handleBtnSignin(e));
			
	}
	public void handleBtnLogin (ActionEvent event) {
		String id = KakaoMain_login_email.getText();
		String pw = KakaoMain_login_password.getText();
		
		if (id.equals("01064707235") && pw.equals("7235")) {
			try {
				Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Friends.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) kakaoMain_login_btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("로그인실패");
		}
		
		
	}
	
	public void handleBtnSignin(ActionEvent event) {
		try {
			Parent signin=FXMLLoader.load(getClass().getClassLoader().getResource("view/signin.fxml"));
			Scene scene = new Scene(signin);
			Stage primaryStage = (Stage) kakaoMain_signin_btn.getScene().getWindow();
			primaryStage.setScene(scene);
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
