package com.bersebranggame.manager;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Gdx;

public class SoundManager {

    private Sound coinSound;
    private Sound crashSound;
    private Sound backgroundMusic;

    public void initialize() {
        coinSound = Gdx.audio.newSound(Gdx.files.internal("coin.mp3"));
        backgroundMusic = Gdx.audio.newSound(Gdx.files.internal("pixel.wav"));
    }

    public void playCoinSound() {
        coinSound.play();
    }

    public void playCrashSound() {
        crashSound.play();
    }

    public void playBackgroundMusic() {
        backgroundMusic.loop();
    }

    public void stopBackgroundMusic() {
        backgroundMusic.stop();
    }

    public void dispose() {
        coinSound.dispose();
        crashSound.dispose();
        backgroundMusic.dispose();
    }
}
