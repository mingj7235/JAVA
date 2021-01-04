package com.lemonapple.javatetris.view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.lemonapple.javatetris.controller.TetrisGameController;
import com.lemonapple.javatetris.model.TetrisBlock;
import com.lemonapple.javatetris.model.ViewListener;

public class NextBlockView extends JPanel implements ViewListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6107120150178695850L;
	private TetrisGameController controller;
	private BlocksView blockView3;
	private BlocksView blockView2;
	private BlocksView blockView1;

	public NextBlockView(TetrisGameController controller) {
		super();
		this.controller = controller;
		controller.addViewListener(this);
		this.setBounds(268, 227, 85, 331);
		this.setLayout(null);

		JLabel lblNext = new JLabel("NEXT");
		lblNext.setBounds(0, 0, 85, 48);
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setFont(new Font("SansSerif", Font.PLAIN, 24));
		this.add(lblNext);

		blockView3 = new BlocksView();
		blockView3.setBounds(0, 246, 85, 85);
		blockView3.setBackground(Color.DARK_GRAY);
		this.add(blockView3);

		blockView2 = new BlocksView();
		blockView2.setBounds(0, 146, 85, 85);
		blockView2.setBackground(Color.DARK_GRAY);
		this.add(blockView2);

		blockView1 = new BlocksView();
		blockView1.setBounds(0, 49, 85, 85);
		blockView1.setBackground(Color.DARK_GRAY);
		this.add(blockView1);
	}

	@Override
	public void onRePaint() {
		List<TetrisBlock> nextBlocks = controller.getNextBlocks();
		blockView1.setLookingBlock(nextBlocks.get(0));
		blockView1.repaint();
		blockView2.setLookingBlock(nextBlocks.get(1));
		blockView2.repaint();
		blockView3.setLookingBlock(nextBlocks.get(2));
		blockView3.repaint();
	}
}
