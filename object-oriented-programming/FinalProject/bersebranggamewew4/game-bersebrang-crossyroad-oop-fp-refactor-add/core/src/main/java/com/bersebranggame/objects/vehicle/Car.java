package com.bersebranggame.objects.vehicle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.GameLogic;
import com.bersebranggame.behaviour.Moveable;
import com.bersebranggame.manager.Gameplay;
import com.badlogic.gdx.math.Intersector;
public class Car extends Vehicle implements Moveable{
    public Car(String imagePath, float x, float y, float width, float height, float speed, boolean movingRight) {
        super(imagePath, x, y, width, height, speed, movingRight);
    }

    @Override
    public void update() {

        if (movingRight) {
            moveRight();
        } else {
            moveLeft();
        }
    }

    @Override
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

        // If car goes beyond left boundary, reset to right
        if (sprite.getX() < -sprite.getWidth()) {
            sprite.setX(Gameplay.viewPort.getWorldWidth());
        }
    }

    @Override
    public Boolean checkCollision(Sprite otherSprite) {
        return GameLogic.isContained(otherSprite.getBoundingRectangle(),sprite.getBoundingRectangle(),-0.3f);
       
    }

    @Override
    public void moveUp() {}
    @Override
    public void moveDown() {}
}
