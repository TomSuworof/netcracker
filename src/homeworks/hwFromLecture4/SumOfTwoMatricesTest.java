package homeworks.hwFromLecture4;

import org.junit.Assert;
import org.junit.Test;

public class SumOfTwoMatricesTest {

    private int[][] getMatrixAs2DArray(Matrix a) {
        int n = this.countRows(a);
        int m = this.countColumns(a);
        int[][] matrixA = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = a.getElement(i, j);
            }
        }
        return matrixA;
    }

    private int countRows(Matrix a) {
        int n = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                int value = a.getElement(i, 0);
                n++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return n;
    }

    private int countColumns(Matrix a) {
        int m = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                int value = a.getElement(0, i);
                m++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return m;
    }

    @Test
    public void getCorrectSumOfEqualMatrices() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        int[][] expected = {{2, 4, 6},
                            {8, 10, 12}};

        int[][] result = this.getMatrixAs2DArray(new SumOfTwoMatrices(matrixA, matrixA));

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void getCorrectSumOfMatrices() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        int[][] b = {{7, 8, 9},
                     {1, 2, 3}};
        Matrix matrixB = new MatrixImpl(b);

        int[][] expected = {{8, 10, 12},
                            {5, 7, 9}};
        int[][] result = this.getMatrixAs2DArray(new SumOfTwoMatrices(matrixA, matrixB));

        Assert.assertArrayEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionWithIncompatibleSizes() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        Matrix transposedA = new TransposedMatrix(matrixA);

        int[][] result = this.getMatrixAs2DArray(new SumOfTwoMatrices(matrixA, transposedA));
    }
}