package com.bersebranggame.objects.obstacle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
public abstract class Obstacle extends Sprite {
    // Default constructor
    public Obstacle() {
        this.setSize(0,0);
        this.setPosition(0, 0);
    }

    // Constructor with all parameters
    public Obstacle(int width, int height, float positionX, float positionY, String image) {
        super(new Texture(image));
        this.setSize(width, height);
        this.setPosition(positionX, positionY);
        
    }

    // Constructor with optional position (position defaults to 0, 0)
    public Obstacle(int width, int height,  String image) {
        this(width, height, 0, 0,  image);
    }
    @Override
    public void draw(Batch batch){
        super.draw(batch);
    }

}