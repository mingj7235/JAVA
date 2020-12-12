package sec03.exam01_programmatical_layout;

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
		hbox.setPadding(new Insets(10)); //안쪽 여백 설정
		hbox.setSpacing(10);	// 컨트롤 간의 수평 간격 설정
		
		TextField textField = new TextField();
		textField.setPrefWidth(200);
		
		Button button = new Button();
		button.setText("홍아현");
		
		ObservableList list = hbox.getChildren();
		list.add(textField);
		list.add(button);
		
		Scene scene = new Scene(hbox);	//루트 컨테이너 hbox를 장면 생성
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
