package avaj.launcher.Class.Tower;

import avaj.launcher.Class.Coordinates;

public final class WeatherTower extends Tower {
    private static String[] weatherConditions = {"RAIN", "FOG", "SUN", "SNOW"};

    public String getWeather(Coordinates coordinates) {
        int seed = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        int index = seed % weatherConditions.length;
        return weatherConditions[index];
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
