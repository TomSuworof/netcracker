package homeworks.hwFromLecture4;

public class AbstractMatrixOperation implements Matrix {

    protected Matrix matrix;

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return matrix.getElement(i, j);
    }

    protected int[][] getMatrixAs2DArray(Matrix a) {
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

    protected int countRows(Matrix a) {
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

    protected int countColumns(Matrix a) {
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
}
