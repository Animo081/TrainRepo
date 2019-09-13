package com.vector.testtask.dto;

public class MatrixMultiplyData {

    public MatrixWrapper firstMatrix, secondMatrix, resultMatrix;
    public String method;
    public long execution_time;

    public MatrixMultiplyData(MatrixWrapper firstMatrix, MatrixWrapper secondMatrix, MatrixWrapper resultMatrix,
                              String method, long execution_time){

        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;

        this.method = method;

        this.execution_time = execution_time;
    }
}
