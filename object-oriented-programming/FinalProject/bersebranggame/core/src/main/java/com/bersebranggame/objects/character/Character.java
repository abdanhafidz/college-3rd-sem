package com.bersebranggame.objects.character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.behaviour.Moveable;
import com.bersebranggame.canvas.Gameplay;
public abstract class Character extends Sprite implements Moveable {
    private float speed;
    public Character() {
        super(new Texture(""));
        this.setSize(1,1);
        this.setPosition(0,0);
        this.speed = 1f;
        
    }

    // Constructor with all parameters
    public Character(int width, int height, float positionX, float positionY, float speed, String image) {
        super(new Texture(image));
        this.setSize(width ,height);
        this.setPosition(positionX, positionY);
        this.speed = speed;
    }

    // Constructor with optional position (position defaults to 0, 0)
    public Character(int width, int height, float speed, String image) {
        this(width, height, 0, 0, speed, image);
    }

    // Constructor with optional width, height, and position (position defaults to 0, 0, width/height default to 50)
    public Character(float speed, String image) {
        this(50, 50, 0, 0, speed, image); // Default width = 50, height = 50
    }

    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    // Methods for movement
    public void moveRight() {
        Gameplay.delta = Gdx.graphics.getDeltaTime(); 
        if(this.getX() < Gameplay.viewPort.getWorldWidth() - 1){
            this.translateX(this.speed * Gameplay.delta);
        }
    }

    public void moveLeft() {
        Gameplay.delta = Gdx.graphics.getDeltaTime(); 
        if(this.getX() >= 0){
            this.translateX(-this.speed * Gameplay.delta);
        }
    }

    public void moveUp() {
        Gameplay.delta = Gdx.graphics.getDeltaTime(); 
        if(this.getY() < Gameplay.viewPort.getWorldHeight() - 1){
            this.translateY(this.speed * Gameplay.delta);
        }else{
            Gameplay.obstacles = Gameplay.createObstacles(); 
            Gameplay.level++;
            this.setY(0);
            // Gameplay.spriteBatch = new SpriteBatch();
            // Gameplay.spriteBatch.stop
            // System.out.println(Gameplay.height);
        }
    }

    public void moveDown() {
        Gameplay.delta = Gdx.graphics.getDeltaTime(); 
        if(this.getY() >= 0 ){
            this.translateY(-this.speed * Gameplay.delta);
        }
    }
    
    public void collide() {
        // Collision logic here
    }
}
