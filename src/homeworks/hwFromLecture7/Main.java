package homeworks.hwFromLecture7;

import homeworks.hwFromLecture7.model.Species;
import homeworks.hwFromLecture7.model.animals.Leon;
import homeworks.hwFromLecture7.parsers.ConsoleParser;
import homeworks.hwFromLecture7.parsers.Parser;

public class Main {
    public static void main(String[] args) {
        MyZoo.ZooBuilder builder = new MyZoo.ZooBuilder();

        Zoo zoo = builder
                .buildCageFor(Species.LEON, 1 ,50)
                .buildCageFor(Species.GIRAFFE, 2, 100)
                .buildCageFor(Species.PENGUIN, 3, 40)
                .buildCageFor(Species.SQUIRREL, 4, 20)
                .build();

        Parser parser = new ConsoleParser();

        parser.linkToZoo(zoo);



    }
}
