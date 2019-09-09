import org.jcp.xml.dsig.internal.dom.Utils;
import sun.security.util.ArrayUtil;

import java.util.Random;
import java.util.Vector;

public class MatrixWrapper {

    private Random randomValue;

    private int dimension;
    private Vector<Vector<Integer>> matrix;

    MatrixWrapper(int dimension) {

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

    public int size() { return matrix.size(); }

    public int get(int row, int column) { return matrix.get(row).get(column); }

    public void set(int element, int row, int column) { matrix.get(row).set(column, element); }
}
