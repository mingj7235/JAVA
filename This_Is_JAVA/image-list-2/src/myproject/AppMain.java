package myproject;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppMain extends Application {
	public static StackPane stackPane;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("AppMain");
		stackPane= (StackPane) FXMLLoader.load(AppMain.class.getResource("main/main.fxml"));
		Scene scene = new Scene(AppMain.stackPane);
		
		primaryStage.setScene(scene);
		primaryStage.setWidth(350);
		primaryStage.setHeight(530);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
