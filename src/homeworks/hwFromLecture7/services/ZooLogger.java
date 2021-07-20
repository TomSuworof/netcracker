package homeworks.hwFromLecture7.services;

import homeworks.hwFromLecture7.InhabitationLog;
import homeworks.hwFromLecture7.model.Animal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZooLogger {
    private final List<InhabitationLog> history;

    public ZooLogger() {
        this.history = new ArrayList<>();
    }

    public List<InhabitationLog> getHistory() {
        return history;
    }

    public void checkInAnimal(Animal animal) {
        history.add(new InhabitationLog(
                new Date(),
                null,
                animal.getSpecies(),
                animal.getName()
        ));
    }

    public void checkOutAnimal(Animal animal) {
        int animalIndex = getIndexOfAnimalData(animal);
        InhabitationLog oldData = history.get(animalIndex);
        history.set(animalIndex, new InhabitationLog(
                oldData.getCheckInDate(),
                new Date(),
                oldData.getAnimalSpecies(),
                oldData.getAnimalName()
        ));
    }

    private int getIndexOfAnimalData(Animal animal) {
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i).getAnimalName().equals(animal.getName())
                    && history.get(i).getAnimalSpecies().equals(animal.getSpecies())) {
                return i;
            }
        }
        return -1;
    }
}
