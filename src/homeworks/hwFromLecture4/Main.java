package homeworks.hwFromLecture4;

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},
                     {4, 5, 6}};
        Matrix matrixA = new MatrixImpl(a);

        int[][]b = {{7, 8, 9},
                    {1, 2, 3}};
        Matrix matrixB = new MatrixImpl(b);

        Matrix result = new SumOfTwoMatrices(matrixA, matrixB);
        System.out.println(result); // [[8, 10, 12], [5,  7,  9]]

        Matrix transposedA = new TransposedMatrix(matrixA);
        System.out.println(transposedA); // [[1, 4], [2, 5], [3, 6]]

        Matrix transposedB = new TransposedMatrix(matrixB);
        System.out.println(transposedB); // [[7, 1], [8, 2], [9, 3]]

        Matrix resultOfTransposed = new SumOfTwoMatrices(transposedA, transposedB);
        System.out.println(resultOfTransposed); // [[8,  5], [10, 7], [12, 9]]

        Matrix strange = new SumOfTwoMatrices(matrixA, transposedA);
        System.out.println(strange); // strange matrix
    }
}
