package avaj.launcher.Class.Vehicle;

import avaj.launcher.Class.Coordinates;

public class Aircraft extends Flyable {
    protected final String name;
    protected final long id;
    protected final Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
    }


    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void updateConditions() {
        if(weatherTower == null) {
            throw new IllegalStateException("WeatherTower is not registered.");
        }
        String weather = weatherTower.getWeather(coordinates);
        System.out.println("Aircraft " + name + " (ID: " + id + ") reports weather: " + weather);
    }

    @Override
    public String toString() {
        return "Aircraft#" + name + "(" + id + ")";
    }
}
