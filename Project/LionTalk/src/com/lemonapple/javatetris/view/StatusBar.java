package com.lemonapple.javatetris.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.lemonapple.javatetris.controller.TetrisGameController;
import com.lemonapple.javatetris.model.ViewListener;


public class StatusBar extends JPanel implements ViewListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1480618118565189883L;
	private TetrisGameController controller;
	private JLabel scoreNumberLabel;
	private JButton startButton;

	public StatusBar(TetrisGameController controller) {
		super();
		this.controller = controller;
		controller.addViewListener(this);
		this.setBackground(Color.RED);
		this.setBounds(6, 6, 347, 40);

		startButton = new JButton("start");
		startButton.setBounds(284, 6, 47, 27);
		startButton.addActionListener(this);
		this.setLayout(null);
		this.add(startButton);

		JLabel lblNewLabel = new JLabel("score:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel.setBounds(6, 6, 57, 27);
		this.add(lblNewLabel);

		scoreNumberLabel = new JLabel("0");
		scoreNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreNumberLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		scoreNumberLabel.setBounds(75, 6, 100, 27);
		this.add(scoreNumberLabel);
	}

	@Override
	public void onRePaint() {
		scoreNumberLabel.setText(""+controller.getScore().score);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		startButton.setVisible(false);
		controller.gameStart();
	}
}
