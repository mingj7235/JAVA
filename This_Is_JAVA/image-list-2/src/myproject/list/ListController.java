package myproject.list;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Callback;
import myproject.AppMain;
import myproject.model.Phone;
import myproject.util.Transition;

public class ListController implements Initializable {
	@FXML private ImageView largeImage;
	@FXML private Button btnLeft;
	@FXML private Button btnRight;
	@FXML private StackPane listStackPane;	
	@FXML private Button btnHome;
	private ListView<Phone> listView;
	private int currentPage = 1;
	private int totalPage = 5;	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnLeft(event);
			}
		});
		
		btnRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnRight(event);
			}
		});
		
		btnHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnHome(event);
			}
		});		
		
		listView = getList(currentPage);
		listStackPane.getChildren().add(listView);
		showButton();
	}
	
	public void handleBtnLeft(ActionEvent event) {
		if(currentPage>1) { 
			currentPage--; 
			ListView<Phone> listView = getList(currentPage);
			listStackPane.getChildren().add(0, listView);
			Transition.slide(listStackPane.getChildren().get(1), 0, 350, new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					listStackPane.getChildren().remove(1);
				}
			});
			showButton();
		}
	}	
	
	public void handleBtnRight(ActionEvent event) {
		if(currentPage<totalPage) {
			currentPage++;
			ListView<Phone> listView = getList(currentPage);
			listStackPane.getChildren().add(listView);
			Transition.slide(listView, 350, 0, new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					listStackPane.getChildren().remove(0);
				}
			});
			showButton();
		}
	}
	
	public void handleBtnHome(ActionEvent event) {
		Transition.fade(AppMain.stackPane.getChildren().get(1), 1, 0, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AppMain.stackPane.getChildren().remove(1);
			}
		});
	}	
	
	private void showButton() {
		if(currentPage == 1) {
			btnLeft.setVisible(false);
		} else {
			btnLeft.setVisible(true);
		}
		if(currentPage == totalPage) {
			btnRight.setVisible(false);
		} else {
			btnRight.setVisible(true);
		}
	}
	
	private ListView<Phone> getList(int page) {
		ListView<Phone> listView = new ListView<Phone>();

		listView.setCellFactory(new Callback<ListView<Phone>, ListCell<Phone>>() {
			@Override
			public ListCell<Phone> call(ListView<Phone> param) {
				return new ListCell<Phone>() {
					 @Override
					protected void updateItem(Phone item, boolean empty) {
						super.updateItem(item, empty);
						if(empty) return;
						BorderPane borderPane = new BorderPane();
						
							ImageView imageView = new ImageView();
							imageView.setImage(new Image(getClass().getResource("../images/" + item.getSmallImage()).toString()));
							imageView.setFitWidth(30);
							imageView.setFitHeight(50);
							borderPane.setLeft(imageView);
						
							HBox hbox = new HBox();
							hbox.setPadding(new Insets(10));
							hbox.setAlignment(Pos.CENTER_LEFT);
							Label label = new Label(item.getModel());
							label.setFont(new Font(15));
							hbox.getChildren().add(label);
							borderPane.setCenter(hbox);
						
							Button button = new Button("상세보기");
							button.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									System.out.println(label.getText());
								}
							});
							borderPane.setRight(button);
							BorderPane.setAlignment(button, Pos.CENTER);
							
						setGraphic(borderPane);
					}
				};
			}
			
		});
		
		//ListView 마우스 클릭 이벤트 처리
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {
			@Override
			public void changed(ObservableValue<? extends Phone> observable,
					Phone oldValue, Phone newValue) {
				try {
					largeImage.setImage(
						new Image(
							AppMain.class.getResource("images/" + newValue.getLargeImage()).toString()
						)
					);
				} catch(Exception e) {}
			}
		});
		
		/*listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Phone phone = listView.getSelectionModel().getSelectedItem();
				largeImage.setImage(new Image(getClass().getResource("../images/" + phone.getLargeImage()).toString()));
			}
		});*/
		
		//ListView에 데이터 채우기
		ObservableList<Phone> list = FXCollections.observableArrayList();
		int start = (page-1)*3 + 1;
		int end = page*3;
		for(int i=start; i<=end; i++) {
			list.add(new Phone("스마트폰" + ((i<10)?("0" + i):i), "phone"+((i<10)?("0" + i):i)+".png", "phone" + ((i<10)?("0" + i):i) + "_large.png"));
		}
		listView.setItems(list);
		listView.getSelectionModel().select(0);
		
		//ListView 리턴
		return listView;
	}
}
