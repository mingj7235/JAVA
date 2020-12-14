package sec06.exam01_property_listener;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable{
	@FXML private Label label;
	@FXML private Slider slider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//체인지 리스너 등록
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, 
					Number oldValue, Number newValue) {
				label.setFont(new Font(newValue.doubleValue()));
				//폰트 크기를 슬라이더의 newValue값으로 넣는것임. 이것을 double타입으로 얻기위해서 doubleValue()를 쓰는것임
			}
		});
	}
}
