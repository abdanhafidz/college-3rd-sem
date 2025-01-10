package com.bersebranggame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bersebranggame.manager.Gameplay;

public class GameOverScreen {
    private Texture backgroundTexture;
    private BitmapFont font;
    private boolean startGame = false;

    // Store screen width and height for positioning
    private float screenWidth;
    private float screenHeight;

    public GameOverScreen() {
        backgroundTexture = new Texture("game_over_screen_background.png");
        font = new BitmapFont(Gdx.files.internal("font3.fnt"));
        font.getData().setScale(0.02f);
        font.setColor(Color.WHITE);


        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
    }


    public void render(SpriteBatch spriteBatch) {

        ScreenUtils.clear(Color.BLACK);


        // Begin drawing
        spriteBatch.begin();

        // Draw the background covering the entire screen
        spriteBatch.draw(backgroundTexture, 0, 0, screenWidth, screenHeight);

        // Adjust the text position dynamically to be in the center
        float textWidth = font.getRegion().getRegionWidth();
        float textHeight = font.getRegion().getRegionHeight();
        font.draw(spriteBatch, "Press ESC to Start", screenWidth / 2f - textWidth / 2f, screenHeight / 2f + textHeight / 2f);

        // End drawing
        spriteBatch.end();

        // Detect input to start the game
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gameplay.gameOver = false;
        }
    }

    public boolean isStartGame() {
        return startGame;
    }

    public void dispose() {
        backgroundTexture.dispose();
        font.dispose();
    }
}
