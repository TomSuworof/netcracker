package homeworks.hwFromLecture7.services;

import homeworks.hwFromLecture7.InhabitationLog;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Event;

import java.util.*;

public class ZooLogger {
    private final Set<InhabitationLog> history;

    public ZooLogger() {
        this.history = new HashSet<>();
    }

    public Set<InhabitationLog> getHistory() {
        return history;
    }

    public void checkInAnimal(Animal animal) {
        this.logAnimal(animal, Event.ANIMAL_CHECKED_IN);
    }

    public void checkOutAnimal(Animal animal) {
        this.logAnimal(animal, Event.ANIMAL_CHECKED_OUT);
    }

    private void logAnimal(Animal animal, Event event) {
        history.add(new InhabitationLog(
                event,
                new Date(),
                animal
        ));
    }
}
