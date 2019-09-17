package com.vector.testtask;


import com.vector.testtask.dto.MatrixMultiplyData;
import com.vector.testtask.service.MatrixManager;
import com.vector.testtask.service.impl.CommonMatrixManager;
import com.vector.testtask.service.impl.MatrixManagerWithThreads;
import com.vector.testtask.service.impl.MatrixSQLService;
import com.vector.testtask.service.impl.SQLConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean(name = "matrixManagerWithThreads")
    public MatrixManager getMatrixManagerWithThreads(){
        return new MatrixManagerWithThreads();
    };

    @Bean(name = "commonMatrixManager")
    public MatrixManager getCommonMatrixManager(){
        return new CommonMatrixManager();
    }

    @Bean
    public SQLConnection getSQLConnection(){
        return new SQLConnection();
    }

    @Bean
    public MatrixSQLService getMatrixSQLService(){
        return new MatrixSQLService();
    }
}
