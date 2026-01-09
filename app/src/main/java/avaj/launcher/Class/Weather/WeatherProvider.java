package avaj.launcher.Class.Weather;

import java.time.Instant;
import java.util.Date;

import avaj.launcher.Class.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        
        long seed = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight() + new Date().getTime();
        int index = (int)(seed % 4);
        return weather[Math.abs(index)];
    }
    
}
