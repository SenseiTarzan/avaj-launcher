package avaj.launcher.Class.Tower;

import java.util.ArrayList;
import java.util.List;
import avaj.launcher.Class.Vehicle.Flyable;

public class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();

    public Tower() {}

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + flyable + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
        System.out.println("Tower says: " + flyable + " unregistered from weather tower.");
    }

    protected void conditionsChanged() {
        var observersCopy = new ArrayList<Flyable>(observers);
        for (var flyable : observersCopy) {
            flyable.updateConditions(); 
        }
    }
}
