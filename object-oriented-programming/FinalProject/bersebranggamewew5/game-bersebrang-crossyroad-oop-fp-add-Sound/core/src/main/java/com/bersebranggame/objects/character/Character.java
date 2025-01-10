package com.bersebranggame.objects.character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.behaviour.Moveable;
import com.bersebranggame.behaviour.Update;
import com.bersebranggame.manager.Gameplay;
import com.bersebranggame.Entity;

public class Character extends Entity implements Moveable, Update {
    private  Texture texture;
    private float width, height;
    private float positionX, positionY, speed;
    private float prevX;
    private float prevY;
    private String image;

    // Constructor with all parameters
    public Character(float width, float height, float positionX, float positionY, float speed, String image) {
        super(positionX, positionY, width, height);
        this.speed = speed;
        this.image = image;
        this.texture = new Texture(image);
        this.sprite = new Sprite(texture);
        this.sprite.setSize(width,height);
    }

    // Constructor with optional position (position defaults to 0, 0)
    public Character(float width, float height, float speed, String image) {
        this(width, height, 0, 0, speed, image);
    }


    public void moveRight() {
        Gameplay.delta = Gdx.graphics.getDeltaTime();
        if(this.sprite.getX() < Gameplay.viewPort.getWorldWidth() - 1){
            this.prevX = this.sprite.getX();
            this.sprite.translateX(this.speed * Gameplay.delta);
        }
    }

    public void moveLeft() {
        Gameplay.delta = Gdx.graphics.getDeltaTime();
        if(this.sprite.getX() >= 0){
            this.prevX = this.sprite.getX();
            this.sprite.translateX(-this.speed * Gameplay.delta);
        }
    }

    public void moveUp() {
        Gameplay.delta = Gdx.graphics.getDeltaTime();
        if(this.sprite.getY() < Gameplay.viewPort.getWorldHeight() - 1){
            this.prevY = this.sprite.getY();
            this.sprite.translateY(this.speed * Gameplay.delta);
        }
    }

    public void moveDown() {
        Gameplay.delta = Gdx.graphics.getDeltaTime();
        if(this.sprite.getY() >= 0 ){
            this.prevY = this.sprite.getY();
            this.sprite.translateY(-this.speed * Gameplay.delta);
        }
    }

    @Override
    public Sprite getSprite() {
        return super.getSprite();
    }

    public float getPrevX() {
        return prevX;
    }


    public float getPrevY() {
        return prevY;
    }

    @Override
    public void update() {
    }

    @Override
    public void dispose() {
    }

}
