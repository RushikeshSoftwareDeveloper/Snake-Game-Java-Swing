package com.Snak;

import javax.swing.JFrame;

public class SnakGameMain {
	public static void main(String[] args) {
		JFrame frame=new JFrame("snake Game :");
		GamePanel panel=new GamePanel();
		
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
