package lectures.lecture3.tomAndJerry;

import java.awt.*;

public interface Animal {

    void move(Point point);

    boolean eat(Animal animal);

    Point getPoint();

    int getPriority();
}
