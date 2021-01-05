package controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import db_connection.KakaoDAO;
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
	@FXML private TextField signin_siginin_name;
	@FXML private TextField signin_siginin_phonenum;
	@FXML private PasswordField signin_signin_password;
	@FXML private PasswordField signin_lsignin_passwordcheck;
	@FXML private Button signin_signin_btn;
	@FXML private Button signin_Back_btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		signin_signin_btn.setOnAction(e->handleBtnSignin(e));
		signin_Back_btn.setOnAction(e->handleBtnBack(e));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		signin_time.setText(sdf.format(date));
			
	}
	public void handleBtnSignin (ActionEvent event) {
		//db에 저장해야함
		String name = signin_siginin_name.getText();
		String phoneNum = signin_siginin_phonenum.getText();
		String pw = signin_signin_password.getText();
		String pwcheck = signin_lsignin_passwordcheck.getText();
		
		if (!name.isEmpty() && !phoneNum.isEmpty() && pw.equals(pwcheck) && !pw.isEmpty()) { //1차 입력정보가 정상인지 확인
			try {
				//확인하기
				KakaoDAO dao = new KakaoDAO();
				if(!dao.signCheck(phoneNum)) { //존재하지 않다면
					dao.signIn(phoneNum, name, pw); //가입절차 실행
					Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) signin_signin_btn.getScene().getWindow();
					primaryStage.setScene(scene);
				}else {
					//이미 존재하는 번호일때 알림창
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("입력정보 비정상");
		}
	}
	
	//뒤로가기버튼
	public void handleBtnBack (ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) signin_Back_btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
