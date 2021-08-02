package lectures.lecture8;

public class Main {
    public static void main(String[] args) {
        int i = -2;

        checkAssertI(i); // по идее, должен упасть, но нет. очень странно...

//        try {
//            checkI(i);
//        } catch (IncorrectInputtedValueException e) {
//            throw new RuntimeException(e); // запускается выше, чем в main, поэтому finally будет напечатано раньше
//        } finally {
//            System.out.println("Finally we are here");
//        }

    }

    public static void checkI(int i) throws IncorrectInputtedValueException {
        if (i < 0) {
            throw new IncorrectInputtedValueException("i must be non-negative");
        }
    }

    public static void checkAssertI(int i) {
        assert i >= 0 : "i must be non-negative";
    }
}
