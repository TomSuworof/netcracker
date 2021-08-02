package lectures.lecture3.tomAndJerry;

import java.awt.*;

public abstract class AbstractAnimal implements Animal {
    protected Point point;
    protected int priority;

    protected AbstractAnimal(Point point, int priority) {
        this.point = point;
        this.priority = priority;
    }

    @Override
    public void move(Point point) {
        this.point = point;
        System.out.println(this + ": \"I moved\"");
    }

    public Point getPoint() {
        return point;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public boolean eat(Animal animal) {
        if (this == animal) {
            return false;
        }
        if (this.getPriority() > animal.getPriority()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "point=(" + point.getX() + "; " + point.getY() +
                ")}";
    }
}
