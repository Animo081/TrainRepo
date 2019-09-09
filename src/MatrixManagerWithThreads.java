import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixManagerWithThreads implements MatrixManager<Integer> {

    class MultiplyHandler implements Runnable{

        private int row, column;
        private Vector<Vector<Integer>> firstMatrix, secondMatrix, resultMatrix;

        MultiplyHandler(Vector<Vector<Integer>> firstMatrix, Vector<Vector<Integer>> secondMatrix,
                        Vector<Vector<Integer>> resultMatrix, int row, int column){

            this.firstMatrix = firstMatrix;
            this.secondMatrix = secondMatrix;
            this.resultMatrix = resultMatrix;
            this.row = row;
            this.column = column;
        }

        @Override
        public void run() {
            getMultiplyValue(firstMatrix, secondMatrix, resultMatrix, row, column);
        }
    }

    private Random randomValue;

    MatrixManagerWithThreads() {

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

        //Service for track threads
        ExecutorService es = Executors.newCachedThreadPool();

        //Filling result matrix
        for (int row = 0; row < matrixDimension; row++){
            for (int column = 0; column < matrixDimension; column++){
                //Executing Runnable
                es.execute(new MultiplyHandler(firstMatrix, secondMatrix, resultMatrix, row, column));
            }
        }

        //Service won`t start new threads
        es.shutdown();
        try {
            //Main thread is waiting until all threads finished or timeout
            es.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultMatrix;
    }

    //Set multiply value for current cell in resultMatrix
    public void getMultiplyValue(Vector<Vector<Integer>> firstMatrix, Vector<Vector<Integer>> secondMatrix,
                                       Vector<Vector<Integer>> resultMatrix, int row, int column) {
        int sum = 0;

        for (int i = 0; i < firstMatrix.size(); i++){
            sum += firstMatrix.get(row).get(i) * secondMatrix.get(i).get(column);
        }
        resultMatrix.get(row).set(column, sum);
    }
}

