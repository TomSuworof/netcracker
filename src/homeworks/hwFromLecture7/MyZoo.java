package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.cages.CageForGiraffe;
import homeworks.hwFromLecture7.model.cages.CageForLeon;
import homeworks.hwFromLecture7.model.cages.CageForPenguin;
import homeworks.hwFromLecture7.model.cages.CageForSquirrel;
import homeworks.hwFromLecture7.services.ZooLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyZoo implements Zoo {
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
        for (Animal animalWeHave : animals.values()) {
            if (animalWeHave.getName().equals(animal.getName())) {
                throw new IllegalArgumentException("We already have " + animalWeHave.getName() + ". It is " + animal.getSpecies());
            }
        }

        boolean put = false;
        for (int i = 0; i < cages.size(); i++) {
            if (cages.get(i).isVacantCage()) {
                cages.set(i, ZooBuilder.getCageForAnimalWithAnimal(
                        cages.get(i).getNumber(),
                        cages.get(i).getArea(),
                        animal.getSpecies(),
                        animal
                ));
                animals.put(cages.get(i).getNumber(), animal);
                put = true;
                break;
            }
        }

        if (put) {
            System.out.println("Welcome to the family, " + animal);
            zooLogger.checkInAnimal(animal);
        } else {
            throw new IllegalArgumentException("Sorry, we do not have place for " + animal);
        }
    }

    @Override
    public void checkOutAnimal(Animal animal) {
        boolean excluded = false;
        for (int i = 0; i < cages.size(); i++) {
            Animal animalUnderNumber = animals.get(cages.get(i).getNumber());
            if (animalUnderNumber != null && animalUnderNumber.equals(animal)) {
                // if we have animal in cage under the number cageNumber
                // and its name equals to required
                cages.set(i, ZooBuilder.getCageForAnimalWithAnimal(
                        cages.get(i).getNumber(),
                        cages.get(i).getArea(),
                        animal.getSpecies(),
                        null
                ));
                animals.remove(i);
                excluded = true;
                break;
            }
        }
        if (excluded) {
            System.out.println("Bye, " + animal);
            zooLogger.checkOutAnimal(animal);
        } else {
            throw new IllegalArgumentException("We do not have " + animal);
        }
    }

    @Override
    public List<InhabitationLog> getHistory() {
        return zooLogger.getHistory();
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
                    throw new IllegalArgumentException("This cage already exist");
                }
            }

            // we can create for animal without animal
            // for example, we can have some toys and nuts for squirrel, but we do not have one
            cages.add(getCageForAnimalWithAnimal(number, area, species, null));
            return this;
        }

        private static Cage getCageForAnimalWithAnimal(int number, double area, Species species, Animal animal) {
//            switch (species) {
//                case LEON:
//                    return new CageForLeon(number, area, animal);
//                case GIRAFFE:
//                    return new CageForGiraffe(number, area, animal);
//                case PENGUIN:
//                    return new CageForPenguin(number, area, animal);
//                case SQUIRREL:
//                    return new CageForSquirrel(number, area, animal);
//                default:
//                    throw new IllegalArgumentException("We can not have this kind of animal");
//            }
            return switch (species) {
                case LEON -> new CageForLeon(number, area, animal);
                case GIRAFFE -> new CageForGiraffe(number, area, animal);
                case PENGUIN -> new CageForPenguin(number, area, animal);
                case SQUIRREL -> new CageForSquirrel(number, area, animal);
                default -> throw new IllegalArgumentException("We can not have this kind of animal");
            }; // more modern look
        }
    }
}
