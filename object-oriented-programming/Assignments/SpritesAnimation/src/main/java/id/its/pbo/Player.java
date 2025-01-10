package id.its.pbo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;

public class Player {
    private static final int SPRITE_WIDTH = 24;
    private static final int SPRITE_HEIGHT = 32;
    private static final int TOTAL_FRAMES = 8;

    private BufferedImage spriteSheet;
    private Point position;
    private int currentFrame = 0;
    private int currentRow = 0;

    public Player(String spritePath, Point startPosition) throws IOException {
        spriteSheet = ImageIO.read(getClass().getResource(spritePath));
        position = startPosition;
    }

    public void draw(Graphics g) {
        int frameX = currentFrame * SPRITE_WIDTH;
        int frameY = currentRow * SPRITE_HEIGHT;
        BufferedImage currentSprite = spriteSheet.getSubimage(frameX, frameY, SPRITE_WIDTH, SPRITE_HEIGHT);

        g.drawImage(currentSprite, position.x, position.y, SPRITE_WIDTH, SPRITE_HEIGHT, null);
    }
    //kode sebelumnya...

    private boolean isMoving = false;

    public void walk(int keyCode, int boundaryWidth, int boundaryHeight) {
        int speed = 10;
        isMoving = true;

        switch (keyCode) {
            case KeyEvent.VK_DOWN:
                currentRow = 0;
                if (position.y + SPRITE_HEIGHT < boundaryHeight) {
                    position.y += speed;
                }
                break;
            case KeyEvent.VK_UP:
                currentRow = 1;
                if (position.y > 0) {
                    position.y -= speed;
                }
                break;
            case KeyEvent.VK_LEFT:
                currentRow = 2;
                if (position.x > 0) {
                    position.x -= speed;
                }
                break;
            case KeyEvent.VK_RIGHT:
                currentRow = 3;
                if (position.x + SPRITE_WIDTH < boundaryWidth) {
                    position.x += speed;
                }
                break;
        }
    }

    public void stopWalking() {
        isMoving = false;
        currentFrame = 0;
    }

    public void animate() {
        if (isMoving) {
            currentFrame = (currentFrame + 1) % TOTAL_FRAMES;
        }
    }

}