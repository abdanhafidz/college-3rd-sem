package com.bersebranggame.manager;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.bersebranggame.objects.obstacle.Log;
import com.bersebranggame.objects.obstacle.Obstacle;
import com.bersebranggame.objects.obstacle.River;
import com.bersebranggame.objects.obstacle.Road;
import com.bersebranggame.objects.point.Coin;
import com.bersebranggame.objects.vehicle.Vehicle;

public class GamePlayManager {
    private Array<Vehicle> cars;
    private Array<Obstacle> obs;
    private Array<Log> logs;
    private SpawnManager spawnManager;
    private Array<Coin> coins;


    public GamePlayManager() {
        cars = new Array<>();
        logs = new Array<>();
        coins = new Array<>();
        spawnManager = new SpawnManager();
        obs = spawnManager.createObstacles();
    }

    public void setNewObs(){
        obs = spawnManager.createObstacles();
    }

    public void spawnEntities() {

        for (Object obstacle : obs) {
            if (obstacle instanceof Road) {
                cars.add(spawnManager.spawnCar((Road) obstacle));

            } else if (obstacle instanceof River) {
                logs.add(spawnManager.spawnLog((River) obstacle));
            }
        }

        int numCoin = MathUtils.random(3, 10);

        for (int i = 0; i < numCoin; i++) {
            int x = MathUtils.random(1, 10);
            int y = MathUtils.random(1, 10);
            coins.add(spawnManager.spawnCoin(x, y));
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

    public Array<Coin> getCoins() {return coins;}

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

    public void updateCoin(){
        for (Coin coin : coins) {
            coin.update();
        }
    }

    public void removeCoin(int i){
        coins.removeIndex(i);
    }

    public void disposePreviousLevel() {

        // Dispose cars log dan juga array nya sebelumnya jika ganti level le
        for (Vehicle car : cars) {
            car.dispose();
        }

        for (Log log : logs) {
            log.dispose();
        }

        for (Coin coin : coins) {
            coin.dispose();
        }

        coins.clear();
        logs.clear();
        cars.clear();
    }

    public void dispose() {
        disposePreviousLevel();
    }
}
