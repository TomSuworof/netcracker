package homeworks.hwFromLecture4;

public class AbstractMatrixOperation implements Matrix {

    protected Matrix matrix;

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return matrix.getElement(i, j);
    }
}
