package lectures.lecture3.tomAndJerry;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void remove(Animal animal) {
        animals.remove(animal);
    }

    public void clearAll() {
        animals.clear();
    }

    public List<Animal> getAnimalsInPoint(Point point) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getPoint().equals(point)) {
                result.add(animal);
            }
        }
        return result;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
