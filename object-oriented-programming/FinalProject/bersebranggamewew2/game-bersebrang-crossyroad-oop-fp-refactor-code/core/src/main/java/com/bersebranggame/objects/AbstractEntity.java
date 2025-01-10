package com.bersebranggame.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class AbstractEntity {
    protected Sprite sprite;
    protected float x, y;
    protected float width, height;

    public AbstractEntity(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initializeSprite();
    }

    private void initializeSprite() {
        this.sprite = new Sprite();
        this.sprite.setPosition(x, y);
        this.sprite.setSize(width, height);
    }

    public abstract void update();

    public abstract boolean checkCollision(Sprite otherSprite);

    public abstract void dispose();

    public Sprite getSprite() {
        return sprite;
    }


    // Getter and Setter methods
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        this.sprite.setX(x);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        this.sprite.setY(y);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        this.sprite.setSize(width, height);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        this.sprite.setSize(width, height);
    }
}
