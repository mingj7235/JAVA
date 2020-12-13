package sec05.exam02_fxml_controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class RootController implements Initializable{
	
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//컨트롤의 이벤트 처리 코드
		btn1.setOnAction(event -> System.out.println("버튼1 클릭"));
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼2 클릭");
			}
		});
		btn3.setOnAction(event -> handleBtn3Action(event));
	}
	public void handleBtn3Action (ActionEvent event) {
		System.out.println("버튼3 클릭");
	}
}
