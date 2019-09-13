package com.vector.testtask.service.impl;

import com.vector.testtask.dto.MatrixMultiplyData;
import com.vector.testtask.dto.MatrixWrapper;

public class CommonMatrixManager extends AbstractMatrixManager {

    @Override
    public MatrixMultiplyData matrixMultiply(MatrixWrapper firstMatrix,
                                             MatrixWrapper secondMatrix) {

        if (firstMatrix.size() != secondMatrix.size()) return null;

        int matrixDimension = firstMatrix.size();

        MatrixWrapper resultMatrix = new MatrixWrapper(matrixDimension);
        resultMatrix.initializeZeros();

        long startTime = System.currentTimeMillis();

        for (int row = 0; row < matrixDimension; row++){
            for (int column = 0; column < matrixDimension; column++){
                //Set multiply value for current cell in resultMatrix
                resultMatrix.set(getMultiplyValue(firstMatrix, secondMatrix, row, column), row, column);
            }
        }

        MatrixMultiplyData result = new MatrixMultiplyData(
                firstMatrix,
                secondMatrix,
                resultMatrix,
                "without_threads",
                System.currentTimeMillis() - startTime
        );
        return result;
    }

    //Get multiply value for current cell
    public int getMultiplyValue(MatrixWrapper firstMatrix, MatrixWrapper secondMatrix,
                                int row, int column) {
        int sum = 0;

        for (int i = 0; i < firstMatrix.size(); i++){
            sum += firstMatrix.get(row, i) * secondMatrix.get(i, column);
        }
        return sum;
    }
}
