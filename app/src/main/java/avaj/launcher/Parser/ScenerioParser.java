package avaj.launcher.Parser;

import avaj.launcher.Class.Vehicle.Flyable;
import avaj.launcher.Factory.AircraftFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScenerioParser {
    public  class ScenerioException extends Exception {
        public ScenerioException(String message) {
            super(message);
        }
    }

    private String filePath;

    public int numberOfSimulations;

    private List<Flyable> flyables;

    public ScenerioParser(String filePath)
        throws IOException, NumberFormatException, ScenerioException
    {
        this.filePath = filePath;
        load();
    }

    public void load() throws IOException, NumberFormatException, ScenerioException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        if (line == null) {
            reader.close();
            throw new IOException("Empty scenario file.");
        }

        int simulations;
        try {
            simulations = Integer.parseInt(line.trim());
            if (simulations < 0) {
                reader.close();
                throw new NumberFormatException("Number of simulations must be non-negative.");
            }
        } catch (NumberFormatException e) {
            reader.close();
            throw new NumberFormatException("Invalid number of simulations: " + line);
        }
        List<Flyable> flyables = new ArrayList<Flyable>();
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split("\\s+");
            if (parts.length != 5) {
                throw new ScenerioException("Invalid aircraft description: " + line);
            }
            String type = parts[0];
            String name = parts[1];
            int longitude, latitude, height;
            try {
                longitude = Integer.parseInt(parts[2]);
                latitude = Integer.parseInt(parts[3]);
                height = Integer.parseInt(parts[4]);
            } catch (NumberFormatException e) {
                flyables.clear();
                throw new ScenerioException("Invalid coordinates in line: " + line);
            }
            Flyable flyable = AircraftFactory.getInstance().newAircraft(type, name, longitude, latitude, height);
            flyables.add(flyable);
        }
        this.numberOfSimulations = simulations;
        this.flyables = flyables;
        reader.close();
    }

    public List<Flyable> getFlyables() {
        return flyables;
    }

    public int getNumberOfSimulations() {
        return numberOfSimulations;
    }
}