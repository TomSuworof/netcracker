package homeworks.hwFromLecture7.model.animals;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Species;

import java.util.Objects;

public abstract class MyAnimal implements Animal {
    private static final String ANIMAL_UNAVAILABLE =  "We can not have this kind of animal";

    protected final String name;
    protected Species species;

    public MyAnimal(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); // capitalizing;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return species.name().toLowerCase() + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        MyAnimal myAnimal = (MyAnimal) o;
        return name.equals(myAnimal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species);
    }

    public static class AnimalBuilder {

        public Animal getAnimal(String species, String name) {
            return switch (species.toLowerCase()) {
                case "lion" -> new Lion(name);
                case "giraffe" -> new Giraffe(name);
                case "penguin" -> new Penguin(name);
                case "squirrel" -> new Squirrel(name);
                default -> throw new IllegalArgumentException(ANIMAL_UNAVAILABLE);
            };
        }
    }
}
