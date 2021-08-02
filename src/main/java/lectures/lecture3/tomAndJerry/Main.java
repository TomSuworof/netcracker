package lectures.lecture3.tomAndJerry;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Animal tom = new Cat(new Point(1, 1));
        Animal jerry = new Mouse(new Point(2, 2));
        Animal spike = new Dog(new Point(3, 3));

        ZooOrchestrator zooOrchestrator = new ZooOrchestrator(new Zoo(new ArrayList<>(Arrays.asList(tom, jerry, spike))));

        System.out.println("Animals before: ");
        zooOrchestrator.getZoo().getAnimals().forEach(System.out::println);
        System.out.println();

        System.out.println(zooOrchestrator.move(jerry, new Point(3, 3)));
        System.out.println();

        System.out.println("Animals after: ");
        zooOrchestrator.getZoo().getAnimals().forEach(System.out::println);
        System.out.println();
    }
}
