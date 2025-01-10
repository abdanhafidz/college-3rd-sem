package com.bersebranggame.canvas;

import com.badlogic.gdx.graphics.Texture;
import com.bersebranggame.objects.obstacle.Car;
import com.bersebranggame.objects.character.Chicken;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private int currentLevel = 1;
    private Texture backgroundTexture;
    private List<Car> cars = new ArrayList<>();

    public void setupLevel(int level) {
        // Clear previous level resources
        disposePreviousLevel();

        // Set up new level
        currentLevel = level;

        switch(level) {
            case 1:
                setupLevelOne();
                break;
            case 2:
                setupLevelTwo();
                break;
            case 3:
                setupLevelThree();
                break;
            default:
                setupLevelOne(); // Default to first level if out of range
        }
    }

    private void setupLevelOne() {
        // Set background
        backgroundTexture = new Texture("background.jpg");

        // Set up cars for level 1
        cars.add(new Car("car.png", 0, 2, 1, 0.5f, 2f, true));
        cars.add(new Car("car2.png", Gameplay.width, 4, 1, 0.5f, 1.5f, false));
    }

    private void setupLevelTwo() {
        // Set background
        backgroundTexture = new Texture("background.jpg");

        // Increase world size slightly
        Gameplay.height += 0;
        Gameplay.viewPort.setWorldHeight(Gameplay.height);

        // Set up more challenging cars for level 2
        cars.add(new Car("car2.png", 0, 1, 1, 0.5f, 3f, true));
        cars.add(new Car("car.png", Gameplay.width, 3, 1, 0.5f, 2.5f, false));
        cars.add(new Car("car.png", 0, 5, 1, 0.5f, 1.8f, true));
    }

    private void setupLevelThree() {
        // Set background
        backgroundTexture = new Texture("background.jpg");

        // Further increase world size
        Gameplay.height += 0;
        Gameplay.viewPort.setWorldHeight(Gameplay.height);

        // Set up most challenging cars for level 3
        cars.add(new Car("car.png", 0, 1, 1, 0.5f, 4f, true));
        cars.add(new Car("car.png", Gameplay.width, 3, 1, 0.5f, 3f, false));
        cars.add(new Car("car2.png", 0, 5, 1, 0.5f, 2.5f, true));
        cars.add(new Car("car2.png", Gameplay.width, 6, 1, 0.5f, 2f, false));
    }

    public void updateCars() {
        for (Car car : cars) {
            car.update();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Texture getBackgroundTexture() {
        return backgroundTexture;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    private void disposePreviousLevel() {
        // Dispose of previous background
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }

        // Dispose of previous cars
        for (Car car : cars) {
            car.dispose();
        }
        cars.clear();
    }

    // Call this when completely done with the level manager
    public void dispose() {
        disposePreviousLevel();
    }
}
