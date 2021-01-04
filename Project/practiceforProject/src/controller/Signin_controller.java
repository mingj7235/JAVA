package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import db_connection.DB_connection_test;
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
	@FXML private TextField signin_siginin_name;
	@FXML private PasswordField signin_signin_password;
	@FXML private PasswordField signin_lsignin_passwordcheck;
	@FXML private Button signin_signin_btn;
	@FXML private Button signin_back_btn;
	
	DB_connection_test db = new DB_connection_test();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		signin_signin_btn.setOnAction(e->handleBtnSignin(e));
		signin_back_btn.setOnAction(e->handleBtnBack(e));
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		signin_time.setText(sdf.format(date));
			
	}
	public void handleBtnSignin (ActionEvent event) {
		String name = signin_siginin_name.getText();
		String phone = signin_siginin_phonenum.getText();
		String password = signin_signin_password.getText();
		String pwcheck = signin_lsignin_passwordcheck.getText();
		
		//signin
		db.insert(name, phone, password);
		
		//가입 검사 (db중복검사해야함)
		if ( !(name.isEmpty() || phone.isEmpty() || password.isEmpty() || pwcheck.isEmpty()) 
				&&  password.equals(pwcheck)) {
			try {
				Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) signin_signin_btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//popup window
			System.out.println("로그인실패");
		}
	}
	
	public void handleBtnBack (ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) signin_signin_btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
