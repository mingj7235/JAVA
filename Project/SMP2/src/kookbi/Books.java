package kookbi;
//책들 -> management에서 호출할 것들
public class Books {
	
	private String bookName;
	private String author;
	private int volume;
	private String bookNum;
	private static int FbookNum = 0000;
	
	public Books() {
	}
	
	public Books(String bookName, String author, int volume, String bookNum) {
		this.bookName = bookName;
		this.author = author;
		this.volume = volume;
		this.bookNum = "Book" + FbookNum++;
	}


	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String show () {
		return this.bookNum; 
	}
	
	

}
