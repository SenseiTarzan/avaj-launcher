package avaj.launcher.Class.Vehicle;

import avaj.launcher.Class.Tower.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
