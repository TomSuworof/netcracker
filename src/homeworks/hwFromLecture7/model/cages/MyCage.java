package homeworks.hwFromLecture7.model.cages;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Cage;
import homeworks.hwFromLecture7.model.Condition;

public abstract class MyCage implements Cage {
    protected final int number;
    protected final double area;
    protected Condition condition;
    protected Animal animal;

    public MyCage(int number, double area) {
        this.number = number;
        this.area = area;
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

    protected void setAnimal(Animal animal) {
        if (animal == null || getCondition().isAvailableFor().contains(animal.getSpecies())) {
            this.animal = animal;
        } else {
            throw new IllegalArgumentException("Can not put this animal");
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
