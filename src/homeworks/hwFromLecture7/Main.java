package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.parsers.ConsoleParser;
import homeworks.hwFromLecture7.parsers.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        MyZoo.ZooBuilder builder = new MyZoo.ZooBuilder();

        Zoo zoo = builder
                .buildCageFor(Species.LION, 1 ,50)
                .buildCageFor(Species.GIRAFFE, 2, 100)
                .buildCageFor(Species.PENGUIN, 3, 40)
                .buildCageFor(Species.SQUIRREL, 4, 20)
//                .buildCageFor(Species.LION, 5, 200) // это позволяет добавить ещё одну клетку для льва
                .build();

        Parser parser = new ConsoleParser();

        parser.linkToZoo(zoo);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            do {
                System.out.print("> ");
                input = reader.readLine();
                parser.parse(input);
            } while (!input.equals("exit"));
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }
}
