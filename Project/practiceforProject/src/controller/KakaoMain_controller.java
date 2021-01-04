package controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import db_connection.DB_connection_test;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KakaoMain_controller implements Initializable{
	@FXML private Label Login_time;
	@FXML private Button kakaoMain_login_btn;
	@FXML private TextField KakaoMain_login_email;
	@FXML private PasswordField KakaoMain_login_password;
	@FXML private Button kakaoMain_signin_btn;

	DB_connection_test db = new DB_connection_test();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kakaoMain_login_btn.setOnAction(e->handleBtnLogin(e));
		kakaoMain_signin_btn.setOnAction(e->handleBtnSignin(e));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Login_time.setText(sdf.format(date));
	}
	
	public void handleBtnLogin (ActionEvent event) {
		
		if (db.isExist_phone(KakaoMain_login_email.getText()) 
				&& db.isExist_pw(KakaoMain_login_password.getText())) {
			try {
				Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Friends.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) kakaoMain_login_btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//팝업창
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
