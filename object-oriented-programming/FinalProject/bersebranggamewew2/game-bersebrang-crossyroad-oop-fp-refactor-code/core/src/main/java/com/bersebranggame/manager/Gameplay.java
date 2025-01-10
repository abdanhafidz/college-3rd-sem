package com.bersebranggame.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Gameplay{
    public static int width = 10;
    public static int height = 10;
    public static FitViewport viewPort = new FitViewport(width,height);
    public static SpriteBatch spriteBatch = new SpriteBatch();
    public static float delta = Gdx.graphics.getDeltaTime();
    public static float lastPositionY = 0;
    public static boolean gameOver = false;

}
