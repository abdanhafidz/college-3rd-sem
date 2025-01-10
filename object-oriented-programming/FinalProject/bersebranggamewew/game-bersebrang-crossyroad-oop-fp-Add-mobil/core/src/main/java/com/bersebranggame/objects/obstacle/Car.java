package com.bersebranggame.objects.obstacle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.canvas.Gameplay;

public class Car {
    private Sprite sprite;
    private Texture texture;
    private float speed;
    private boolean movingRight;

    public Car(String imagePath, float x, float y, float width, float height, float speed, boolean movingRight) {
        this.texture = new Texture(imagePath);
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
        this.sprite.setSize(width, height);
        this.speed = speed;
        this.movingRight = movingRight;
    }

    public void update() {
        float delta = Gdx.graphics.getDeltaTime();

        // Move the car
        if (movingRight) {
            sprite.translateX(speed * delta);

            // If car goes beyond right boundary, reset to left
            if (sprite.getX() > Gameplay.viewPort.getWorldWidth()) {
                sprite.setX(-sprite.getWidth());
            }
        } else {
            sprite.translateX(-speed * delta);

            // If car goes beyond left boundary, reset to right
            if (sprite.getX() < -sprite.getWidth()) {
                sprite.setX(Gameplay.viewPort.getWorldWidth());
            }
        }
    }

    public Sprite getSprite() {
        return sprite;
    }

    public boolean checkCollision(Sprite playerSprite) {
        return sprite.getBoundingRectangle().overlaps(playerSprite.getBoundingRectangle());
    }

    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
    }
}
