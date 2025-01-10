package com.bersebranggame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Intersector;
import com.bersebranggame.Input.InputHandler;
import com.bersebranggame.manager.GamePlayManager;
import com.bersebranggame.manager.Gameplay;
import com.bersebranggame.manager.ScoreManager;
import com.bersebranggame.objects.character.Character;
import com.bersebranggame.objects.obstacle.Log;
import com.bersebranggame.objects.obstacle.Obstacle;
import com.bersebranggame.objects.obstacle.Rock;
import com.bersebranggame.objects.vehicle.Vehicle;

public class GameLogic {
    private GamePlayManager gamePlayManager;
    private Character character;
    private InputHandler inputHandler;
    private ScoreManager scoreManager;

    public GameLogic(GamePlayManager gameplayManager, Character character, InputHandler inputHandler, ScoreManager scoreManager) {
        this.gamePlayManager = gameplayManager;
        this.character = character;
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;

    }

    public void logic() {
        gamePlayManager.updateCars();
        gamePlayManager.updateLog();

        // Collision detection with cars
        for (Vehicle car : gamePlayManager.getCars()) {
            if (car.checkCollision(character.getSprite())) {
                Gameplay.gameOver = true;
            }
        }

        if (character.getSprite().getY() >= Gameplay.viewPort.getWorldHeight() - 1) {
            character.getSprite().setY(0);

            gamePlayManager.dispose();
            gamePlayManager.setNewObs();
            gamePlayManager.spawnEntities();
            Gameplay.lastPositionY = 0;
        }

        boolean onLog = false;
        for (Log log : gamePlayManager.getLogs()) {
            if (Intersector.overlaps(character.getSprite().getBoundingRectangle(), log.getSprite().getBoundingRectangle())) {
                onLog = true;

                // Check if the player is above the log
                if (character.getSprite().getY() >= log.getSprite().getY() &&
                    character.getSprite().getY() <= log.getSprite().getY() + log.getSprite().getHeight()) {

                    // If no key is pressed, make the player move with the log

                    float delta_ = - Gdx.graphics.getDeltaTime();
                    if (log.isMovingRight()){
                        delta_ = delta_ * - 1;
                    }

                    if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
                        float logMovementX = log.getSpeed() * delta_; // Assuming the log has a movement speed
                        character.getSprite().translateX(logMovementX);
                    } else {
                        // If a key is pressed, handle input normally
                        inputHandler.handelInput();
                    }

                    if (character.getSprite().getX() >= Gameplay.viewPort.getWorldWidth() ||
                        character.getSprite().getX() < 0) {
                        Gameplay.gameOver = true;
                    }
                }
            }
        }

        if (!onLog) {
            for (Obstacle obs : gamePlayManager.getObs()) {
                if (obs instanceof Log.River && character.getSprite().getBoundingRectangle().overlaps(obs.getSprite().getBoundingRectangle())) {
                    System.out.println("Masuk sungai");
                    Gameplay.gameOver = true;
                }

                if (obs instanceof Rock && character.getSprite().getBoundingRectangle().overlaps(obs.getSprite().getBoundingRectangle())) {
                    character.getSprite().setX(character.getPrevX());
                    character.getSprite().setY(character.getPrevY());
                }
            }
        }
        // Update score klo player nyampe top screeen
        if ((int) character.getSprite().getY() > Gameplay.lastPositionY) {
            scoreManager.incrementScore();
            Gameplay.lastPositionY = (int) character.getSprite().getY();
        }
    }
}

