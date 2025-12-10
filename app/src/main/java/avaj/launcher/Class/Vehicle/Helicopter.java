package avaj.launcher.Class.Vehicle;

import avaj.launcher.Class.Tower.WeatherTower;

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
                System.out.println("Helicopter#" + this.getName() + "(" + this.getId() + "): It's a sunny day, let's enjoy the view!");
                break;
            case "RAIN":
                this.coordinates.addLongitude(5);
                System.out.println("Helicopter#" + this.getName() + "(" + this.getId() + "): Rain is making it hard to fly!");
                break;
            case "FOG":
                this.coordinates.addLongitude(1);
                System.out.println("Helicopter#" + this.getName() + "(" + this.getId() + "): Can't see anything in this fog!");
                break;
            case "SNOW":
                this.coordinates.subtractHeight(12);
                System.out.println("Helicopter#" + this.getName() + "(" + this.getId() + "): It's snowing, we need to be careful!");
                break;
        }
        if(this.coordinates.isOnGround()) {
            System.out.println("Helicopter#" + this.getName() + "(" + this.getId() + ") landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "Helicopter#" + this.getName() + "(" + this.getId() + ")";
    }
}
