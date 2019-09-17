package com.vector.testtask;

import com.vector.testtask.dto.MatrixMultiplyData;
import com.vector.testtask.dto.MatrixWrapper;
import com.vector.testtask.service.MatrixManager;
import com.vector.testtask.service.impl.CommonMatrixManager;
import com.vector.testtask.service.impl.MatrixSQLService;
import com.vector.testtask.utils.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@ComponentScan(basePackages = "com.vector.testtask")
@PropertySource(value = {"classpath:application.properties"})
public class TrainingApplication {

    private static ApplicationContext applicationContext;

    public static MatrixSQLService matrixSQLService;

    public static InputStream inputStream;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        MatrixWrapper firstMatrix, secondMatrix;
        MatrixMultiplyData result;

        applicationContext = new AnnotationConfigApplicationContext(TrainingApplication.class);

        MatrixManager manager = applicationContext.getBean(CommonMatrixManager.class);

        inputStream = new FileInputStream("files/firstMatrix.txt");
        firstMatrix = FileUtils.getMatrixFromStream(inputStream);

        inputStream = new FileInputStream("files/secondMatrix.txt");
        secondMatrix = FileUtils.getMatrixFromStream(inputStream);

        result = manager.matrixMultiply(firstMatrix,secondMatrix);

        matrixSQLService = applicationContext.getBean(MatrixSQLService.class);

        matrixSQLService.sendMultiplyResultToDB(result);
    }
}
