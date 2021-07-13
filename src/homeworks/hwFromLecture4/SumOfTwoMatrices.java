package homeworks.hwFromLecture4;

import java.util.Arrays;

public class SumOfTwoMatrices extends AbstractMatrixOperation {

    public SumOfTwoMatrices(Matrix a, Matrix b) {

        int[][] matrixA = this.getMatrixAs2DArray(a);
        int[][] matrixB = this.getMatrixAs2DArray(b);

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixA[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println(Arrays.deepToString(matrixA));
        this.matrix = new MatrixImpl(matrixA);
    }
}
