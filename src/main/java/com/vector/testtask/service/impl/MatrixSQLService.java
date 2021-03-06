package com.vector.testtask.service.impl;

import com.vector.testtask.dto.MatrixMultiplyData;
import com.vector.testtask.dto.MatrixWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatrixSQLService {

    private final static String SELECT_MATRIX_ID_STATEMENT =
            "SELECT matrix_id " +
            "FROM matrixes " +
            "WHERE matrix = ?";

    private final static String INSERT_MATRIX_STATEMENT =
            "INSERT " +
            "INTO matrixes (matrix)" +
            "VALUES (?)";

    private final static String INSERT_RECORD_STATEMENT =
            "INSERT INTO records (" +
            "owner_id, " +
            "method," +
            "first_matrix_id," +
            "second_matrix_id," +
            "result_matrix_id," +
            "execution_time" +
            ") VALUES (?,?,?,?,?,?)";


    @Autowired
    private SQLConnection sqlConnection;

    public void sendMultiplyResultToDB(MatrixMultiplyData result) throws SQLException, ClassNotFoundException, IOException {

        try (PreparedStatement insertRecord = sqlConnection.getConnection().prepareStatement(INSERT_RECORD_STATEMENT)) {

            result.firstMatrix.setId(selectMatrixId(result.firstMatrix));
            result.secondMatrix.setId(selectMatrixId(result.secondMatrix));
            result.resultMatrix.setId(selectMatrixId(result.resultMatrix));

            insertRecord.setInt(1, 5);
            insertRecord.setString(2, result.method);
            insertRecord.setLong(3, result.firstMatrix.getId());
            insertRecord.setLong(4, result.secondMatrix.getId());
            insertRecord.setLong(5, result.resultMatrix.getId());
            insertRecord.setLong(6, result.execution_time);

            insertRecord.executeUpdate();

            sqlConnection.getConnection().commit();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
            sqlConnection.getConnection().rollback();
        }
    }

    private long selectMatrixId(MatrixWrapper matrix) {

        try (PreparedStatement selectMatrixId = sqlConnection.getConnection().prepareStatement(SELECT_MATRIX_ID_STATEMENT)) {

            selectMatrixId.setString(1, matrix.toString());
            ResultSet result = selectMatrixId.executeQuery();

            if (!result.next()) {
                PreparedStatement insertMatrix = sqlConnection.getConnection().prepareStatement(INSERT_MATRIX_STATEMENT);
                insertMatrix.setString(1, matrix.toString());

                insertMatrix.executeUpdate();

                return selectMatrixId(matrix);
            } else {
                return result.getInt("matrix_id");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
