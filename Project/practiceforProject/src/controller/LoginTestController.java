package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class LoginTestController implements Initializable{
	
	@FXML private BorderPane login;
	@FXML private Button btnMain;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnMain.setOnAction(e->handleBtnMain(e));
	}


	public void handleBtnMain(ActionEvent event) {
		StackPane root = (StackPane) btnMain.getScene().getRoot();
		root.getChildren().remove(login);
	}
}
