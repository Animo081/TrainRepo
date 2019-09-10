public abstract class AbstractMatrixManager implements MatrixManager{

    @Override
    public void printMatrix(MatrixWrapper matrix) {

        for (int row = 0; row < matrix.size(); row++){
            for (int column = 0; column < matrix.size(); column++){
                System.out.print(matrix.get(row, column) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public abstract MatrixWrapper matrixMultiply(MatrixWrapper firstMatrix,
                                                 MatrixWrapper secondMatrix);

}
