package com.bersebranggame.objects.obstacle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.Entity;

public abstract class  Obstacle extends Entity {
    private Sprite sprite;
    private Texture texture;
    private int width, height;
    private float positionX, positionY, speed;
    private String image;


    public Obstacle() {
        super(0,0, 0,0);
    }

    // Constructor with all parameters
    public Obstacle(int width, int height, float positionX, float positionY, String image) {
        super(positionX, positionY, width, height);
        this.width = width;
        this.height = height;
        this.positionX = positionX;
        this.positionY = positionY;
        this.image = image;
        this.texture = new Texture(image);
        this.sprite = new Sprite(texture);
        this.sprite.setSize(width,height);
    }

    public Obstacle(int width, int height,  String image) {
        this(width, height, 0, 0,  image);
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    public float getPositionY() {
        return positionY ;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public void update() {

    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
