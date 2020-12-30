package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//컨트롤러
public class UserDAO implements Initializable{
	@FXML private ImageView wifi;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		wifi.setImage(new Image(getClass().getResource("wifi").toString()));
	}

}
