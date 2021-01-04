package Application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class  ChattingRoom implements Serializable{

	private static final long serialVersionUID = 11L;
	

	String image = "";
	String chatId="";
	String cal = "";
	int messageNum = -1;
	
	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	public ArrayList<MessageFormat> chattingMessage ;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	String chatName ="";
	

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public ArrayList<MessageFormat> getChattingMessage() {
		return chattingMessage;
	}

	public void setChattingMessage(ArrayList<MessageFormat> chattingMessage) {
		this.chattingMessage = chattingMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ChattingRoom(String chatId, ArrayList<MessageFormat> mf) {
			chattingMessage = mf;
			this.chatId = chatId;
			
	}
	
	public ChattingRoom() {
		// TODO Auto-generated constructor stub
	}
	public ChattingRoom(String chatId) {
		// TODO Auto-generated constructor stub
		this.chatId = chatId;
	}

	@Override
	public String toString() {
		return null;
	}
}
