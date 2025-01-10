package com.bersebranggame.objects.obstacle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.behaviour.Moveable;
import com.bersebranggame.canvas.Gameplay;
public class Car extends Sprite implements Moveable{
    private String direction = "left";
    private float speed = 1f;
    public Car(){
        super(new Texture("chicken.png"));
        setSize(1,1);
    }
    public Car(float positionX, float positionY){
        super(new Texture("chicken.png"));
        setSize(1,1);
        setPosition(positionX, positionY);
    }
    public Car(float positionX, float positionY, String direction){
        this(positionX, positionY);
        this.direction = direction;
    }
    public String getDirection(){
        return this.direction;
    }
    public void setDirection(String direction ){
        if(!this.direction.equals(direction)){
            this.flip(false, true);
        }
    }
    public void moveUp(){

    }

    public void moveDown(){

    }
    public void moveLeft(){
        this.translateX(-this.speed * Gameplay.delta);
    }
    public void moveRight(){
        this.translateX(this.speed * Gameplay.delta);
    }
    public void run(){

        if(this.direction == "right"){
            if(this.getX() < Gameplay.width + 1){
                // System.out.println(this.getX());
                // System.out.println(this.getY());
            System.out.println("Cars move to Right");
                this.moveRight();
            }else{
                this.setX(0);
                this.setDirection("left");
            }
            
        }else{
            if(this.getX() > 1){
                // System.out.println(this.getX());
                // System.out.println(this.getY());
                System.out.println("Cars move to Left");
                this.moveLeft();
            }else{
                this.setDirection("right");
            }
        }
    }

    public void collide(){

    }

    public void setSpeed(float speed){
        if(speed != 0){
            this.speed = speed;
        }
        
    }
    public float getSpeed(){
        return this.speed;
    }
}
