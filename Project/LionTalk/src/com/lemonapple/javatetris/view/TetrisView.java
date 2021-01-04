package com.lemonapple.javatetris.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.lemonapple.javatetris.controller.TetrisGameController;
import com.lemonapple.javatetris.model.TetrisBlock;
import com.lemonapple.javatetris.model.TetrisBoard;
import com.lemonapple.javatetris.model.ViewListener;

public class TetrisView extends JPanel implements ViewListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1998027723827046542L;
	private TetrisGameController controller;

	public TetrisView(TetrisGameController controller) {
		super();
		this.controller = controller;
		controller.addViewListener(this);
		this.setBackground(Color.WHITE);
		this.setBounds(6, 58, 250, 500);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		int height = getHeight() / 20;
		int width = getWidth() / 10;
		Color[] whichColor = { Color.WHITE, Color.BLUE, Color.RED,
				Color.YELLOW, Color.GREEN };

		// draw back.
		TetrisBoard board = controller.getBoard();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				g.setColor(whichColor[board.block[j][i]]);
				g.fillRect(width * i, height * j, width, height);
			}
		}

		// draw front
		TetrisBlock lookingBlock = controller.getCurrentBlock();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (lookingBlock.block[j][i] > 0) {
					g.setColor(whichColor[lookingBlock.block[j][i]]);
					g.fillRect(width * (i + lookingBlock.posX), height
							* (j + lookingBlock.posY), width, height);
				}
			}
		}
	}

	@Override
	public void onRePaint() {
		repaint();
	}

}
