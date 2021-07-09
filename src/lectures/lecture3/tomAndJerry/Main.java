package lectures.lecture3.tomAndJerry;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Animal tom = new Cat(new Point(1, 1));
        Animal jerry = new Mouse(new Point(2, 2));
        Animal spike = new Dog(new Point(3, 3));

        ZooOrchestrator zooOrchestrator = new ZooOrchestrator(new Zoo(new ArrayList<>(Arrays.asList(tom, jerry, spike))));
        System.out.println(zooOrchestrator.move(jerry, new Point(3, 3)));
    }
}
