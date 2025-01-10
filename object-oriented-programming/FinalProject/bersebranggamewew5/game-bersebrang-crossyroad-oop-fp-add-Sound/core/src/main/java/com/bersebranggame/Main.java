package com.bersebranggame;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bersebranggame.Input.InputHandler;
import com.bersebranggame.manager.GamePlayManager;
import com.bersebranggame.manager.Gameplay;
import com.bersebranggame.manager.ScoreManager;
import com.bersebranggame.manager.SoundManager;
import com.bersebranggame.objects.character.Chicken;
import com.bersebranggame.screen.StartScreen;

public class Main extends ApplicationAdapter {

    private enum GameState {
        START, GAMEPLAY
    }

    private GameState currentState; // State game
    private Texture backgroundTexture;
    private Texture startScreenBackground; // Latar belakang untuk layar awal
    private Chicken chickenPlayer;
    private SpriteBatch spriteBatch;
    private boolean onLog = false;
    private InputHandler inputHandler;
    private GamePlayManager gamePlayManager;
    private ScoreManager scoreManager;
    private BitmapFont font;
    private BitmapFont font2;
    private StartScreen startScreen;
    private GameRenderer gameRenderer; // New game renderer
    private GameLogic gameLogic;
    private SoundManager soundManager;

    @Override
    public void create() {
        startScreen = new StartScreen();
        currentState = GameState.START;
        spriteBatch = Gameplay.spriteBatch;
        startScreenBackground = new Texture("start_screen_background.png");
        Gameplay.setBackground();
        backgroundTexture = Gameplay.background;
        scoreManager = new ScoreManager();
        gamePlayManager = new GamePlayManager();
        chickenPlayer = new Chicken();
        inputHandler = new InputHandler(chickenPlayer);
        gameRenderer = new GameRenderer(spriteBatch, backgroundTexture, scoreManager, gamePlayManager, chickenPlayer);
        soundManager = new SoundManager();
        soundManager.initialize();
        gameLogic = new GameLogic(gamePlayManager, chickenPlayer, inputHandler, scoreManager, soundManager);
    }

    @Override
    public void render() {
        switch (currentState) {
            case START:
                startScreen.render(spriteBatch);
                if (startScreen.isStartGame()) {
                    currentState = GameState.GAMEPLAY;
                    gamePlayManager.spawnEntities();
                    soundManager.playBackgroundMusic();
                    startScreenBackground.dispose();
                }
                break;


            case GAMEPLAY:
                if (!Gameplay.gameOver) {
                    inputHandler.handelInput();
                    gameLogic.logic();
                }
                gameRenderer.render();
                break;
        }
    }

    @Override
    public void resize(int width, int height) {
        Gameplay.viewPort.update(width, height, true);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        startScreenBackground.dispose();
        backgroundTexture.dispose();
        font.dispose();
        gamePlayManager.dispose();
    }
}
