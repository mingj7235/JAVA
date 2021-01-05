package Application.model;

import java.util.HashMap;

public  class MessageProcessing {

	public static  HashMap<String, MessageFormat> index = new HashMap<>();
	
	public synchronized static HashMap<String, MessageFormat> getIndex() {
		return index;
	}
	
}
