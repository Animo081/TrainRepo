import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner inputScanner;
    public static Random randomValue;

    public static void main(String args[]){

         inputScanner = new Scanner(System.in);
        randomValue = new Random();

        int matrixDimension;
        int[][] firstMatrix, secondMatrix, resultMatrix;

        System.out.print("Matrix Dimension: ");
        matrixDimension = inputScanner.nextInt();

        firstMatrix = createRandomMatrix(matrixDimension);
        secondMatrix = createRandomMatrix(matrixDimension);

        printMatrix(firstMatrix);
        printMatrix(secondMatrix);

        resultMatrix = matrixMultiply(firstMatrix,secondMatrix);
        System.out.println();

        printMatrix(resultMatrix);
    }

    public static int[][] createRandomMatrix(int dimension){

        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = randomValue.nextInt(10);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] matrixMultiply(int[][] firstMatrix, int[][] secondMatrix) {

        int matrixDimension = firstMatrix.length;

        int[][] matrix = new int[matrixDimension][matrixDimension];

        for (int row = 0; row < matrixDimension; row++){
            for (int column = 0; column < matrixDimension; column++){
                matrix[row][column] = getMultiplyValue(firstMatrix, secondMatrix, row, column);
            }
        }
        return matrix;
    }

    public static int getMultiplyValue(int[][] firstMatrix, int[][] secondMatrix, int row, int column) {

        int sum = 0;

        for (int z = 0; z < firstMatrix.length; z++){
            System.out.print(firstMatrix[row][z] + "*" + secondMatrix[z][column] + " + ");
            sum += firstMatrix[row][z] * secondMatrix[z][column];
        }
        System.out.println(" = "+sum);
        return sum;
    }
}
