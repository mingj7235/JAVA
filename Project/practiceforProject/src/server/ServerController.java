package server;

import java.net.ServerSocket;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;

import javafx.fxml.Initializable;

public class ServerController implements Initializable{
	
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connetion = new Vector<>();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
