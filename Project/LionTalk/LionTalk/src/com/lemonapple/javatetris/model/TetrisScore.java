package com.lemonapple.javatetris.model;

public class TetrisScore {
	public int score;//현재 점수
	
	public TetrisScore(){
		score = 0;
	}
	
	public void scoreUp(){
		score = score + 100;
	}
}
