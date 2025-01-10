package com.bersebranggame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.bersebranggame.Input.InputHandler;
import com.bersebranggame.manager.GamePlayManager;
import com.bersebranggame.manager.Gameplay;
import com.bersebranggame.manager.ScoreManager;
import com.bersebranggame.objects.character.Character;
import com.bersebranggame.objects.obstacle.Log;
import com.bersebranggame.objects.obstacle.Obstacle;
import com.bersebranggame.objects.obstacle.River;
import com.bersebranggame.objects.obstacle.Rock;
import com.bersebranggame.objects.point.Coin;
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
    public static boolean isContained(Rectangle inner, Rectangle outer, float margin) {
        System.out.println(inner.y + " " + outer.y);
        return inner.x >= outer.x - margin &&
            inner.x + inner.width <= outer.x + outer.width + margin &&
            inner.y >= outer.y - margin &&
            inner.y + inner.height <= outer.y + outer.height  + margin;
    }
    public void logic() {
        gamePlayManager.updateCars();
        gamePlayManager.updateLog();
        gamePlayManager.updateCoin();

        // Collision detection untuk Vehcile dengan Player
        for (Vehicle car : gamePlayManager.getCars()) {
            if (isContained( character.getSprite().getBoundingRectangle(), car.getSprite().getBoundingRectangle(),0.3f)) {
                Gameplay.gameOver = true;
            }
        }

        for (int i = 0; i < gamePlayManager.getCoins().size; i++) {
            Coin coin = gamePlayManager.getCoins().get(i);
            if (character.getSprite().getBoundingRectangle().overlaps(coin.getSprite().getBoundingRectangle())) {
                coin.dispose();
                scoreManager.incrementCoin();
                gamePlayManager.removeCoin(i);
            }
        }

        if (character.getSprite().getY() >= Gameplay.viewPort.getWorldHeight() - 1) {
            character.getSprite().setY(0);

            gamePlayManager.dispose();
            Gameplay.setBackground();
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
                if (obs instanceof River && isContained( character.getSprite().getBoundingRectangle(), obs.getSprite().getBoundingRectangle(),0.3f) && !onLog) {
                    System.out.println("Masuk sungai");
                    Gameplay.gameOver = true;
                }

                if (obs instanceof Rock &&  isContained(character.getSprite().getBoundingRectangle(), obs.getSprite().getBoundingRectangle(),0.3f)) {
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

