package homeworks.hwFromLecture4;

import org.junit.Assert;
import org.junit.Test;

public class TransposedMatrixTest {

    @Test
    public void getCorrectTransposedMatrix() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        Matrix result = new TransposedMatrix(matrixA);

        Assert.assertEquals(6, result.getElement(2, 1));
    }

    @Test
    public void getCorrectTransposedMatrixOfIdentityMatrix() {
        int[][] a = {{1, 0, 0},
                     {0, 1, 0},
                     {0, 0, 1}};
        Matrix matrixA = new MatrixImpl(a);

        Matrix result = new TransposedMatrix(matrixA);

        Assert.assertEquals(1, result.getElement(2, 2));
    }
}