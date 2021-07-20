package homeworks.hwFromLecture7.parsers;

import homeworks.hwFromLecture7.Zoo;
import homeworks.hwFromLecture7.model.Animal;
import homeworks.hwFromLecture7.model.animals.*;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleParser implements Parser {
    private final BufferedReader reader;
    private Zoo zoo;

    public ConsoleParser() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void parse(String expression) throws IOException {
        if (reader.ready()) {
            String[] parts = expression.split(" ");
            String command = parts[0];
            String species = parts[1];
            String name = parts[2];

            Animal animal = createAnimal(species, name);

            switch (command) {
                case "check-in" -> zoo.checkInAnimal(animal);
                case "check-out" -> zoo.checkOutAnimal(animal);
                case "log" -> zoo.getHistory().forEach(System.out::println);
                case "exit" -> throw new EOFException();
                default -> throw new IllegalArgumentException("I do not know this command. Try again");
            }

        } else {
            throw new IOException("Reader is not ready");
        }
    }

    @Override
    public void linkToZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    private Animal createAnimal(String species, String name) {
        return new MyAnimal.AnimalBuilder().getAnimal(species, name);
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException ignored) {}
    }
}
