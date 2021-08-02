package homeworks.hwFromLecture4;

import org.junit.Assert;
import org.junit.Test;

public class SumOfTwoMatricesTest {

    @Test
    public void getCorrectSumOfEqualMatrices() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        Matrix result = new SumOfTwoMatrices(matrixA, matrixA);

        Assert.assertEquals(12, result.getElement(1, 2));
    }

    @Test
    public void getCorrectSumOfMatrices() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        int[][] b = {{7, 8, 9},
                     {1, 2, 3}};
        Matrix matrixB = new MatrixImpl(b);

        Matrix result = new SumOfTwoMatrices(matrixA, matrixB);

        Assert.assertEquals(9, result.getElement(1, 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionWithIncompatibleSizes() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        Matrix transposedA = new TransposedMatrix(matrixA);

        Matrix result = new SumOfTwoMatrices(matrixA, transposedA);

        int element = result.getElement(1, 2);
    }
}