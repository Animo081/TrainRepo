import java.util.Vector;

public interface MatrixManager {

    void printMatrix(MatrixWrapper matrix);

    MatrixWrapper matrixMultiply(MatrixWrapper firstMatrix,
                                 MatrixWrapper secondMatrix);
}
