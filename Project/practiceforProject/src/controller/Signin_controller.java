package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

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

public class Signin_controller implements Initializable{
	@FXML private Label signin_time;
	
	@FXML private TextField signin_siginin_phonenum;
	@FXML private PasswordField signin_signin_password;
	@FXML private PasswordField signin_lsignin_passwordcheck;

	@FXML private Button signin_signin_btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		signin_signin_btn.setOnAction(e->handleBtnSignin(e));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		signin_time.setText(sdf.format(date));
			
	}
	public void handleBtnSignin (ActionEvent event) {
		//db에 저장해야함
		String id = signin_siginin_phonenum.getText();
		String pw = signin_signin_password.getText();
		String pwcheck = signin_lsignin_passwordcheck.getText();
		
		if (!(id.isEmpty()) && pw.equals(pwcheck)) {
			try {
				Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) signin_signin_btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("로그인실패");
		}
		
		
	}
	
	
}
