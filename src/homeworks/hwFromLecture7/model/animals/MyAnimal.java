package homeworks.hwFromLecture7.model.animals;

import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Species;

import java.util.Objects;

public abstract class MyAnimal implements Animal {
    protected final String name;
    protected Species species;

    public MyAnimal(String name) {
        this.name = name;
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
        return species.name() + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyAnimal myAnimal = (MyAnimal) o;
        return name.equals(myAnimal.name) && species == myAnimal.species;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species);
    }

    public static class AnimalBuilder {

        public Animal getAnimal(String species, String name) {
//            switch (species.toLowerCase()) {
//                case "lion":
//                    return new Leon(name);
//                case "giraffe":
//                    return new Giraffe(name);
//                case "penguin":
//                    return new Penguin(name);
//                case "squirrel":
//                    return new Squirrel(name);
//                default:
//                    throw new IllegalArgumentException("We can not have this kind of animal");
//            }
            return switch (species.toLowerCase()) {
                case "lion" -> new Lion(name);
                case "giraffe" -> new Giraffe(name);
                case "penguin" -> new Penguin(name);
                case "squirrel" -> new Squirrel(name);
                default -> throw new IllegalArgumentException("We can not have this kind of animal");
            }; // more modern look
        }
    }
}
