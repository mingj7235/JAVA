package sec07.exam03_viewcontrol;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable{
	@FXML private ListView<String> listView;
	@FXML private TableView<Phone> tableView;
	@FXML private ImageView imageView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//리스트뷰 부분
		listView.setItems(FXCollections.observableArrayList(
				"갤럭시S1","갤럭시S2","갤럭시S3","갤럭시S4","갤럭시S5","갤럭시S6","갤럭시S7" 
		));
		
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
								//선택된 인덱스 항목의 속성에 관하여 속성 감지를 하여 변경이 되는 것...오오....
			@Override
			public void changed(ObservableValue<? extends Number> observable, 
					Number oldValue, Number newValue) {
					//예를들어 선택전에 갤럭시 S1이었는데 S3를 누르면 oldValue는 0, newValue는 2가됨 인덱스!!
				
					tableView.getSelectionModel().select(newValue.intValue());
					//선택된 intValuse가 들어온다. 이것을 intValue로 매핑하여 들어오게됨. 
					//이렇게만하면 자동으로 스크롤이 안댐
					tableView.scrollTo(newValue.intValue()); //인덱스번호까지 자동적으로 스크롤이 내려가고 올라감
			}
		});
		
		//테이블뷰 부분
		
		ObservableList phoneList = FXCollections.observableArrayList(
				//observableList타입의 객체 -> 아이템들을 가져옴
				new Phone("갤럭시S1", "phone01.png"),
				new Phone("갤럭시S2", "phone02.png"),
				new Phone("갤럭시S3", "phone03.png"),
				new Phone("갤럭시S4", "phone04.png"),
				new Phone("갤럭시S5", "phone05.png"),
				new Phone("갤럭시S6", "phone06.png"),
				new Phone("갤럭시S7", "phone07.png")
		);
		
		TableColumn tcSmartPhone = tableView.getColumns().get(0); //첫번째 컬럼을 얻어옴
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		tcSmartPhone.setStyle("-fx-alignment: CENTER");
		
		TableColumn tcImage = tableView.getColumns().get(1); //첫번째 컬럼을 얻어옴
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		tcImage.setStyle("-fx-alignment: CENTER");
		
		tableView.setItems(phoneList);
		
		//이미지뷰 부분 -> 테이블 뷰에서 속성감시
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {
											//selectedItemProperty : 실제 해당하는 데이터를 얻을 때 사용하면 좋음. 
											//이미지를 얻을 때 좋음. 
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, 
//					Number oldValue, Number newValue) {
//					//newValue가 값이 없으면 이미지뷰의 뷰를 보여줄 수 없기때문에 조건문으로 넣어줘야한다.
//				if(newValue != null) {
//					imageView.setImage(new Image(getClass().getResource("images/phone01.png").toString()));
//				}
//			}
			
			@Override
			public void changed(ObservableValue<? extends Phone> observable, 
					//selectedItemProperty를 사용하면 바로 Phone이 들어오게됨 -> item이 들어오게된다. 
					Phone oldValue, Phone newValue) {
				if(newValue != null) {
					imageView.setImage(new Image(getClass().getResource("images/" + newValue.getImage()).toString()));
				}
			}
		});
	}
	
	public void handleBtnOkAcion (ActionEvent e) {
		String item = listView.getSelectionModel().getSelectedItem();
		
		Phone phone = tableView.getSelectionModel().getSelectedItem();
		
		System.out.println("ListView : " + item + "\n"
				+ "TableView : "  + phone.getSmartPhone()
				+ "\nTableView image : " + phone.getImage());
	}
	
	public void handleBtnCancelAcion (ActionEvent e) {
		Platform.exit();
	}
	
}
