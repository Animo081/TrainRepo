package com.vector.testtask.service.impl;

import com.vector.testtask.dto.MatrixMultiplyData;
import com.vector.testtask.dto.MatrixWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixManagerWithThreads extends AbstractMatrixManager {

    private int matrixDimension;

    private MatrixWrapper firstMatrix, secondMatrix, resultMatrix;

    @Override
    public MatrixMultiplyData matrixMultiply(MatrixWrapper firstMatrix,
                                             MatrixWrapper secondMatrix) {

        if (firstMatrix.size() != secondMatrix.size()) return null;

        matrixDimension = firstMatrix.size();

        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;

        this.resultMatrix = new MatrixWrapper(matrixDimension);
        this.resultMatrix.initializeZeros();

        ExecutorService service = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        for (int row = 0; row < matrixDimension; row++){
            for (int column = 0; column < matrixDimension; column++){
                getMultiplyValue(service,row,column);
            }
        }

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MatrixMultiplyData result = new MatrixMultiplyData(
                firstMatrix,
                secondMatrix,
                resultMatrix,
                "using_threads",
                System.currentTimeMillis() - startTime
        );
        return result;
    }

    public void getMultiplyValue(ExecutorService service, int row, int column) {

        service.execute(() -> {
            int sum = 0;

            for (int i = 0; i < firstMatrix.size(); i++){
                sum += firstMatrix.get(row, i) * secondMatrix.get(i, column);
            }
            resultMatrix.set(sum, row, column);
        });
    }
}

