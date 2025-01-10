package com.bersebranggame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bersebranggame.manager.GamePlayManager;
import com.bersebranggame.manager.Gameplay;
import com.bersebranggame.manager.ScoreManager;
import com.bersebranggame.objects.character.Chicken;
import com.bersebranggame.objects.obstacle.Log;
import com.bersebranggame.objects.obstacle.Obstacle;
import com.bersebranggame.objects.point.Coin;
import com.bersebranggame.objects.vehicle.Vehicle;

public class GameRenderer {
    private SpriteBatch spriteBatch;
    private Texture backgroundTexture;
    private ScoreManager scoreManager;
    private GamePlayManager gamePlayManager;
    private Chicken chickenPlayer;

    public GameRenderer(SpriteBatch spriteBatch, Texture backgroundTexture,
                        ScoreManager scoreManager, GamePlayManager gamePlayManager,
                        Chicken chickenPlayer) {
        this.spriteBatch = spriteBatch;
        this.backgroundTexture = backgroundTexture;
        this.scoreManager = scoreManager;
        this.gamePlayManager = gamePlayManager;
        this.chickenPlayer = chickenPlayer;
    }

    public void render() {
        // Clear the screen
        ScreenUtils.clear(Color.BROWN);

        // Apply viewport
        Gameplay.viewPort.apply();
        spriteBatch.setProjectionMatrix(Gameplay.viewPort.getCamera().combined);

        // Begin sprite batch
        spriteBatch.begin();

        // Get world dimensions
        float worldWidth = Gameplay.viewPort.getWorldWidth();
        float worldHeight = Gameplay.viewPort.getWorldHeight();

        // Draw background
        spriteBatch.draw(Gameplay.background, 0, 0, worldWidth, worldHeight);

        for (Coin coin : gamePlayManager.getCoins()){
            coin.render(spriteBatch);
        }
        // Draw obstacles
        for (Obstacle obs : gamePlayManager.getObs()) {
            obs.getSprite().draw(spriteBatch);
        }

        // Draw vehicles
        for (Vehicle car : gamePlayManager.getCars()) {
            car.getSprite().draw(spriteBatch);
        }

        // Draw logs
        for (Log log : gamePlayManager.getLogs()) {
            log.getSprite().draw(spriteBatch);
        }


        // Draw chicken player
        chickenPlayer.getSprite().draw(spriteBatch);

        // Draw score
        scoreManager.drawScore();

        // End sprite batch
        spriteBatch.end();
    }

    // Optional: Dispose method to clean up resources
    public void dispose() {
        spriteBatch.dispose();
        backgroundTexture.dispose();
    }
}
