package model;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MyMessagePane {
	private Pane name_pane = new Pane();
	private Pane msg_pane = new Pane();
	Label nameLb = new Label();
	Label msgLb = new Label();
	Label timeLb = new Label();
	
	public MyMessagePane(String msg) {
		name_pane.setPrefHeight(10);
		name_pane.setPrefWidth(50);
		name_pane.setPadding(new Insets(0, 0, 0, 50));
//		pane.setStyle("-fx-background-color: white");
		
		msg_pane.setMinHeight(30);
		msg_pane.setMinWidth(50);
		
		nameLb.setLayoutX(200);
		nameLb.setLayoutY(1);
		nameLb.setText("이름");
		
		msgLb.setLayoutX(400);
		msgLb.setLayoutX(80);
		msgLb.setStyle("-fx-background-color: white");
		msgLb.setText(msg);
		
		name_pane.getChildren().add(nameLb);
		msg_pane.getChildren().add(msgLb);
	}
	
	public void getPanes() {
		getName_pane();
		getMsg_pane();
	}

	public Pane getName_pane() {
		return name_pane;
	}

	public void setName_pane(Pane name_pane) {
		this.name_pane = name_pane;
	}

	public Pane getMsg_pane() {
		return msg_pane;
	}

	public void setMsg_pane(Pane msg_pane) {
		this.msg_pane = msg_pane;
	}
	

	
	
}
