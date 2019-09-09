import java.util.Random;
import java.util.Vector;
import java.util.concurrent.*;

public class MatrixManagerWithThreads extends AbstractMatrixManager  {

    private int matrixDimension;

    private Vector<Vector<Integer>> firstMatrix, secondMatrix, resultMatrix;

    MatrixManagerWithThreads() { randomValue = new Random(); }

    @Override
    public Vector<Vector<Integer>> matrixMultiply(Vector<Vector<Integer>> firstMatrix,
                                                  Vector<Vector<Integer>> secondMatrix) {
        matrixDimension = firstMatrix.size();

        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = createZeroMatrix(matrixDimension);

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int row = 0; row < matrixDimension; row++){
            for (int column = 0; column < matrixDimension; column++){
                getMultiplyValue(service,row,column);
            }
        }

        //Service won`t start new threads
        service.shutdown();
        try {
            //Main thread is waiting until all threads finished or timeout
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultMatrix;
    }

    //Get multiply value for current cell
    public void getMultiplyValue(ExecutorService service, int row, int column) {

        service.execute(() -> {
            int sum = 0;

            for (int i = 0; i < firstMatrix.size(); i++){
                sum += firstMatrix.get(row).get(i) * secondMatrix.get(i).get(column);
            }
            resultMatrix.get(row).set(column, sum);
        });
    }
}

