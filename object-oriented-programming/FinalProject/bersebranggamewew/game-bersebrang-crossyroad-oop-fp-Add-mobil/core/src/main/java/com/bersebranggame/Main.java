package com.bersebranggame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bersebranggame.canvas.Gameplay;
import com.bersebranggame.canvas.LevelManager;
import com.bersebranggame.objects.character.Chicken;
import com.bersebranggame.objects.obstacle.Car;

public class Main extends ApplicationAdapter {
    private Chicken chickenPlayer;
    private SpriteBatch spriteBatch;
    private OrthographicCamera camera;
    private LevelManager levelManager;

    private boolean gameOver = false;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        // Initialize level manager
        levelManager = new LevelManager();
        levelManager.setupLevel(1); // Start with first level

        // Initialize player
        chickenPlayer = new Chicken();
        resetPlayerPosition();

        // Setup camera
        camera = new OrthographicCamera(640, 480);
        camera.position.set(640 * 0.5f, 480 * 0.5f, 0);
    }

    @Override
    public void resize(int width, int height) {
        Gameplay.viewPort.update(width, height, true);
        camera.update();
    }

    @Override
    public void render() {
        // Update delta time
        Gameplay.delta = Gdx.graphics.getDeltaTime();

        if (!gameOver) {
            input();
            logic();
        }

        draw();
    }

    private void input() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            chickenPlayer.moveLeft();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            chickenPlayer.moveRight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            chickenPlayer.moveUp();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            chickenPlayer.moveDown();
        }
    }

    private void logic() {
        // Update car positions
        levelManager.updateCars();

        // Check for car collisions
        for (Car car : levelManager.getCars()) {
            if (car.checkCollision(chickenPlayer.getSprite())) {
                gameOver = true;
                break;
            }
        }

        // Check if player reached top of screen
        if (chickenPlayer.getSprite().getY() >= Gameplay.height - chickenPlayer.getSprite().getHeight()) {
            // Advance to next level
            int nextLevel = levelManager.getCurrentLevel() + 1;

            // Setup next level (or reset if max level reached)
            if (nextLevel <= 3) {
                levelManager.setupLevel(nextLevel);
                resetPlayerPosition();
            } else {
                // Game completed
                gameOver = true;
            }
        }
    }

    private void resetPlayerPosition() {
        // Position the player at the bottom center of the screen
        float playerX = (Gameplay.width - chickenPlayer.getSprite().getWidth()) / 2;
        float playerY = 0; // Bottom of the screen

        chickenPlayer.getSprite().setPosition(playerX, playerY);
    }

    private void draw() {
        ScreenUtils.clear(Color.BROWN);
        Gameplay.viewPort.apply();

        spriteBatch.setProjectionMatrix(Gameplay.viewPort.getCamera().combined);
        spriteBatch.begin();

        // Draw background
        if (levelManager.getBackgroundTexture() != null) {
            spriteBatch.draw(levelManager.getBackgroundTexture(), 0, 0,
                Gameplay.width, Gameplay.height);
        }

        // Draw cars
        for (Car car : levelManager.getCars()) {
            car.getSprite().draw(spriteBatch);
        }

        // Draw chicken player
        chickenPlayer.getSprite().draw(spriteBatch);

        // Optional: Draw game over or level text
        if (gameOver) {
            // TODO: Add game over text rendering
        }

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        // Clean up resources
        spriteBatch.dispose();
        chickenPlayer.dispose();
        levelManager.dispose();
    }
}
