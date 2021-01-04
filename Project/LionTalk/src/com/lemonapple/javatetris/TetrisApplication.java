package com.lemonapple.javatetris;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lemonapple.javatetris.controller.TetrisGameController;
import com.lemonapple.javatetris.view.HoldBlockView;
import com.lemonapple.javatetris.view.MainFrame;
import com.lemonapple.javatetris.view.NextBlockView;
import com.lemonapple.javatetris.view.StatusBar;
import com.lemonapple.javatetris.view.TetrisView;

public class TetrisApplication {

	private JFrame frame;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TetrisApplication window = new TetrisApplication();
				window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TetrisApplication() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MainFrame();
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		
		TetrisGameController controller = new TetrisGameController(frame);
		
		JPanel statusBar = new StatusBar(controller);
		//frame.add(statusBar);
		frame.getContentPane().add(statusBar);
		
		JPanel tetrisView = new TetrisView(controller);
		//frame.add(tetrisView);
		frame.getContentPane().add(tetrisView);
		
		JPanel nextBlocksView = new NextBlockView(controller);
		//frame.add(nextBlocksView);
		frame.getContentPane().add(nextBlocksView);
		
 		JPanel holdingBlockView = new HoldBlockView(controller);
		frame.getContentPane().add(holdingBlockView);
	}
}
