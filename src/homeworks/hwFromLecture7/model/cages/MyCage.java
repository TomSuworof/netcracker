package homeworks.hwFromLecture7.model.cages;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.Condition;
import homeworks.hwFromLecture7.model.Species;

import java.util.List;

public class MyCage implements Cage {
    private static final String CAGE_UNAVAILABLE = "Can not put this animal";

    private final int number;
    private final double area;
    private final Condition condition;
    private Animal animal;

    public MyCage(int number, double area, List<Species> species) {
        this.number = number;
        this.area = area;
        this.condition = () -> species;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public Condition getCondition() {
        return condition;
    }

    @Override
    public boolean isVacantCage() {
        return animal == null;
    }

    @Override
    public void setAnimal(Animal animal) {
        if (animal == null || getCondition().isAvailableFor().contains(animal.getSpecies())) {
            this.animal = animal;
        } else {
            throw new IllegalArgumentException(CAGE_UNAVAILABLE);
        }
    }

    @Override
    public String toString() {
        return "MyCage{" +
                "number=" + number +
                ", area=" + area +
                ", condition=" + condition +
                ", animal=" + animal +
                '}';
    }
}
