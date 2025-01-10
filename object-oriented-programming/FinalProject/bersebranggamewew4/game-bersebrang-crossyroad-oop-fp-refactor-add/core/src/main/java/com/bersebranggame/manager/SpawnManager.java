package com.bersebranggame.manager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.bersebranggame.objects.obstacle.*;
import com.bersebranggame.objects.point.Coin;
import com.bersebranggame.objects.vehicle.Car;
import com.bersebranggame.objects.vehicle.Vehicle;
import java.util.Random;
import static com.badlogic.gdx.math.MathUtils.random;

public class SpawnManager {

    private float generateRandomSpeed(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }

    public Vehicle spawnCar(Road road) {
        boolean randomDirection = random.nextBoolean();
        float randomSpeed = generateRandomSpeed(2.0f, 4.0f);

        return new Car(
            randomDirection ? "car.png" : "car2.png",
            randomDirection ? Gameplay.width : 0,
            road.getPositionY(),
            0.9f,
            0.9f,
            randomSpeed,
            randomDirection
        );
    }

    public Log spawnLog(River river) {
        boolean randomDirection = random.nextBoolean();
        float randomSpeed = generateRandomSpeed(1.5f, 2.5f);
        return new Log(
            "log.png",
            random.nextFloat() * Gameplay.width,
            river.getPositionY(),
            3.0f,
            1.f,
            randomSpeed,
            randomDirection
        );
    }

    public Coin spawnCoin(float x, float y) {
        return  new Coin(
            x,
            y,
            0.5f,
            0.5f,
            "coin.png",
            15,
            1
        );
    };

    public Array<Obstacle> createObstacles() {
        Array<Obstacle> obstacles = new Array<>();
        Random rand = new Random();

        // Initialize the first obstacle
        Obstacle currentObstacle = createRandomObstacle();
        currentObstacle.getSprite().setY(1);  // Set the initial Y position
        currentObstacle.setPositionY(1);
        obstacles.add(currentObstacle);

        // Continue creating obstacles until the end of the screen
        while (currentObstacle.getSprite().getY() < Gameplay.height - (currentObstacle.getSprite().getHeight() + 2)) {
            float prevPositionY = currentObstacle.getSprite().getY();

            // Choose a random next obstacle
            currentObstacle = createRandomObstacle();

            // Randomly offset the Y position
            int randDist = rand.nextInt(2) + 1;  // Random distance between 1 and 2
            currentObstacle.getSprite().setY(prevPositionY + randDist);

            // Update position and add to the list
            currentObstacle.setPositionY(currentObstacle.getSprite().getY());
            obstacles.add(currentObstacle);
        }
        return obstacles;
    }

    private Obstacle createRandomObstacle() {
        Random rand = new Random();
        int randomIdx = rand.nextInt(3);  // Generate 0 or 1
        if (randomIdx == 0) {
            return new River();  // Return a River object
        } else if (randomIdx == 1) {
            return new Road();   // Return a Road object
        }
        else  {
            return new Rock();
        }
    }

}
