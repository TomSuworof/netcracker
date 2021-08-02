package homeworks.hwFromLecture7.model.animals;

import homeworks.hwFromLecture7.model.Species;

public class Penguin extends MyAnimal {
    public Penguin(String name) {
        super(name);
        this.species = Species.PENGUIN;
    }
}
