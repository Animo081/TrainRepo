package com.vector.testtask.service;

import com.vector.testtask.dto.MatrixMultiplyData;
import com.vector.testtask.dto.MatrixWrapper;

public interface MatrixManager {

    void printMatrix(MatrixWrapper matrix);

    MatrixMultiplyData matrixMultiply(MatrixWrapper firstMatrix,
                                      MatrixWrapper secondMatrix);
}
