package com.lemonapple.javatetris.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.lemonapple.javatetris.model.TetrisBlock;

public class BlocksView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7833974100778872711L;
	private TetrisBlock lookingBlock = null;

	public BlocksView() {
		super();
	}

	public void setLookingBlock(TetrisBlock lookingBlock) {
		this.lookingBlock = lookingBlock;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		if (lookingBlock == null) {
			return;
		}
		int height = getHeight() / lookingBlock.block.length;
		int width = getWidth() / lookingBlock.block[0].length;
		Color[] whichColor = { Color.WHITE, Color.BLUE, Color.RED,
				Color.YELLOW, Color.GREEN };
		for (int i = 0; i < lookingBlock.block.length; i++) {
			for (int j = 0; j < lookingBlock.block[0].length; j++) {
				g.setColor(whichColor[lookingBlock.block[j][i]]);
				g.fillRect(width * i, height * j, width, height);
			}
		}
	}

}
