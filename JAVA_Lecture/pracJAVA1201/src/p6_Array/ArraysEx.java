package p6_Array;

import java.util.Arrays;

public class ArraysEx {
	public static void main(String[] args) {
		char [] charArr1 = {'J', 'A', 'V', 'A'};
		byte [] byteArr1 = {1,0,1};
		double [] doubleArr1 = {1.1, 2.2, 3.3, 4.4, 5.5};
		Car [] carArr1 = {new Car(), new Car()};
		
		int [] intArr1 = new int[3];
		intArr1 [0] =1 ;
		intArr1 [1] = 2;
		intArr1 [2] =3;
		
		char[] copyChar = Arrays.copyOf(charArr1, charArr1.length);
		byte [] copyByte = Arrays.copyOf(byteArr1,  byteArr1.length);
		double [] copyDouble = Arrays.copyOf(doubleArr1, doubleArr1.length);
		Car [] copyCar = Arrays.copyOf(carArr1, carArr1.length);
		int [] copyInt = Arrays.copyOf(intArr1, intArr1.length);
		
		for (char c : charArr1) {
			System.out.print(c + "   ");
		}
		System.out.println("\ncopy자료");
		for (char c : copyChar) {
			System.out.print(c + "   ");
		}
		System.out.println();
		for (byte b : byteArr1) {
			System.out.print(b + "   ");
		}
		System.out.println("\ncopy자료");
		for (byte b : copyByte) {
			System.out.print(b + "   ");
		}
		
		System.out.println();
		
		double [] dcor = Arrays.copyOfRange(doubleArr1, 1, 4);
		for (double d : dcor) {
			System.out.println(d + "  ");
		}
		System.out.println();
		
		char [] arr4 = new char [charArr1.length];
		char [] arr5 = {'p', 'r', 'o'};
		char [] arr6 = new char[8];
		System.arraycopy(charArr1, 0, arr4, 0, charArr1.length);
		for (char a : arr4) {
			System.out.println(a + "  ");
		}
		System.out.println();
		System.arraycopy(arr4, 0, arr6, 0, 4); //JAVA
		System.arraycopy(arr5, 0, arr6, 4, 5); //PRO
		for (char a : arr5) {
			System.out.println(a + "  ");
		}
		
	}
}

class Car {
	
}

//This is a book => 

