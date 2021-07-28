package lectures.lecture11;

import java.util.HashMap;
import java.util.Map;

public class Function {
    private final Map<Double, Double> dots;

    public Function() {
        this.dots = new HashMap<>();
    }

    public double getY(double x) {
        double y = Math.pow(x, 2) + 2;
        dots.put(x, y);
        return y;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (Map.Entry<Double, Double> pair : dots.entrySet()) {
            str.append("(").append(pair.getKey()).append("; ").append(pair.getValue()).append("), ");
        }
        str = new StringBuilder(str.subSequence(0, str.length() - 2)).append("]");
        return str.toString();
    }
}
