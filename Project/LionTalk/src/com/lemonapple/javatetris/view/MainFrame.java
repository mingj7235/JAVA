package com.lemonapple.javatetris.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3393322313586210450L;

	public MainFrame() {
		super();
		this.setResizable(false);
		this.setBounds(100, 100, 359, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}
}
