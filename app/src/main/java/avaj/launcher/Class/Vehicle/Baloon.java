package avaj.launcher.Class.Vehicle;

import avaj.launcher.Class.Tower.WeatherTower;

import avaj.launcher.Class.Coordinates;

public final class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        if(weatherTower == null) {
            throw new IllegalStateException("WeatherTower is not registered.");
        }
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.addLongitude(2);
                this.coordinates.addHeight(4);
                System.out.println("Balloon#" + this.getName() + "(" + this.getId() + "): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN": 
                this.coordinates.subtractHeight(5);
                System.out.println("Balloon#" + this.getName() + "(" + this.getId() + "): Damn you rain! You messed up my balloon.");
                break;
            case "FOG":
                this.coordinates.subtractHeight(3);
                System.out.println("Balloon#" + this.getName() + "(" + this.getId() + "): Can't see anything in this fog.");
                break;
            case "SNOW":
                this.coordinates.subtractHeight(15);
                System.out.println("Balloon#" + this.getName() + "(" + this.getId() + "): It's snowing. We're gonna crash.");
                break;
            }
        
        if(this.coordinates.isOnGround()) {
            weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "Balloon#" + this.getName() + "(" + this.getId() + ")";
    }
}