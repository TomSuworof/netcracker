package homeworks.hwFromLecture4;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMatrixOperation implements Matrix {
    @Override
    public String toString() {
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0;; i++) {
            try {
                this.getElement(i, 0);
            } catch (IndexOutOfBoundsException e) {
                break;
            } // if we reach Out of bounds - stop iterating

            matrix.add(new ArrayList<>());
            for (int j = 0;; j++) {
                try {
                    matrix.get(i).add(this.getElement(i, j));
                } catch (IndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        return matrix.toString();
    }
}
