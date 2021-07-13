package homeworks.hwFromLecture4;

import org.junit.Assert;
import org.junit.Test;

public class TransposedMatrixTest {

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
    public void getCorrectTransposedMatrix() {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        int[][] expected = {{1, 4},
                            {2, 5},
                            {3, 6}};
        int[][] result = this.getMatrixAs2DArray(new TransposedMatrix(matrixA));

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void getCorrectTransposedMatrixOfIdentityMatrix() {
        int[][] a = {{1, 0, 0},
                     {0, 1, 0},
                     {0, 0, 1}};
        Matrix matrixA = new MatrixImpl(a);

        int[][] result = this.getMatrixAs2DArray(new TransposedMatrix(matrixA));

        Assert.assertArrayEquals(a, result);
    }
}