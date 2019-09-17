package com.vector.testtask.dto;

public class MatrixMultiplyData {

    public MatrixWrapper firstMatrix, secondMatrix, resultMatrix;
    public String method;
    public long execution_time;

    public MatrixMultiplyData(MatrixWrapper firstMatrix, MatrixWrapper secondMatrix, MatrixWrapper resultMatrix,
                              String method,
                              long execution_time){

        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.method = method;
        this.execution_time = execution_time;
    }

    public MatrixWrapper getFirstMatrix() { return firstMatrix; }

    public void setFirstMatrix(MatrixWrapper matrix) { this.firstMatrix = matrix; }

    public MatrixWrapper getSecondMatrix() { return secondMatrix; }

    public void setSecondMatrix(MatrixWrapper matrix) { this.secondMatrix = matrix; }

    public MatrixWrapper getResultMatrix() { return resultMatrix; }

    public void setResultMatrix(MatrixWrapper matrix) { this.resultMatrix = matrix; }

    public String getMethod() { return method; }

    public void setMethod(String method) { this.method = method; }

    public long getExecution_time() { return execution_time; }

    public void setExecution_time(long execution_time) { this.execution_time = execution_time; }
}
