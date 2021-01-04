package Application.Invite;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import Application.Method.MakeChatClass;
import Application.Method.SortClass;
import Application.model.Customer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InviteController implements Initializable {
	@FXML private TextField Search;
	@FXML private ListView<String> select;
	@FXML private Button make;
	@FXML private Button cancel;
	@FXML private VBox vbox;

	Customer customer = Customer.getCustomer() ;
	MakeChatClass makeChat =new MakeChatClass();
	SortClass sort = new SortClass();
	
	public void MakeBtnAction(ActionEvent e) throws IOException {
		
		Stage stage = (Stage) Search.getScene().getWindow();
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(stage);
		Parent 	parent = FXMLLoader.load(getClass().getResource("../alarm/invite_dialog.fxml"));
		
		Label txtTitle = (Label) parent.lookup("#txtTitle");
		txtTitle.setText(Select.size()+"명을 초대하시겠습니까?");
		Button btnOk = (Button) parent.lookup("#btnOk");
		
		
		btnOk.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub

				String str = customer.getId()+"/";

				Iterator<Customer> iter = Select.iterator();
				while(iter.hasNext()){
					str+=iter.next().getId()+"/";
				}
				
				str = str.substring(0, str.length()-1);
				
				System.out.println(str);

				makeChat.makeChatRoom(sort.SortChatId(str));
	
				Stage stage = (Stage) Search.getScene().getWindow();
				stage.close();
			}
		});
		
		Button btnNo = (Button) parent.lookup("#btnNo");
		btnNo.setOnAction(event->dialog.close());	
		
		Scene scene = new Scene(parent);
		dialog.setScene(scene);
		dialog.setResizable(false);
		dialog.show();
		
	}


	ArrayList<Customer> Select = new ArrayList<>();
	ListView listView = null;
	List<Customer> list = customer.getFriendList();
			
			
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub


		Search.setFocusTraversable(false);
		
		
		cancel.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				Stage a = (Stage)cancel.getScene().getWindow();
				a.close();
			}
		});

		try {
			listView = (ListView) FXMLLoader.load(getClass().getResource("../addChatlist/addChatList.fxml"));
			vbox.getChildren().add(listView);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent mouseEvent) {
						// TODO Auto-generated method stub
						if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
							int num = Integer.parseInt(newValue.toString()); // 리스트의 인덱스 숫자
							Customer c = list.get(num);
							if(!Select.contains(c) ){ // 이미 포함되어 있다면 포함하지 말아야 함.
								Select.add(c);
							}else{ // 포함되어 있는데 한번더 클릭시 목록에서 제거 한다.
								Select.remove(c);
							}
							// ListView에 표현하기 위해 Customer를 String으로 바꿔줘야 한다.
							ArrayList<String> arr = new ArrayList<>();
							for (Customer customer : Select) {
								arr.add(customer.getName());
							}
							// 변환된 ArrayList를 리스트 뷰에 넣어준다.
							select.setItems(FXCollections.observableList(arr));
							
						}
					}
				});
			}
		});

	}
	
}
