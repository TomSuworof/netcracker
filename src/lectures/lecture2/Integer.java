package lectures.lecture2;

import java.util.Objects;

public class Integer implements Comparable {
    private int value;

    public Integer(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integer integer = (Integer) o;
        return value == integer.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || getClass() != o.getClass()) return 0;
        Integer integer = (Integer) o;
        return java.lang.Integer.compare(this.value, integer.value);
    }
}
