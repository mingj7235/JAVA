package Application.sortClass;

import Application.Method.CalTimeClass;
import Application.model.ChattingRoom;

public class ClassChatComparator {
	public int compare(ChattingRoom s1, ChattingRoom s2) { 	
		return -CalTimeClass.CalTime(s1.getCal(), s2.getCal());
	} 
}
