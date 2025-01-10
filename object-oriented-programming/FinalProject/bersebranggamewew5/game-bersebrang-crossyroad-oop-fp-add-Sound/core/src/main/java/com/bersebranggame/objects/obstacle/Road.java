package com.bersebranggame.objects.obstacle;

import com.bersebranggame.manager.Gameplay;

public class Road extends Obstacle {
    public Road(){
        super(
            Gameplay.width,
            1,
            "road.png"
        );
    }
}
