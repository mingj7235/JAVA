package com.lemonapple.javatetris.model;

import com.lemonapple.javatetris.controller.TetrisGameController;

public class TetrisBoard {

	public int block[][];
	private TetrisGameController gameController;
	public static final int y = 20;
	public static final int x = 10;

	public TetrisBoard(TetrisGameController gameController) {
		this.gameController = gameController;
		block = new int[y][x];
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				block[j][i] = 0;
	}

	public void addBlock(TetrisBlock block) {
		
		for (int i = 0; i < block.block.length; i++) {
			for (int j = 0; j < block.block[i].length; j++) {
				if (block.posY + i >= y
						|| block.posX + j >= x)
					break;
				
				if (block.block[i][j] >= 1
						&& this.block[block.posY + i][block.posX + j] == 0)
					this.block[block.posY + i][block.posX + j] = block.block[i][j];
			}
		}
		fullLineCheck();
	}

	private void fullLineCheck() {
		for (int j = y - 1; j > 0; j--) {
			int lineChecker = 1;
			for (int i = 0; i < x; i++) {
				lineChecker = lineChecker * this.block[j][i];
			}
			if (lineChecker >= 1) {
				deleteLine(j);
				j++;
			}
			lineChecker = 1;
		}
	}

	public void deleteLine(int line) {
		for (int j = line; j > 0; j--)
			for (int i = 0; i < x; i++) {
				this.block[j][i] = this.block[j - 1][i];
			}
		gameController.getScore().scoreUp();
		
	}
}
