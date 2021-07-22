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
            String arguments = expression.substring(command.length()).trim();

            switch (command.toLowerCase()) {
                case "log" -> {
                    if (arguments.equals("")) {
                        zoo.getHistory().forEach(System.out::println);
                    } else {
                        throw new IllegalArgumentException("I do not know this command. Try again");
                    }
                }
                case "check-in" -> {
                    String species = arguments.split(" ")[0];
                    String name = arguments.split(" ")[1];
                    checkInAnimal(species, name);
                }
                case "check-out" -> checkOutAnimal(arguments);
                case "exit" -> {
                    if (!arguments.equals("")) {
                        throw new IllegalArgumentException("I do not know this command. Try again");
                    }
                }
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
