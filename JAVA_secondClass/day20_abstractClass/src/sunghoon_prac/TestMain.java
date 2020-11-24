package sunghoon_prac;

public class TestMain {
	public static abstract class Printer{
		
		private String name;
		
		abstract String readFromFile (String fileName);
		
		public void printAllWords (String fileName) {
			String fileNames = readFromFile (fileName);
			System.out.println(fileNames);
		}
	}
	public static class TxtPrinter extends Printer{
		@Override
		String readFromFile(String fileName) {
			return fileName;
		}
	}
	
	public static void main(String[] args) {
		Printer printer = new TxtPrinter();
		printer.printAllWords(/*fileName : */"test.txt");
	}
	
	
}
