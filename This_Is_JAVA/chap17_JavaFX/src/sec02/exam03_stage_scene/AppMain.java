package sec02.exam03_stage_scene;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		//레이블은 글자를 설정하는 컴포넌트다. 
		Label label = new Label();
		label.setText("Hello, JavaFX");
		label.setFont(new Font (50)); //폰트 크기
		
		//버튼
		Button button1 = new Button();
		button1.setText("확인");
		Button button2 = new Button();
		button2.setText("취소");
		button2.setOnAction(event -> Platform.exit()); //버튼에 이벤트를 넣음. 여기서는 종료하도록
		
		//라벨과 버튼을 VBox 타입의 root 컨테이너에 추가
		root.getChildren().add(label);
		root.getChildren().add(button1);
		root.getChildren().add(button2);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args); 
	}
}
