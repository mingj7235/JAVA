package sec03.exam02_FXML_layout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application{
	//자바코드로 모두 만들어내는것 -> 프로그램적 레이아웃
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("root.fxml"));
		//이 한줄로 레이아웃이 생성이됨. 자바코드로 작성하는것이 다  빠져버림. 
		//xml 파일 안에있는 내용을 바탕으로 parent라는 루트 컨테이너를 만든다. 라는 의미임. 
		
		Scene scene = new Scene(parent);
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
