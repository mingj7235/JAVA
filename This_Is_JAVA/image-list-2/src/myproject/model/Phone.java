package myproject.model;

public class Phone {
	private String model;
	private String smallImage;
	private String largeImage;
	
	public Phone() {}
	public Phone(String model, String smallImage, String largeImage) {
		this.model = model;
		this.smallImage = smallImage;
		this.largeImage = largeImage;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSmallImage() {
		return smallImage;
	}
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
	public String getLargeImage() {
		return largeImage;
	}
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
}
