import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static MatrixManager M_M_W_T;

    public static InputStream inputStream;

    public static void main(String args[]) throws IOException {

        MatrixWrapper firstMatrix, secondMatrix, resultMatrix;

        M_M_W_T = new MatrixManagerWithThreads();

        inputStream = new FileInputStream("files/firstMatrix.txt");
        firstMatrix = FileUtils.getMatrixFromStream(inputStream);

        inputStream = new FileInputStream("files/secondMatrix.txt");
        secondMatrix = FileUtils.getMatrixFromStream(inputStream);

        M_M_W_T.printMatrix(firstMatrix);
        M_M_W_T.printMatrix(secondMatrix);

        resultMatrix = M_M_W_T.matrixMultiply(firstMatrix,secondMatrix);

        M_M_W_T.printMatrix(resultMatrix);

        FileUtils.writeMatrixToFile(resultMatrix, "files/resultMatrix.txt");
    }
}
