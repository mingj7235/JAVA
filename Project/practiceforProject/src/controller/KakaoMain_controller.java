package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class KakaoMain_controller implements Initializable{
	@FXML private Button kakaoMain_login_btn;
//	@FXML private Button kakaoMain_signin_btn;
//	@FXML private TextField KakaoMain_login_email;
//	@FXML private TextField KakaoMain_login_password;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kakaoMain_login_btn.setOnAction(e->handleBtnLogin(e));
			
	}
	public void handleBtnLogin (ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("LoginTest.fxml"));
//			Scene scene = new Scene(login);
//			Stage primaryStage = (Stage) kakaoMain_login_btn.getScene().getWindow();
//			primaryStage.setScene(scene);
			StackPane root = (StackPane) kakaoMain_login_btn.getScene().getRoot();
			root.getChildren().add(login);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
