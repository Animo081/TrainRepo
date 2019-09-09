import java.util.Random;
import java.util.Vector;

public class CommonMatrixManager extends AbstractMatrixManager {

    @Override
    public MatrixWrapper matrixMultiply(MatrixWrapper firstMatrix,
                                        MatrixWrapper secondMatrix) {
        int matrixDimension = firstMatrix.size();

        //Creating and initializing zero matrix
        MatrixWrapper resultMatrix = new MatrixWrapper(matrixDimension);
        resultMatrix.initializeZeros();

        //Filling result matrix
        for (int row = 0; row < matrixDimension; row++){
            for (int column = 0; column < matrixDimension; column++){
                //Set multiply value for current cell in resultMatrix
                resultMatrix.set(getMultiplyValue(firstMatrix, secondMatrix, row, column), row, column);
            }
        }
        return resultMatrix;
    }

    //Get multiply value for current cell
    public int getMultiplyValue(MatrixWrapper firstMatrix, MatrixWrapper secondMatrix,
                                int row, int column) {
        int sum = 0;

        for (int i = 0; i < firstMatrix.size(); i++){
            sum += firstMatrix.get(row, i) * secondMatrix.get(i, column);
        }
        return sum;
    }
}
