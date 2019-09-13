import dto.MatrixMultiplyData;
import dto.MatrixWrapper;
import service.MatrixManager;
import service.impl.CommonMatrixManager;
import service.impl.MatrixSQLService;
import utils.FileUtils;

import javax.security.auth.login.FailedLoginException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Main {



    public static MatrixManager M_M_W_T;
    public static MatrixSQLService matrixSQLService;

    public static InputStream inputStream;

    public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException, FailedLoginException {

        MatrixWrapper firstMatrix, secondMatrix;
        MatrixMultiplyData result;

        M_M_W_T = new CommonMatrixManager();

        inputStream = new FileInputStream("files/firstMatrix.txt");
        firstMatrix = FileUtils.getMatrixFromStream(inputStream);

        inputStream = new FileInputStream("files/secondMatrix.txt");
        secondMatrix = FileUtils.getMatrixFromStream(inputStream);

        result = M_M_W_T.matrixMultiply(firstMatrix,secondMatrix);

        //utils.FileUtils.writeMatrixToFile(resultMatrix, "files/resultMatrix.txt");

        matrixSQLService = new MatrixSQLService();

        matrixSQLService.sendMultiplyResultToDB(result);
    }
}
