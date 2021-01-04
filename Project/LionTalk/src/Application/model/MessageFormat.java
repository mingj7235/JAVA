package Application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MessageFormat implements Serializable{
	static final long serialVersionUID = 3L;
	
	int type = 2; // 메시지의 유형 
	String chatId; // 각 채팅방의 고유한 ID  1/2/3/4 
	String from ; // 누가 보내는지에 대한 ID
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	String time =  "";
	String message = "";
	
	public MessageFormat() {
		// TODO Auto-generated constructor stub
	}
	public MessageFormat(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	public MessageFormat(String message, int type) {
		// TODO Auto-generated constructor stub
		this.message = message;
		this.type = type;
	}
	
	public MessageFormat(String message, String chatId , int type) {
		// TODO Auto-generated constructor stub
		this.chatId = chatId;
		this.message = message;
		this.type = type;
	}
	
	
	public MessageFormat(String from, String chatId, String message, 
			String time) {
		// TODO Auto-generated constructor stub
		this.chatId = chatId;
		this.message = message;
		this.time = time;
		this.from = from;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
}
