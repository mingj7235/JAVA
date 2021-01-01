package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.*;

public class KakaoMain_controller implements Initializable{
	@FXML private Button kakaoMain_login_btn;
	@FXML private Button kakaoMain_signin_btn;
	@FXML private TextField KakaoMain_login_email;
	@FXML private TextField KakaoMain_login_password;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kakaoMain_login_btn.setOnAction(e->handleBtnLogin(e));
		kakaoMain_signin_btn.setOnAction(e->handleBtnSignin(e));
			
	}
	public void handleBtnLogin (ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Friends.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) kakaoMain_login_btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
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
