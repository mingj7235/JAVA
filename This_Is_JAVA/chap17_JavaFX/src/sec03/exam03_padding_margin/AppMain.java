package sec03.exam03_padding_margin;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application{
	//자바코드로 모두 만들어내는것 -> 프로그램적 레이아웃
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50,10,10,200));
			Button button = new Button();
			button.setPrefSize(100, 100);
			button.setText("hbox");
			
//		HBox hbox = new HBox();
//			Button button = new Button();
//			button.setPrefSize(100, 100);
//			button.setText("hbox");
//			HBox.setMargin(button, new Insets(10, 10, 50, 50));
			
			
		hbox.getChildren().add(button);
		
		
		Scene scene = new Scene(hbox);	//루트 컨테이너 hbox를 장면 생성
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
