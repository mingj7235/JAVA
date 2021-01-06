package model;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MessagePane {

	private Pane pane = new Pane();
	Label nameLb = new Label();
	Label msgLb = new Label();
	Label timeLb = new Label();
	
	public MessagePane(String msg) {
		
		pane.setPrefHeight(50);
		pane.setPrefWidth(150);
		pane.setStyle("-fx-background-color: #fee100");
		
		nameLb.setLayoutX(68);
		nameLb.setLayoutY(12);
		nameLb.setText("이름");
		
		msgLb.setLayoutX(68);
		msgLb.setLayoutX(30);
		msgLb.setText(msg);
		
		pane.getChildren().add(nameLb);
		pane.getChildren().add(msgLb);
		
	}

	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}
	
	
}
