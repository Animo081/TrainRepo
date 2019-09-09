import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static Scanner inputScanner;

    public static MatrixManagerWithThreads M_M_W_T;
    public static CommonMatrixManager C_M_M;

    public static void main(String args[]){

        inputScanner = new Scanner(System.in);

        int matrixDimension;
        Vector<Vector<Integer>> firstMatrix, secondMatrix, resultMatrix;

        System.out.print("Matrix Dimension: ");
        matrixDimension = inputScanner.nextInt();

        M_M_W_T = new MatrixManagerWithThreads();

        firstMatrix = M_M_W_T.createRandomMatrix(matrixDimension);
        secondMatrix = M_M_W_T.createRandomMatrix(matrixDimension);

        //matrixManager.printMatrix(firstMatrix);
        //matrixManager.printMatrix(secondMatrix);

        resultMatrix = M_M_W_T.matrixMultiply(firstMatrix,secondMatrix);

        //matrixManager.printMatrix(resultMatrix);

        C_M_M = new CommonMatrixManager();

        firstMatrix = C_M_M.createRandomMatrix(matrixDimension);
        secondMatrix = C_M_M.createRandomMatrix(matrixDimension);

        //matrixManager.printMatrix(firstMatrix);
        //matrixManager.printMatrix(secondMatrix);

        resultMatrix = C_M_M.matrixMultiply(firstMatrix,secondMatrix);
    }
}
