package homeworks.hwFromLecture4;

import java.util.Arrays;

public class TransposedMatrix extends AbstractMatrixOperation {

    public TransposedMatrix(Matrix a) {
        int[][] matrixA = this.getMatrixAs2DArray(a);

        int[][] aMinus1 = new int[this.countColumns(a)][this.countRows(a)];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                aMinus1[j][i] = matrixA[i][j];
            }
        }

        System.out.println(Arrays.deepToString(aMinus1));
        this.matrix = new MatrixImpl(aMinus1);
    }
}
