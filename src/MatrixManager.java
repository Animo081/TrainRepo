import java.util.Vector;

public interface MatrixManager<T> {

    public Vector<Vector<T>> createRandomMatrix(int dimension);
    public Vector<Vector<T>> createZeroMatrix(int dimension);
    public void initializeMatrixRows(Vector<Vector<T>> matrix, int dimension);

    public void printMatrix(Vector<Vector<T>> matrix);

    public Vector<Vector<T>> matrixMultiply(Vector<Vector<T>> firstMatrix,
                                            Vector<Vector<T>> secondMatrix);
}
