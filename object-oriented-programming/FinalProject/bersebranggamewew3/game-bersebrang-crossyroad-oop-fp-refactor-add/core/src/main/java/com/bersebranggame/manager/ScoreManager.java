package com.bersebranggame.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;

public class ScoreManager {
    private int score;
    private int coin;
    private String scoreText;
    private String coinText;
    private BitmapFont font;
    private BitmapFont font2;

    public ScoreManager() {
        this.score = 0;
        this.coin = 0;
        this.scoreText = "Score :" + score;
        this.coinText = "Coin :" + coin;
        this.font = new BitmapFont(Gdx.files.internal("font3.fnt"));
        this.font.getData().setScale(0.042f);
        this.font2 = new BitmapFont(Gdx.files.internal("font3.fnt"));
        this.font2.getData().setScale(0.036f);
    }

    public void incrementScore() {
        score++;
        scoreText = "Score :" + score;
    }

    public void incrementCoin() {
        coin++;
        coinText = "Coin :" + coin;
    }


    public void resetScore() {
        score = 0;
        scoreText = "Score :" + score;
    }

    public int getScore() {
        return score;
    }

    public void drawScore() {
        float margin = 0.5f;
        font.setColor(Color.WHITE);
        font.draw(Gameplay.spriteBatch, scoreText,  margin, 15 - margin); // Menampilkan skor di posisi yang diberikan

        font2.setColor(Color.GOLD);
        font2.draw(Gameplay.spriteBatch, coinText,  margin, 14 - margin);
    }
}
