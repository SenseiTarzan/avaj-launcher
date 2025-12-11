package avaj.launcher.Class.Tower;

import avaj.launcher.Class.Coordinates;
import avaj.launcher.Class.Weather.WeatherProvider;

public final class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
