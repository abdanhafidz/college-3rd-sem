package com.bersebranggame.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.bersebranggame.manager.Gameplay;
import com.bersebranggame.objects.character.Character;

public class InputHandler {
    Character character;

    public InputHandler(Character character) {
        this.character = character;
    }

    public void handelInput() {
        Gameplay.delta = 15;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            character.moveLeft();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            character.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            character.moveUp();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            character.moveDown();
        }
    }
}
