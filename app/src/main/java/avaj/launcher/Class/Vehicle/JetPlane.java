package avaj.launcher.Class.Vehicle;

import avaj.launcher.Class.Coordinates;

public final class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
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
                this.coordinates.addHeight(2);
                this.coordinates.addLatitude(10);
                System.out.println(this + ": It's a sunny day, let's fly higher!");
                break;
            case "RAIN":
                this.coordinates.addLatitude(5);
                System.out.println(this + ": It's raining. Better watch out for lightnings.");
                break;
            case "FOG":
                this.coordinates.addLatitude(1);
                System.out.println(this + ": Can't see much in this fog.");
                break;
            case "SNOW":
                this.coordinates.subtractHeight(7);
                System.out.println(this + ": OMG! winter is coming!");
                break;
        }
        if(this.coordinates.isOnGround()) {
            System.out.println(this + ": Landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "JetPlane#" + this.getName() + "(" + this.getId() + ")";
    }
}
