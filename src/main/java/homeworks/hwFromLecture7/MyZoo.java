package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.cages.MyCage;
import homeworks.hwFromLecture7.services.ZooLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyZoo implements Zoo {
    private static final String ANIMAL_EXISTS = "We already have this animal";
    private static final String ANIMAL_DOES_NOT_EXIST = "We do not have this animal";
    private static final String NO_PLACE = "Sorry, we do not have place for this animal";
    private static final String CAGE_EXISTS = "This cage already exist";

    private final List<Cage> cages;
    private final Map<Integer, Animal> animals; // number of cage and animal
    private final ZooLogger zooLogger;

    private MyZoo(List<Cage> cages) {
        this.cages = cages;
        this.animals = new HashMap<>();
        this.zooLogger = new ZooLogger();
    }

    @Override
    public void checkInAnimal(Animal animal) {
        if (animals.containsValue(animal)) {
            throw new IllegalArgumentException(ANIMAL_EXISTS);
        }

        boolean put = false;

        for (Cage cage : cages) {
            if (cage.isVacantCage() && cage.getCondition().isAvailableFor().contains(animal.getSpecies())) {
                cage.setAnimal(animal);
                animals.put(cage.getNumber(), animal);
                put = true;
                break;
            }
        }

        if (put) {
            zooLogger.checkInAnimal(animal);
        } else {
            throw new IllegalStateException(NO_PLACE);
        }
    }

    @Override
    public void checkOutAnimal(Animal animal) {
        boolean excluded = false;

        for (Cage cage : cages) {
            Animal animalUnderNumber = animals.get(cage.getNumber());
            if (animalUnderNumber != null && animalUnderNumber.equals(animal)) {
                // if we have animal in cage under the number cageNumber
                // and its name equals to required
                cage.setAnimal(null);
                animals.remove(cage.getNumber());
                excluded = true;
                break;
            }
        }

        if (excluded) {
            zooLogger.checkOutAnimal(animal);
        } else {
            throw new IllegalArgumentException(ANIMAL_DOES_NOT_EXIST);
        }
    }

    @Override
    public List<InhabitationLog> getHistory() {
        return new ArrayList<>(zooLogger.getHistory());
    }

    public static class ZooBuilder {
        private final List<Cage> cages;

        public ZooBuilder() {
            cages = new ArrayList<>();
        }

        public Zoo build() {
            return new MyZoo(cages);
        }

        public ZooBuilder buildCageFor(Species species, int number, double area) {
            for (Cage cage : cages) {
                if (cage.getNumber() == number) {
                    throw new IllegalArgumentException(CAGE_EXISTS);
                }
            }

            // we can create for animal without animal
            // for example, we can have some toys and nuts for squirrel, but we do not have one
            cages.add(new MyCage(number, area, List.of(species)));
            return this;
        }
    }
}
