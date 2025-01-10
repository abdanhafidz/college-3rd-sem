package com.bersebranggame.canvas;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.bersebranggame.objects.obstacle.Obstacle;
import com.bersebranggame.objects.obstacle.River;
import com.bersebranggame.objects.obstacle.Road;
import com.bersebranggame.objects.obstacle.Car;
public class Gameplay{
    public static int width = 8;
    public static int height = 10;
    public static FitViewport viewPort = new FitViewport(width,height);
    public static SpriteBatch spriteBatch = new SpriteBatch();
    public Sprite sprite;
    public Texture texture;
    public static float delta = Gdx.graphics.getDeltaTime();
    public static int level = 1;
    public static ArrayList<Obstacle> obstacles;
    public static ArrayList<Car> cars;
    // public static Obstacle obstaclesArr;
    public static ArrayList<Obstacle> createObstacles(){
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        ArrayList<Obstacle> randomizer = new ArrayList<Obstacle>();
        randomizer.add(new River());
        randomizer.add(new Road());
        // randomizer = [ObjRiver, ObjRoad]
        Random rand = new Random();
        int choosenIdx = rand.nextInt(1,3);
        Obstacle obsChoosen = randomizer.get(choosenIdx - 1);
        obsChoosen.setY(1);
        obstacles.add(obsChoosen);
       while(obsChoosen.getY() < height - (obsChoosen.getHeight() + 2)){
            float prevObsPosition = obsChoosen.getY();
            choosenIdx = rand.nextInt(1,3);
            if(choosenIdx == 1){
                obsChoosen = new River();
            }else if(choosenIdx == 2){
                obsChoosen = new Road();
            }
            int randDist = rand.nextInt(1,4);
            obsChoosen.setY(prevObsPosition + randDist);
            obstacles.add(obsChoosen);
            
        }
        return obstacles;
    }
}
