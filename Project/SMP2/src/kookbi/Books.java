package kookbi;
//책들 -> management에서 호출할 것들
public class Books {
	private String bookName;
	private String author;
	private int volume;
	private String bookNum;
	private String rent = "대여 가능";
	private static int FbookNum = 1000;
	
	public Books() {
	}
	
	public Books(String bookName, String author, int volume) {
		this.bookName = bookName;
		this.author = author;
		this.volume = volume;
		this.bookNum = "Book-" + FbookNum++;
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
	
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}

	//	public String show () {
//		return "책 번호 : " + this.bookNum + " 책 제목 : "  + this.bookName + " 저자 : " + this.author + " 페이지 : " + this.volume; 
//	}
	@Override
	public String toString() {
		return "책 번호 : " + this.bookNum + " 책 제목 : "  + this.bookName + " 저자 : " + this.author + " 페이지 : " + this.volume + " " + this.rent; 
	}
	

}
