package com.bersebranggame.objects.obstacle;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bersebranggame.behaviour.Collidable;

import java.util.Random;

public class Rock extends Obstacle implements Collidable {
    public Rock() {
        super(
            2,
            1,
            "rock.png"
        );

        Random rand = new Random();
        int randomIdx = rand.nextInt(10);

        this.getSprite().setX(randomIdx);

    }
}
