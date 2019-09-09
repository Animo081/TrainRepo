import java.util.Random;
import java.util.Vector;

public abstract class AbstractMatrixManager implements MatrixManager<Integer>{

    protected Random randomValue;

    @Override
    public Vector<Vector<Integer>> createRandomMatrix(int dimension) {

        //Creating matrix with specific size, rows not added
        Vector<Vector<Integer>> matrix = new Vector<>();

        //Initializing matrix rows
        initializeMatrixRows(matrix, dimension);

        //Filling matrix with random values
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                matrix.get(i).add(randomValue.nextInt(10));
            }
        }
        return matrix;
    }

    protected Vector<Vector<Integer>> createZeroMatrix(int dimension) {

        //Creating matrix with specific size, rows not added
        Vector<Vector<Integer>> matrix = new Vector<>(dimension);

        initializeMatrixRows(matrix, dimension);

        //Filling matrix with zero values
        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                matrix.get(i).add(0);
            }
        }
        return matrix;
    }

    protected void initializeMatrixRows(Vector<Vector<Integer>> matrix, int dimension) {

        for (int i = 0; i < dimension; i++){
            matrix.add(new Vector<Integer>(dimension));
        }
    }

    @Override
    public void printMatrix(Vector<Vector<Integer>> matrix) {

        for (int i = 0; i < matrix.size(); i++){
            for (int j = 0; j < matrix.size(); j++){
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public abstract Vector<Vector<Integer>> matrixMultiply(Vector<Vector<Integer>> firstMatrix,
                                                           Vector<Vector<Integer>> secondMatrix);

}
