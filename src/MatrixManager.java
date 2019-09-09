import java.util.Vector;

public interface MatrixManager<T> {

    Vector<Vector<T>> createRandomMatrix(int dimension);

    void printMatrix(Vector<Vector<T>> matrix);

    Vector<Vector<T>> matrixMultiply(Vector<Vector<T>> firstMatrix,
                                     Vector<Vector<T>> secondMatrix);
}
