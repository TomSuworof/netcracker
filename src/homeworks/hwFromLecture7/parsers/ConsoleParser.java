package homeworks.hwFromLecture7.parsers;

import homeworks.hwFromLecture7.Zoo;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.animals.*;

import java.util.IllegalFormatException;

public class ConsoleParser implements Parser {
    private Zoo zoo;

    @Override
    public void parse(String expression) {
        try {
            String command = expression.trim().split(" ")[0];

            switch (command) {
                case "log" -> zoo.getHistory().forEach(System.out::println);
                case "check-in" -> {
                    String animalData = expression.substring(command.length()).trim();
                    String species = animalData.split(" ")[0];
                    String name = animalData.split(" ")[1];
                    checkInAnimal(species, name);
                }
                case "check-out" -> {
                    String name = expression.substring(command.length()).trim();
                    checkOutAnimal(name);
                }
                case "exit" -> {}
                default -> throw new IllegalArgumentException("I do not know this command. Try again");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("I do not know this operation. Check your input");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void linkToZoo(Zoo zoo) {
        this.zoo = zoo;
        System.out.println("Welcome to Zoo Manager");
    }

    private Animal createAnimal(String species, String name) throws IllegalFormatException {
        return new MyAnimal.AnimalBuilder().getAnimal(species, name);
    }

    private void checkInAnimal(String species, String name) {
        zoo.checkInAnimal(createAnimal(species, name));
    }

    private void checkOutAnimal(String name) {
        System.out.println("Searching through our pets...");

        boolean found = false;
        for (Species species : Species.values()) {
            try {
                zoo.checkOutAnimal(createAnimal(species.toString(), name));
                found = true;
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
        if (!found) {
            System.out.println("We do not have " + name);
        }
    }
}
