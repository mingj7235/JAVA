package sketch;

public class Array {
	public static void main(String[] args) {
		int [] arNums = {1,2,3,4};
		System.out.println(arNums);
		
		char [] arChars = {'가','나','다','라'};
		System.out.println(arChars);
		
		
		String [] arStrings = {"ㅇㄹㅇ", "ㄱ2423"};
		System.out.println(arStrings);
		
		

		
		String result = "";
		for (int i = 0; i < arNums.length; i++) {
			result += arNums[i]+"";
		}
		System.out.println(result);
		
		
	}
}
