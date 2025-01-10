package com.bersebranggame.objects.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.behaviour.Moveable;
import com.bersebranggame.manager.Gameplay;

public class Log extends Obstacle implements Moveable {
    private Sprite sprite;
    private Texture texture;
    private float speed;
    private boolean movingRight;

    public Log(String imagePath, float x, float y, float width, float height, float speed, boolean movingRight) {
        this.texture = new Texture(imagePath);
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
        this.sprite.setSize(width, height);
        this.speed = speed;
        this.movingRight = movingRight;
    }

    public void update() {

        if (movingRight) {
            moveRight();

        } else {
            moveLeft();
        }
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean checkCollision(Sprite playerSprite) {
        return sprite.getBoundingRectangle().overlaps(playerSprite.getBoundingRectangle());
    }

    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
    }

    @Override
    public void moveRight() {
        float delta_ = Gdx.graphics.getDeltaTime();
        if (sprite.isFlipX()) {
            sprite.flip(true, false);
        }
        sprite.translateX(speed * delta_);

        // If car goes beyond right boundary, reset to left
        if (sprite.getX() > Gameplay.viewPort.getWorldWidth()) {
            sprite.setX(-sprite.getWidth());
        }

    }

    @Override
    public void moveLeft() {
        float delta_ = Gdx.graphics.getDeltaTime();
        if (!sprite.isFlipX()) {
            sprite.flip(true, false);
        }
        sprite.translateX(-speed * delta_);


        if (sprite.getX() < -sprite.getWidth()) {
            sprite.setX(Gameplay.viewPort.getWorldWidth());
        }
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    @Override
    public void moveUp() {
    }

    @Override
    public void moveDown() {
    }

    public static class Road extends Obstacle {
        public Road(){
            super(
                Gameplay.width,
                1,
                "road.png"
            );
        }
    }

    public static class River extends Obstacle {
        public River(){
            super(
                Gameplay.width,
                1,
                "river.png"

            );
        }
    }
}
