package avaj.launcher.Class.Vehicle;

import avaj.launcher.AvajLauncher;
import avaj.launcher.Class.Coordinates;



public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    @Override
    public void updateConditions() {
        if(weatherTower == null) {
            throw new IllegalStateException("WeatherTower is not registered.");
        }
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.addLongitude(10);
                this.coordinates.addHeight(2);
                AvajLauncher.getDashboard().log(this + ": It's a sunny day, let's enjoy the view!");
                break;
            case "RAIN":
                this.coordinates.addLongitude(5);
                AvajLauncher.getDashboard().log(this + ": Rain is making it hard to fly!");
                break;
            case "FOG":
                this.coordinates.addLongitude(1);
                AvajLauncher.getDashboard().log(this + ": Can't see anything in this fog!");
                break;
            case "SNOW":
                this.coordinates.subtractHeight(12);
                AvajLauncher.getDashboard().log(this + ": It's snowing, we need to be careful!");
                break;
        }
        if(this.coordinates.isOnGround()) {
            AvajLauncher.getDashboard().log(this + ": Landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "Helicopter#" + this.getName() + "(" + this.getId() + ")";
    }
}
