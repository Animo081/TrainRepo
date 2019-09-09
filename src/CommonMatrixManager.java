import java.util.Random;
import java.util.Vector;

public class CommonMatrixManager implements MatrixManager<Integer> {

    private Random randomValue;

    CommonMatrixManager() {

        randomValue = new Random();
    }

    @Override
    public Vector<Vector<Integer>> createRandomMatrix(int dimension) {

        //Creating matrix with specific size, rows not added
        Vector<Vector<Integer>> matrix = new Vector<>();

        //Initializing matrix rows
        initializeMatrixRows(matrix, dimension);

        //Filling matrix with random values
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                matrix.get(i).add(randomValue.nextInt(10));
            }
        }
        return matrix;
    }

    @Override
    public Vector<Vector<Integer>> createZeroMatrix(int dimension) {

        //Creating matrix with specific size, rows not added
        Vector<Vector<Integer>> matrix = new Vector<>(dimension);

        initializeMatrixRows(matrix, dimension);

        //Filling matrix with zero values
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                matrix.get(i).add(0);
            }
        }
        return matrix;
    }

    @Override
    public void initializeMatrixRows(Vector<Vector<Integer>> matrix, int dimension) {

        for (int i = 0; i < dimension; i++){
            matrix.add(new Vector<Integer>(dimension));
        }
    }

    @Override
    public void printMatrix(Vector<Vector<Integer>> matrix) {

        for (int i = 0; i < matrix.size(); i++){
            for (int j = 0; j < matrix.size(); j++){
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

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
