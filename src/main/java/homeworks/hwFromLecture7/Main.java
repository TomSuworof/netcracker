package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.parsers.ConsoleParser;
import homeworks.hwFromLecture7.parsers.Parser;
import homeworks.hwFromLecture7.services.ExecutorFabric;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        MyZoo.ZooBuilder builder = new MyZoo.ZooBuilder()
                .buildCageFor(Species.LION, 1 ,50)
//                .buildCageFor(Species.LION, 5, 200) // это позволяет добавить ещё одну клетку для льва
                .buildCageFor(Species.GIRAFFE, 2, 100)
                .buildCageFor(Species.PENGUIN, 3, 40)
                .buildCageFor(Species.SQUIRREL, 4, 20);

        Zoo zoo = builder.build();

        Parser parser = new ConsoleParser(new ExecutorFabric(zoo));

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Welcome to Zoo Manager");
            String input;
            while (true) {
                System.out.print("> ");
                input = reader.readLine();

                if (input.equals("exit")) {
                    break;
                }

                try {
                    parser.parse(input);
                    System.out.println("Success");
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        } finally {
            System.out.println("Exiting...");
        }
    }
}
