package p1;

public class ExceptionEx01 {
	public static void main(String[] args) {
		int a = 10;
		try {
			int [] arr = new int [5];
			arr [5] = 30; //예외가 발생하면 아랫부분이 수행되지 않는다. 그래서 try catch로 잡는 것이다. 
			int c = a / 0;
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 크기가 넘어가버렸음 님아 ㅡㅡ");
		}catch (ArithmeticException e) {
			System.out.println("분모가 0이면 안댐");
		}/*catch (Exception e) { //exception은 모든 예외를 다 잡는다. 하지만 이것만 사용하면 세부 예외의 분기를 잡을 수 없다.
			System.out.println("모든 예외를 처리");
		}*/
		finally { //무조건 그 안의 코드들이 catch에 안걸리더라도 무조건 실행한다. 즉, catch로 예외 못잡더라도 반드시 실행하게 해준다.
			System.out.println("DB닫기");
			System.out.println("연결된 자원해제");
			
		}
		
		
		//예외처리를 반드시 해주어야 되는 클래스의 메소드가 있다. ex> FILE, DB연결, Thread 등등은 예외와 함께써야한다.
		//예외처리의 목적은 고치는것이 목적이아니라, 프로그램이 끝까지 잘 수행되도록 해주는 것이다. 
		
		//예외는 가장 위에꺼부터 잡히고 밑의 예외로 넘어가지 않는다.
		//먼저 나온 예외가 먼저 처리가 되면서 밑의 예외는 수행하지 않는다. 
	}
}
