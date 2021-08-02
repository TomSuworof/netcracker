package lectures.lecture12;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        getValidation().validate(new StringBuilder());
        //getValidation().validate(null);

        int[][] nums = new int[][] {
                {1, 2, 3, 4, 5},
                {7, 8, 9, 10},
                {11, 12, 13}
        };

        Stream.of(nums)
                //.flatMap(arr -> Stream.of(arr))
                .flatMapToInt(IntStream::of)
                .filter(val -> val >= 5 && val <= 10)
                .max()
                .ifPresent(System.out::println);
    }

    public static Validation getValidation() {
        return (val) -> {
            if (val == null) {
                throw new IllegalArgumentException();
            }
        };
    }
}
