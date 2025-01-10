package com.bersebranggame.objects.obstacle;

import com.bersebranggame.manager.Gameplay;

public class River extends Obstacle {
    public River(){
        super(
            Gameplay.width,
            1,
            "river.png"
        );
    }
}
