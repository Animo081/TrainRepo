package com.vector.testtask.utils;

import com.vector.testtask.dto.MatrixWrapper;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class FileUtils {

    public static MatrixWrapper getMatrixFromStream(InputStream inputStream) throws IOException {

        MatrixWrapper matrix; //Matrix from file

        int character, value = 0; //Character from file, value from characters
        boolean newValRead = false, isNegative = false; //Check if value was read and if its negative

        Vector<Integer> values = new Vector<>(); //Values storage

        while ((character = inputStream.read()) != -1){
            if (character >= '0' && character <= '9'){
                newValRead = true;
                value = value * 10 + character - '0';
            } else {
                if (character == '-') {
                    isNegative = true;
                }
                else {
                    if (newValRead) {
                        if (isNegative) values.add(value * (-1));
                        else values.add(value);
                    }
                    isNegative = false;
                }
                newValRead = false;
                value = 0;
            }
        }
        //Check if 'value' stores last value from file
        if (newValRead) {
            if (isNegative) values.add(value * (-1));
            else values.add(value);
        }

        //Generating matrix using Collection values
        matrix = new MatrixWrapper((int)Math.sqrt(values.size()));
        matrix.fillUsingCollection(values);

        return matrix;
    }

    public static void writeMatrixToFile(MatrixWrapper matrix, String fileName) throws IOException {

        FileWriter file = new FileWriter(fileName);

        for (int row = 0; row < matrix.size(); row++){
            for (int column = 0; column < matrix.size(); column++){
                file.write(matrix.get(row, column) + " ");
            }
            file.write("\n");
        }
        file.close();
    }
}
