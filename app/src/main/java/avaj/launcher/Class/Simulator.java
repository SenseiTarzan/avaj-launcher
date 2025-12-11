package avaj.launcher.Class;

import avaj.launcher.Class.Tower.WeatherTower;
import avaj.launcher.Parser.ScenerioParser;
import avaj.launcher.Class.Vehicle.Flyable;

public class Simulator {
    public static void run(ScenerioParser parser) {
        var flyables = parser.getFlyables();
        var simulations = parser.getNumberOfSimulations();
        var weatherTower = new WeatherTower();
        for (Flyable flyable : flyables) {
            flyable.registerTower(weatherTower);
        }
        for (int i = 0; i < simulations; i++) {
            weatherTower.changeWeather();
        }
    }
}
