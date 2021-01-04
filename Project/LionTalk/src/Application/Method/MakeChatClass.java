package Application.Method;

import Application.chatWindow.chatWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MakeChatClass {
	
	Stage primaryStage = new Stage();
	
	public void makeChatRoom(String chatId){
		try {
//			if(primaryStage.isShowing() == true){
//				primaryStage.requestFocus();
//			}
			chatWindowController.ChattingMember = chatId;
			Parent root = FXMLLoader.load(getClass() //ChatWindow.fxml
					.getResource("../chatWindow/chatWindow.fxml"));
			
			System.out.println("확인");
			FindMemberClass fm = new FindMemberClass(); // 채팅방을 누르면 채팅방 메시지를 0으로 초기화 시켜줘야 한다.
			fm.FindChat(chatId).setMessageNum(0);
			
			Scene scene = new Scene(root);
			primaryStage.setX(250);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();

			primaryStage.setOnCloseRequest(event -> {
				chatWindowController.thread.stop();
			});
		}catch(Exception e)
		{
			System.out.println("무대 발생 실패");
			e.printStackTrace();
		}

	}
	
}
