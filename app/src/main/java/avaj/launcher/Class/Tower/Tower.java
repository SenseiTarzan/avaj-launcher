package avaj.launcher.Class.Tower;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;

import avaj.launcher.AvajLauncher;
import avaj.launcher.Class.Vehicle.Flyable;

public class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();

    public Tower() {}

    public void register(Flyable flyable) {
        observers.add(flyable);
        AvajLauncher.getDashboard().log("Tower says: " + flyable + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        AvajLauncher.getDashboard().log("Tower says: " + flyable + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        var observersCopy = new ArrayList<Flyable>(observers);
        for (var flyable : observersCopy) {
            flyable.updateConditions(); 
        }
    }

    public static class Dashboard {
        @Nullable
        private FileWriter writer;
        @Nullable
        private String filename;
        public Dashboard() {}

        public Dashboard(String filename) {
            if(filename == null || filename.isEmpty()) {
                throw new IllegalArgumentException("Filename cannot be null or empty.");
            }
            try {
                writer = new FileWriter(filename);
                this.filename = filename;
            } catch (Throwable e) {
               throw new RuntimeException("Error: Could not create log file.");
            }
        }

        public void log(String message) {
            if (writer != null) {
                try {
                    writer.write(message + "\n");
                    writer.flush();
                } catch (Exception e) {
                    System.err.println("Error: Could not write to log file.");
                }
            } else {
                System.out.println(message);
            }
        }

        public void close() {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    System.err.println("Error: Could not close log file.");
                }
            }
        }

        public void removeFile() {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    System.err.println("Error: Could not close log file before deletion.");
                }
            }
            if (filename != null) {
                java.io.File file = new java.io.File(filename);
                if (file.delete()) {
                    System.out.println("Log file deleted successfully.");
                } else {
                    System.err.println("Error: Could not delete log file.");
                }
            }
        }
    }
}
