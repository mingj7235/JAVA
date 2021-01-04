package com.lemonapple.javatetris.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.lemonapple.javatetris.model.TetrisBlock;
import com.lemonapple.javatetris.model.TetrisBoard;
import com.lemonapple.javatetris.model.TetrisScore;
import com.lemonapple.javatetris.model.ViewListener;

public class TetrisGameController implements Runnable, KeyListener {

	private boolean isThreadAlive;  // 스레드 유무 확인
	private JFrame frame; // 
	private TetrisScore score; // 테트리스 현 젬수
	private TetrisBoard board; // 보드판 
	private List<TetrisBlock> waitBlockList; // 기다리는 블록의 리스트
	private TetrisBlock currBlock; // 현재의 블럭
	private ArrayList<ViewListener> viewListener; //?
	private TetrisBlock holdingBlock ; // ?

	public TetrisGameController(JFrame frame) {
		this.isThreadAlive = true;
		this.frame = frame;
		this.score = new TetrisScore();
		this.board = new TetrisBoard(this);
		this.currBlock = new TetrisBlock(this);
		this.waitBlockList = new ArrayList<TetrisBlock>();
		this.viewListener = new ArrayList<ViewListener>();
	}

	@Override
	public void run() {
		openGame();
		int speed = 20;
		int interval = 2000; // 2000 * 30 / 1000 = 60(sec)
		for (int moveTrigger = 0; isThreadAlive; moveTrigger++) {
			// move
			if (moveTrigger % speed == 0) {
				currBlock.downBlock(board);
				if (moveTrigger % interval == 0)
					speed--;
			}
			// paint
			reaquestPaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		closeGame();
	}

	private void reaquestPaint() {
		// paint
		frame.repaint();
		for (ViewListener vl : viewListener) {
			vl.onRePaint();
		}
	}

	private void openGame() {
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.requestFocus();
		waitBlockList.clear();
		for (int i = 0; i < 3; i++) {
			waitBlockList.add(new TetrisBlock(this));
		}
		currBlock = waitBlockList.remove(0);
		waitBlockList.add(new TetrisBlock(this));
		
	}

	private void closeGame() {
		frame.removeKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_UP:
			currBlock.rotateBlock(board);
			break;
		case KeyEvent.VK_LEFT:
			currBlock.leftBlock(board);
			break;
		case KeyEvent.VK_RIGHT:
			currBlock.rightBlock(board);
			break;
		case KeyEvent.VK_DOWN:
			currBlock.downBlock(board);
			break;
		case KeyEvent.VK_SPACE: {
			TetrisBlock keepCurrent = currBlock;
			while (keepCurrent == currBlock)
				currBlock.downBlock(board);
		}
			break;
		case KeyEvent.VK_H:
			holdBlock();
		}
		reaquestPaint();
	}

	private void holdBlock() {
		TetrisBlock tempBlock = holdingBlock;
		holdingBlock = currBlock;
		if(tempBlock==null){
			currBlock = waitBlockList.remove(0);
			waitBlockList.add(new TetrisBlock(this));
		} else {
			currBlock = tempBlock;
			currBlock.posX = 0;
			currBlock.posY = 0;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	public void createNewBlock() {
		if (currBlock.posY <= 1)
			gameOver();
		board.addBlock(currBlock);
		currBlock = waitBlockList.remove(0);
		waitBlockList.add(new TetrisBlock(this));
	}

	public void gameOver() {
		isThreadAlive = false;
		frame.dispose();
	}

	public void addViewListener(ViewListener listener) {
		this.viewListener.add(listener);
	}

	public TetrisScore getScore() {
		return this.score;
	}

	public void gameStart() {
		Thread t = new Thread(this);
		t.start();
	}

	public TetrisBlock getCurrentBlock() {
		return currBlock;
	}

	public List<TetrisBlock> getNextBlocks() {
		return waitBlockList;
	}

	public TetrisBoard getBoard() {
		return board;
	}

	public TetrisBlock getHoldingBlock() {
		return holdingBlock;
	}

}
