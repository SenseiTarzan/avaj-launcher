package avaj.launcher.Factory;

import java.util.concurrent.atomic.AtomicLong;
import avaj.launcher.Class.Coordinates;
import avaj.launcher.Class.Vehicle.Baloon;
import avaj.launcher.Class.Vehicle.Flyable;
import avaj.launcher.Class.Vehicle.Helicopter;
import avaj.launcher.Class.Vehicle.JetPlane;

public final class AircraftFactory {

    private static final AircraftFactory instance = new AircraftFactory();

    private AtomicLong idCounter = new AtomicLong(1);

    private static long getNextId() {
        return instance.idCounter.getAndIncrement();
    }

    private AircraftFactory() {
        // private constructor to prevent instantiation
    }

    public static AircraftFactory getInstance() {
        return instance;
    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type.toUpperCase()) {
            case "JETPLANE":
                return new JetPlane(getNextId(), name, coordinates);
            case "HELICOPTER":
                return new Helicopter(getNextId(), name, coordinates);
            case "BALOON":
                return new Baloon(getNextId(), name, coordinates);
        }        
        throw new IllegalArgumentException("Unknown aircraft type: " + type);
    }
}