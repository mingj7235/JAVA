package Application.addChatlist;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import Application.model.Customer;
import Application.model.MessageFormat;
import Application.model.MessageProcessing;
import Application.chatWindow.chatWindowController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class addChatController implements Initializable {
	@FXML ListView<HBox> listView;
	
	Customer customer = Customer.getCustomer() ;
	
	List<Customer> list ;
	{
		list = customer.getFriendList();
	}
	void MakeOneToOneChatting(String chatId)
	{
		
		
		try {
			
			chatWindowController.ChattingMember = chatId;
			Parent root = FXMLLoader.load(getClass() //ChatWindow.fxml
					.getResource("../chatWindow/chatWindow.fxml"));
			
			
			MessageProcessing.index = new HashMap<>();
			MessageProcessing.getIndex().put(chatId, new MessageFormat(""));
			
			Stage primaryStage = new Stage();
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
	String SortChatId(String str){ //str의 값을 정렬 시켜 저장된 값에 맞게 변경한다.
		String id[] = str.split("/");
		HashSet<String> hs = new HashSet<>();
		
		for (int i = 0; i < id.length; i++) {
			hs.add(id[i]);
		}
		String res="";
		
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()){
			res += iter.next()+"/";
		}
		res = res.substring(0, res.length()-1);
		
		return res;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try{
			for (int i = 0; i < list.size(); i++) {
				HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("item.fxml"));
				ImageView image = (ImageView)hbox.lookup("#image");
				Label name = (Label)hbox.lookup("#name");
				Label talkName = (Label)hbox.lookup("#talkName");

				Customer friend = list.get(i);
				
				
				FileInputStream inputstream = new FileInputStream("C:\\profils\\"+friend.getId()+".jpg") ; 
				
				image.setImage(new Image(inputstream));
				
				name.setText(friend.getName());
				talkName.setText(friend.getTalkName());
				
				listView.getItems().add(hbox);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HBox>() {
		
			@Override
			public void changed(ObservableValue<? extends HBox> observable, HBox oldValue, HBox newValue) {
				// TODO Auto-generated method stub
				ImageView image = (ImageView)newValue.lookup("#image");
				Label model = (Label) newValue.lookup("#name");
				Label descr = (Label) newValue.lookup("#talkName");
				listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						if(event.getButton().equals(MouseButton.PRIMARY)){
							if(event.getClickCount() == 2){
								int num = listView.getSelectionModel().getSelectedIndex();
								MakeOneToOneChatting(SortChatId(customer.getId()+
										"/"+list.get(num).getId()));
							}
						};
					};
				});
				listView.setOnKeyPressed(new EventHandler<KeyEvent>() {
					public void handle(KeyEvent event) {
						if(event.getCode() == KeyCode.ENTER){
							int num = listView.getSelectionModel().getSelectedIndex();
							MakeOneToOneChatting(SortChatId(customer.getId()+
									"/"+list.get(num).getId()));
						}
					};
				});
			}
		});
		
		
	}
	
	
}
