package Application.profile;

import java.net.URL;
import java.util.ResourceBundle;

//import com.lemonapple.javatetris.TetrisApplication;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class lionInfoController implements Initializable {

	@FXML private ImageView img;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		img.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
//				TetrisApplication.main(null);
			}
		});
	}
}