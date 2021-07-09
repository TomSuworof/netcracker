package lectures.lecture3.tomAndJerry;

import java.awt.*;
import java.util.List;

public class ZooOrchestrator {
    private Zoo zoo;

    public ZooOrchestrator(Zoo zoo) {
        this.zoo = zoo;
    }

    public boolean move(Animal animal, Point point) {
        animal.move(point);
        List<Animal> relatedAnimals = zoo.getAnimalsInPoint(point);

        System.out.println(animal.getPriority());

        boolean isAnyOneEaten = false;
        for (Animal relatedAnimal : relatedAnimals) {
            if (relatedAnimal.eat(animal)) {
                zoo.remove(animal);
                return true;
            } else if (animal.eat(relatedAnimal)) {
                zoo.remove(relatedAnimal);
                isAnyOneEaten = true;
            }
        }
        return isAnyOneEaten;
    }

    private boolean checkAnimalPlace(Animal animal, Animal relatedAnimal) {
        if (relatedAnimal.eat(animal)) {
            zoo.remove(animal);
            return true;
        } else if (animal.eat(relatedAnimal)) {
            zoo.remove(relatedAnimal);
            return true;
        } else {
            return false;
        }
    }
}
