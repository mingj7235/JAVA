package sec02.exam02_application_lifecyle;

import java.util.Map;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application{
	String ip;
	String port;
	
	public AppMain() {
		System.out.println(Thread.currentThread().getName() + ": AppMain() 호출");//생성자를 호출하는 스레드가 무엇인지 확인
		//JavaFX Application Thread  
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init() 호출");//init()을 호출하는 스레드가 무엇인지 확인
		//init()안에 UI 생성, 변경하면안된다!
		//JavaFX Launcher 스레드
		Parameters params = this.getParameters();
		Map <String, String> map = params.getNamed();
		ip = map.get("ip");
		port = map.get("port");
		System.out.println("ip" + ip);
		System.out.println("port" + port);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start() 호출");//start()을 호출하는 스레드가 무엇인지 확인
		primaryStage.show();
		//JavaFX Application Thread 
		//UI생성, 변경
		//일반적으로 start만을 재정의해서 개발을 하곤 한다. 
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop() 호출");//stop()을 호출하는 스레드가 무엇인지 확인
		//JavaFX Application Thread 
		
	}
	
	public static void main(String[] args) {
		launch(args); //내부적으로 javaFx스레드를 작동시킴
		
		//launch를 실행하면, launch내부에서 2개의 스레드가 실행됨
		//JavaFX Application Thread가 생성자 호출 -> 
		
	}
}
