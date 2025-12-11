package avaj.launcher.Class.Weather;

import avaj.launcher.Class.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = { "RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int seed = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        int index = seed % 4;
        if (index < 0) {
            index += 4;
        }
        return weather[index];
    }
    
}
