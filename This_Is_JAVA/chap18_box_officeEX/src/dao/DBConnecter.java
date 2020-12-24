package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnecter {
	
	//외부 저장소의 경로
	public static final String PATH = "box_office.txt";
	
	//DAO에서 외부저장소 내용을 덮어쓰기 위한 목적으로 열 때 사용하는 메소드
	public static BufferedWriter getWriter() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH));
		
		return bw;
	}
	
	//DAO에서 외부저장소 내용을 이어쓰기 위한 목적으로 열 때 사용하는 메소드
	public static BufferedWriter getAppend() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(PATH, true));
		
		return bw;
	}
	
	//DAO에서 외부저장소 내용을 불러오기 위한 목적으로 열 때 사용하는 메소드
	public static BufferedReader getReader() throws IOException{
		BufferedReader br = null;
		
		//해당 경로에 파일이 존재하지 않다면
		try {br = new BufferedReader(new FileReader(PATH));} catch (FileNotFoundException e) {;}
		
		//null 리턴
		return br;
	}
}














