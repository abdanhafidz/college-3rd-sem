package com.bersebranggame.objects.obstacle;
import java.util.Random;

public class Rock extends Obstacle  {
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
