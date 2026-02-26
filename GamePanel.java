package com.Snak;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    
	public static final int WIDTH=600;
	public static final int HEIGHT=600;
	public static final int TILE_SIZE=25;
	
	private Timer timer;
	private Snake snake;
	private Food food;
	private boolean running=false;
	private int score=0;
	
   public GamePanel() {
	   this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
	   this.setBackground(Color.black);
	   this.setFocusable(true);
	   
	   snake=new Snake();
	   food=new Food();
	   this.addKeyListener(snake);
	   startGame();
   }
	public void startGame() {
		running=true;
		timer=new Timer(100,this);
		timer.start();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(running) {
			food.draw(g);
			snake.draw(g);
			drawScore(g);
		}else {
			gameOver(g);
		}
	}
	public void drawScore(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,20));
		g.drawString("Score: "+  score, 20,30);
	}
	public void gameOver(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Arial",Font.BOLD,40));
		g.drawString("Game Over", WIDTH/3, HEIGHT/2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(running) {
			snake.move();
			snake.checkCollision();
			if(snake.getHeadX() == food.getX() &&
				snake.getHeadY()==food.getY()){
				snake.grow();
				food.spawn();
				score++;
			}
			if(!snake.isAlive()) {
				running=false;
				timer.stop();
			}
		}
		repaint();
		
	}

}
