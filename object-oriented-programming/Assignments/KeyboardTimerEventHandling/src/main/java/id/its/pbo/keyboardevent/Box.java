package id.its.pbo.keyboardevent;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Box {
    private int x, y;
    private int size;
    private int moveSpeed;
    private Color color;

    public Box(int x, int y, int size, int moveSpeed, Color initialColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.moveSpeed = moveSpeed;
        this.color = initialColor;
    }

    public void moveUp() {
        y = Math.max(0, y - moveSpeed);
    }

    public void moveDown(int maxHeight) {
        y = Math.min(maxHeight - size, y + moveSpeed);
    }

    public void moveLeft() {
        x = Math.max(0, x - moveSpeed);
    }

    public void moveRight(int maxWidth) {
        x = Math.min(maxWidth - size, x + moveSpeed);
    }

    public void changeColor() {
        Random random = new Random();
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}