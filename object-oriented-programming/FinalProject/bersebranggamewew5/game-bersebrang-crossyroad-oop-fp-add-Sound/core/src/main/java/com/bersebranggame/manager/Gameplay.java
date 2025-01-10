package com.bersebranggame.manager;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
public class Gameplay{
    public static int width = 15;
    public static int height = 15;
    public static FitViewport viewPort = new FitViewport(width,height);
    public static SpriteBatch spriteBatch = new SpriteBatch();
    public static float delta = Gdx.graphics.getDeltaTime();
    public static float lastPositionY = 0;
    public static boolean gameOver = false;
    public static Texture background;
    public static void setBackground(){
        Random rand = new Random();
        int bgNo = rand.nextInt(1,4);
        if(bgNo == 1){
            background =  new Texture("background.jpg");
        }else if(bgNo == 2){
            background = new Texture("background2.jpg");
        }else{
            background =  new Texture("background3.jpg");
        }
    }
}
