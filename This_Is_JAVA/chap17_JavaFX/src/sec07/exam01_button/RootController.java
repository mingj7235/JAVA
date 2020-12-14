package sec07.exam01_button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable{
	@FXML private CheckBox chk1;
	@FXML private CheckBox chk2;
	@FXML private ImageView checkImageView;
	@FXML private ToggleGroup group; //그룹에 이미 지정된 id를 참조한다. 
	@FXML private ImageView radioImageView;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//속성감지로 !
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			//그룹의 셀렉티드 토글의 속성이 변경되었을때 실행되도록 하는 것임
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, 
					Toggle oldValue, Toggle newValue) {
						//newValue에는 선택된 라디오 버튼이 들어옴. 그래서 이걸 받아서 이미지를 바꿔주면됨.
						//바뀐 이미지 참조를 가지고와서 변환시키면됨 개쩜;
						//라벨이아니라, 라디오 버튼의 내부데이터(유저데이터) 이름을 설정하고 가져와야한다.
				radioImageView.setImage(new Image(getClass()
						.getResource("images/" + newValue.getUserData()+".png").toString()));
										//getUserData()를 통해 이름을 얻고, 그 이름에 .png를 붙여서 각각의 이미지파일을 지정해준다. 
										//이렇게되면 newValue에따라서 부여된 유저데이터에 해당하는 이미지가 들어오게된다. 
				
//				Image image = new Image(getClass()
//						.getResource("images/" + newValue.getUserData() + ".png").toString());
//				radioImageView.setImage(image);
					//이방식은 image객체를 하나 만들어서 넣은 것임. 똑같음
				
			}
		});
		
	}
	
	//버튼 이벤트 컨트롤
	public void handleBtnExitAtcion (ActionEvent e) { //핸들의 매개변수 잊지말자 ! 
		 Platform.exit();
	}
	
	public void handleChkAction (ActionEvent e) {
		// 어떤 체크박스가 되었는지 확인. 오..엄청 합리적임
		if(chk1.isSelected() && chk2.isSelected()) { //둘다 체크?
			checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses-hair.gif").toString()));
							//url을 줘야하므로 toString()까지를 해줘야한다. 
		}else if (chk1.isSelected()) { //하나만 체크?
			checkImageView.setImage(new Image(getClass().getResource("images/geek-glasses.gif").toString()));
		}else if (chk2.isSelected()) { 
			checkImageView.setImage(new Image(getClass().getResource("images/geek-hair.gif").toString()));
		}else {
			checkImageView.setImage(new Image(getClass().getResource("images/geek.gif").toString()));
		}
	}
}
