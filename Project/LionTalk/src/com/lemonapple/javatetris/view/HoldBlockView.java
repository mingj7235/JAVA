package com.lemonapple.javatetris.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.lemonapple.javatetris.controller.TetrisGameController;
import com.lemonapple.javatetris.model.TetrisBlock;
import com.lemonapple.javatetris.model.ViewListener;

public class HoldBlockView extends JPanel implements ViewListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8452706402442251300L;
	private TetrisGameController controller;
	private BlocksView blockView;

	public HoldBlockView(TetrisGameController controller) {
		super();
		this.controller = controller;
		controller.addViewListener(this);
		this.setBounds(268, 58, 85, 137);
		this.setLayout(null);

		JLabel lblHold = new JLabel("HOLD");
		lblHold.setBounds(0, 0, 85, 40);
		lblHold.setHorizontalAlignment(SwingConstants.CENTER);
		lblHold.setFont(new Font("SansSerif", Font.PLAIN, 24));
		this.add(lblHold);
		
		blockView = new  BlocksView();
		blockView.setBounds(0, 52, 85, 85);
		blockView.setBackground(Color.DARK_GRAY);
		this.add(blockView);
	}

	@Override
	public void onRePaint() {
		TetrisBlock holdingBlock = controller.getHoldingBlock();
		blockView.setLookingBlock(holdingBlock);
		blockView.repaint();
	}
}
