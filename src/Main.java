import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static MatrixManager M_M_W_T;
    public static FileUtils fileUtils;

    public static InputStream inputStream;

    public static void main(String args[]) throws IOException {

        MatrixWrapper firstMatrix, secondMatrix, resultMatrix;

        M_M_W_T = new MatrixManagerWithThreads();
        fileUtils = new FileUtils();

        inputStream = new BufferedInputStream(new FileInputStream("files/firstMatrix.txt"));
        firstMatrix = fileUtils.readMatrixFromStream(inputStream);

        inputStream = new BufferedInputStream(new FileInputStream("files/secondMatrix.txt"));
        secondMatrix = fileUtils.readMatrixFromStream(inputStream);

        M_M_W_T.printMatrix(firstMatrix);
        M_M_W_T.printMatrix(secondMatrix);

        resultMatrix = M_M_W_T.matrixMultiply(firstMatrix,secondMatrix);

        M_M_W_T.printMatrix(resultMatrix);
    }
}
