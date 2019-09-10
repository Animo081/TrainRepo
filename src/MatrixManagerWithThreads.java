import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixManagerWithThreads extends AbstractMatrixManager  {

    private int matrixDimension;

    private MatrixWrapper firstMatrix, secondMatrix, resultMatrix;

    @Override
    public MatrixWrapper matrixMultiply(MatrixWrapper firstMatrix,
                                        MatrixWrapper secondMatrix) {
        matrixDimension = firstMatrix.size();

        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;

        this.resultMatrix = new MatrixWrapper(matrixDimension);
        this.resultMatrix.initializeZeros();

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
                sum += firstMatrix.get(row, i) * secondMatrix.get(i, column);
            }
            resultMatrix.set(sum, row, column);
        });
    }
}

