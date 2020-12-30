package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KakaoFriends extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent friends = (Parent)FXMLLoader.load(getClass().getResource("Friends.fxml"));
		Scene scene_friends = new Scene (friends);
		
		primaryStage.setTitle("Friends");
		primaryStage.setScene(scene_friends);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
