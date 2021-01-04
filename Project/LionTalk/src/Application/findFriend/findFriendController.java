package Application.findFriend;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import Application.Login.LoginController;
import Application.Method.FindMemberClass;
import Application.model.Customer;
import Application.model.MessageFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class findFriendController implements Initializable {
	@FXML ToggleButton btn1;
	@FXML ToggleButton btn2;
	@FXML Pane pane;

	//ph, name으로 찾기
	@FXML TextField namef;
	@FXML TextField phf;
	@FXML Label text;
	@FXML Label textb;
	@FXML Button phBtn;

	// id로 찾기 @fxml 
	@FXML TextField tf;
	@FXML ImageView img;
	@FXML Label name;
	@FXML Label talk;
	@FXML Button check;

	boolean firstInit = true;

	Socket socket = LoginController.socket;

	ObjectInputStream ois = LoginController.ois;
	ObjectOutputStream oos = LoginController.oos;

	BufferedReader br = LoginController.br;
	PrintWriter pw = LoginController.pw;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	public void handleFindBypb(ActionEvent e)
	{
		if(firstInit == false)
			pane.getChildren().remove(0);

		AnchorPane stage = null;
		try {
			stage = (AnchorPane) FXMLLoader.load(getClass().getResource("../findFriend/phItem.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pane.getChildren().add(stage);
		firstInit = false;
	}
	public void handleFindById(ActionEvent e)
	{
		if(firstInit == false)
			pane.getChildren().remove(0);

		AnchorPane stage = null;
		try {
			stage = (AnchorPane) FXMLLoader.load(getClass().getResource("../findFriend/IdItem.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pane.getChildren().add(stage);
		firstInit = false;

	}

	static public Customer cus = null;

	public void handleIdBtn(ActionEvent e){

		talk.setVisible(true);
		String id = tf.getText().trim(); // 찾아야 하는 아이디
		FindMemberClass findMem = new FindMemberClass();
		if(id.equals(Customer.getCustomer().getId())){
			talk.setText("자신은 인생의 영원한 동반자");
			return;
		}else if(! findMem.FindMemberById(id).getId().equals("#")){
			talk.setText("이미 추가 되어 있는 친구 입니다.");
			return;
		}
		try {
			oos.writeObject(new MessageFormat(Customer.getCustomer().getId(), id, 3)); // id로 친구 찾기, type은 3

			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(cus == null)continue;
				else break;
			}
			
			talk.setText(cus.getTalkName());
			
			if(cus.getId().equals("#")){
				talk.setText("존재하지 않는 회원 입니다.");
				
			}else{
				
				Stage stage = (Stage) check.getScene().getWindow();
				stage.close();
			}
			cus = null;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void handlePhBtn(ActionEvent e){
		
		String name = namef.getText().trim(); // 찾아야 하는 아이디
		String ph = phf.getText().trim(); // 찾아야 하는 핸드폰번호
		FindMemberClass findMem = new FindMemberClass();
		
		if(ph.equals(Customer.getCustomer().getPhoneNumber()) &&
				name.equals(Customer.getCustomer().getName())){
			textb.setText("");
			text.setText("자신은 인생의 영원한 동반자");
			return;
		}else if(!findMem.FindMemberByPh(ph).getId().equals("#")){
			textb.setText("");
			text.setText("이미 추가 되어 있는 친구 입니다.");
			return;
		}

		try { 
			oos.writeObject(new MessageFormat(Customer.getCustomer().getId(),name+"#"+ph, 4 )); // ph로 친구 찾기, type은 4

			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(cus == null)continue;
				else break;
			}
			if(cus.getId().equals("#")){
				textb.setText("");
				text.setText("존재하지 않는 회원 입니다.");
			}else{
				Stage stage = (Stage) phBtn.getScene().getWindow();
				stage.close();
			}

			cus = null;

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}


}
