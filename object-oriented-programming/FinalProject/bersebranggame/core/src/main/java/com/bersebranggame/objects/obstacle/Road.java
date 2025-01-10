package com.bersebranggame.objects.obstacle;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.bersebranggame.canvas.Gameplay;
public class Road extends Obstacle {
    private Random rand = new Random();
    private ArrayList<Car> cars = new ArrayList<Car>();
    public Road(){
        super(
            Gameplay.width,
            1,
            "road.png"
        );

    }
    @Override 
    public void setY(float y){
        System.out.println("Road Position Setted to"+y);
        super.setY(y);
        int carNum = 0;
        int numCars;
        if(Gameplay.level <= 5){
            numCars = rand.nextInt(1, Gameplay.level + 1);
        }else{
            numCars = rand.nextInt(1, 4 + Gameplay.level % 5);
        }
        int direction = 0;
        if(direction == 0){
            direction = rand.nextInt(1,3);
        }
        for(int i = 1; i<= numCars; i++){
            Car car = new Car();
            if(direction == 1){
                car.setDirection("left");
                car.setPosition(Gameplay.width - (carNum + 1), y);
            }else{
                car.setDirection("right");
                car.setPosition((carNum), y);
            }
            System.out.println("car position = "+car.getX() + " , "+ car.getY());
            
            this.cars.add(car);
        }

    }
    @Override
    public void draw(Batch batch){
        // System.out.println("road Position :" + this.getY());
        super.draw(batch);
        for (Car car : this.cars){
            // if(car.getSpeed() == 0f){
            //     car.setSpeed(rand.nextInt(1,4));
            // }

            car.setSpeed(0f);
            if(car.getDirection().equals("left")){
                // car.moveLeft();
            }else{
                // car.moveRight();
            }
            car.draw(batch);
        }
    }
}
