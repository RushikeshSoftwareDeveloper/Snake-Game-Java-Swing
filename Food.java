package com.Snak;

import java.awt.*;
import java.util.Random;

public class Food {

    private int x;
    private int y;
    private Random random = new Random();

    public Food() {
        spawn();
    }

    public void spawn() {
        x = random.nextInt(GamePanel.WIDTH / GamePanel.TILE_SIZE)
                * GamePanel.TILE_SIZE;

        y = random.nextInt(GamePanel.HEIGHT / GamePanel.TILE_SIZE)
                * GamePanel.TILE_SIZE;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y,
                GamePanel.TILE_SIZE,
                GamePanel.TILE_SIZE);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
