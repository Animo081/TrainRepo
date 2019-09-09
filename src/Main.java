import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static Scanner inputScanner;

    public static MatrixManager M_M_W_T;
    public static MatrixManager C_M_M;

    public static void main(String args[]){

        inputScanner = new Scanner(System.in);

        int matrixDimension;
        MatrixWrapper firstMatrix, secondMatrix, resultMatrix;

        System.out.print("Matrix Dimension: ");
        matrixDimension = inputScanner.nextInt();

        M_M_W_T = new MatrixManagerWithThreads();

        firstMatrix = new MatrixWrapper(matrixDimension);
        firstMatrix.initializeRandoms();

        secondMatrix = new MatrixWrapper(matrixDimension);
        secondMatrix.initializeRandoms();

        M_M_W_T.printMatrix(firstMatrix);
        M_M_W_T.printMatrix(secondMatrix);

        resultMatrix = M_M_W_T.matrixMultiply(firstMatrix,secondMatrix);

        M_M_W_T.printMatrix(resultMatrix);

        C_M_M = new CommonMatrixManager();

        resultMatrix = C_M_M.matrixMultiply(firstMatrix,secondMatrix);

        C_M_M.printMatrix(resultMatrix);
    }
}
