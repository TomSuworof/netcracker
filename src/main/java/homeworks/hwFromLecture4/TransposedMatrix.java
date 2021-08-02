package homeworks.hwFromLecture4;

public class TransposedMatrix extends AbstractMatrixOperation {
    private final Matrix a;

    public TransposedMatrix(Matrix a) {
        this.a = a;
    }

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return a.getElement(j, i);
    }
}
