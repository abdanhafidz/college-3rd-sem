package com.bersebranggame.manager;
import com.badlogic.gdx.utils.Array;
import com.bersebranggame.objects.obstacle.Log;
import com.bersebranggame.objects.obstacle.Obstacle;
import com.bersebranggame.objects.vehicle.Vehicle;

public class GamePlayManager {
    private Array<Vehicle> cars;
    private Array<Obstacle> obs;
    private Array<Log> logs;
    private SpawnManager spawnManager;

    public GamePlayManager() {
        cars = new Array<>();
        logs = new Array<>();
        spawnManager = new SpawnManager();
        obs = spawnManager.createObstacles();
    }

    public void setNewObs(){
        obs = spawnManager.createObstacles();
    }

    public void spawnEntities() {
        for (Object obstacle : obs) {
            if (obstacle instanceof Log.Road) {
                cars.add(spawnManager.spawnCar((Log.Road) obstacle));

            } else if (obstacle instanceof Log.River) {

                logs.add(spawnManager.spawnLog((Log.River) obstacle));
            }
        }
    }

    public Array<Log> getLogs() {
        return logs;
    }

    public Array<Obstacle> getObs() {
        return obs;
    }

    public Array<Vehicle> getCars() {
        return cars;
    }

    public void updateCars() {
        for (Vehicle car : cars) {
            car.update();
        }
    }

    public void updateLog() {
        for (Obstacle log : logs) {
            log.update();
        }
    }

    private void disposePreviousLevel() {

        // Dispose cars log dan juga array nya sebelumnya jika ganti level le
        for (Vehicle car : cars) {
            car.dispose();
        }

        for (Log log : logs) {
            log.dispose();
        }

        logs.clear();
        cars.clear();
    }

    public void dispose() {
        disposePreviousLevel();
    }
}
