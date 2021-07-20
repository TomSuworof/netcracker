package homeworks.hwFromLecture7.model.cages;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Species;

import java.util.List;

public class CageForPenguin extends MyCage {
    public CageForPenguin(int number, double area, Animal animal) {
        super(number, area);
        this.condition = () -> List.of(Species.PENGUIN);
        setAnimal(animal);
    }
}
