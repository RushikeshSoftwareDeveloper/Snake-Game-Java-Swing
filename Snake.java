package com.Snak;


import java.awt.*;
import java.awt.event.*;

public class Snake implements KeyListener {

    private int[] x = new int[600];
    private int[] y = new int[600];

    private int bodyParts = 3;
    private char direction = 'R';
    private boolean alive = true;

    public void move() {

        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U': y[0] -= GamePanel.TILE_SIZE; break;
            case 'D': y[0] += GamePanel.TILE_SIZE; break;
            case 'L': x[0] -= GamePanel.TILE_SIZE; break;
            case 'R': x[0] += GamePanel.TILE_SIZE; break;
        }
    }

    public void grow() {
        bodyParts++;
    }

    public void checkCollision() {

        if (x[0] < 0 || x[0] >= GamePanel.WIDTH ||
            y[0] < 0 || y[0] >= GamePanel.HEIGHT) {
            alive = false;
        }

        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                alive = false;
            }
        }
    }

    public void draw(Graphics g) {

        for (int i = 0; i < bodyParts; i++) {
            if (i == 0)
                g.setColor(Color.green);
            else
                g.setColor(new Color(45,180,0));

            g.fillRect(x[i], y[i],
                    GamePanel.TILE_SIZE,
                    GamePanel.TILE_SIZE);
        }
    }

    public int getHeadX() { return x[0]; }
    public int getHeadY() { return y[0]; }
    public boolean isAlive() { return alive; }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (direction != 'R') direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') direction = 'R';
                break;
            case KeyEvent.VK_UP:
                if (direction != 'D') direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') direction = 'D';
                break;
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

	
}
