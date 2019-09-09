import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static Scanner inputScanner;

    public static MatrixManagerWithThreads matrixManager;

    public static void main(String args[]){

        inputScanner = new Scanner(System.in);

        int matrixDimension;
        Vector<Vector<Integer>> firstMatrix, secondMatrix, resultMatrix;

        System.out.print("Matrix Dimension: ");
        matrixDimension = inputScanner.nextInt();

        matrixManager = new MatrixManagerWithThreads();

        firstMatrix = matrixManager.createRandomMatrix(matrixDimension);
        secondMatrix = matrixManager.createRandomMatrix(matrixDimension);

        matrixManager.printMatrix(firstMatrix);
        matrixManager.printMatrix(secondMatrix);

        resultMatrix = matrixManager.matrixMultiply(firstMatrix,secondMatrix);

        matrixManager.printMatrix(resultMatrix);
    }
}
