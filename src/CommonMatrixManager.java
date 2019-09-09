import java.util.Random;
import java.util.Vector;

public class CommonMatrixManager extends AbstractMatrixManager {

    CommonMatrixManager() { randomValue = new Random(); }

    @Override
    public Vector<Vector<Integer>> matrixMultiply(Vector<Vector<Integer>> firstMatrix,
                                                  Vector<Vector<Integer>> secondMatrix) {
        int matrixDimension = firstMatrix.size();

        //Creating and initializing zero matrix
        Vector<Vector<Integer>> resultMatrix = createZeroMatrix(matrixDimension);

        //Filling result matrix
        for (int row = 0; row < matrixDimension; row++){
            for (int column = 0; column < matrixDimension; column++){
                //Set multiply value for current cell in resultMatrix
                resultMatrix.get(row).set(column, getMultiplyValue(firstMatrix, secondMatrix, row, column));
            }
        }
        return resultMatrix;
    }

    //Get multiply value for current cell
    public static int getMultiplyValue(Vector<Vector<Integer>> firstMatrix, Vector<Vector<Integer>> secondMatrix,
                                       int row, int column) {
        int sum = 0;

        for (int i = 0; i < firstMatrix.size(); i++){
            sum += firstMatrix.get(row).get(i) * secondMatrix.get(i).get(column);
        }
        return sum;
    }
}
