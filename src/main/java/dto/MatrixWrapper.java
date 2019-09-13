package dto;

import java.util.AbstractCollection;
import java.util.Random;
import java.util.Vector;

public class MatrixWrapper {

    private Random randomValue;

    private int dimension;
    private Vector<Vector<Integer>> matrix;

    private long matrixId;

    public MatrixWrapper(int dimension) {

        randomValue = new Random();

        this.dimension = dimension;

        this.matrix = new Vector<>(dimension);
        initializeRows(this.matrix);
    }

    private void initializeRows(Vector<Vector<Integer>> matrix) {

        matrix.removeAllElements();

        for (int i = 0; i < dimension; i++){
            matrix.add(new Vector<Integer>(dimension));
        }
    }

    public void initializeZeros() {

        double zero = 0;

        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                matrix.get(i).add(0);
            }
        }
    }

    public void initializeRandoms() {

        for (int i = 0; i < dimension; i++){
            for (int j = 0; j < dimension; j++) {
                matrix.get(i).add(randomValue.nextInt(10));
            }
        }
    }

    public void fillUsingCollection(AbstractCollection collection){

        if (checkPerfectSquare(collection.size())){
            for (Object value: collection){
                this.push((Integer) value);
            }
        } else {
            throw new IllegalArgumentException("Elements number is invalid");
        }
    }

    private boolean checkPerfectSquare(double x) {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }

    public boolean push(int value) {

        for (int i = 0; i < dimension; i++){
            if (matrix.get(i).size() < dimension) {
                matrix.get(i).add(value);
                return true;
            }
        }
        return false;
    }

    public int size() { return matrix.size(); }

    public void set(int element, int row, int column) { matrix.get(row).set(column, element); }
    public void setId(long id) { this.matrixId = id; }

    public int get(int row, int column) { return matrix.get(row).get(column); }
    public long getId() { return matrixId; }

    public String toString() {

        String stringMatrix = "";

        for (int row = 0; row < dimension; row++){
            for (int column = 0; column < dimension; column++){
                stringMatrix += get(row, column) + " ";
            }
            stringMatrix += "\n";
        }
        return stringMatrix;
    }
}
