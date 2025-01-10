package com.bersebranggame.manager;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;

public class ScoreManager {
    private int score;
    private String scoreText;
    private BitmapFont font;

    public ScoreManager(BitmapFont font) {
        this.score = 0;
        this.scoreText = "Score: " + score;
        this.font = font;
    }

    public void incrementScore() {
        score++;
        scoreText = "Score: " + score;
    }

    public void resetScore() {
        score = 0;
        scoreText = "Score: " + score;
    }

    public int getScore() {
        return score;
    }

    public void drawScore(float x, float y) {
        font.setColor(Color.WHITE);
        font.draw(Gameplay.spriteBatch, scoreText, x, y); // Menampilkan skor di posisi yang diberikan
    }
}
