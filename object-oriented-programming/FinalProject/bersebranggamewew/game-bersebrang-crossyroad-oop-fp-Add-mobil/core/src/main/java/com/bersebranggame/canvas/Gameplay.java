package com.bersebranggame.canvas;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Gameplay{
    public static int width = 8, height = 7;
    public static FitViewport viewPort = new FitViewport(width,height);;
    public Sprite sprite;
    public Texture texture;
    public static float delta = Gdx.graphics.getDeltaTime();
}
