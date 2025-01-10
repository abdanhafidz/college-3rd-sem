package com.bersebranggame.behaviour;


import com.badlogic.gdx.graphics.g2d.Sprite;

public interface Collidable {
    Boolean checkCollision(Sprite otherSprite);
};
