package service;

import dto.MatrixMultiplyData;
import dto.MatrixWrapper;

public interface MatrixManager {

    void printMatrix(MatrixWrapper matrix);

    MatrixMultiplyData matrixMultiply(MatrixWrapper firstMatrix,
                                      MatrixWrapper secondMatrix);
}
