package model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MessagePane {

	private Pane pane = new Pane();
	Label nameLb = new Label();
	Label msgLb = new Label();
	Label timeLb = new Label();
	
	public MessagePane(String msg) {
		
		pane.setPrefHeight(50);
		pane.setPrefWidth(100);
		pane.setPadding(new Insets(0, 50, 0, 0));
//		pane.setStyle("-fx-background-color: #fee100");
		
		nameLb.setLayoutX(100);
		nameLb.setLayoutY(12);
		nameLb.setText("이름");
		
		msgLb.setLayoutX(100);
		msgLb.setLayoutX(30);
		msgLb.setMinWidth(50);
		msgLb.setMinHeight(30);
		msgLb.setStyle("-fx-background-color: #fee100");
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
