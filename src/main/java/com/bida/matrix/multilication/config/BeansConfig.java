package com.bida.matrix.multilication.config;

import com.bida.matrix.multilication.service.Matrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeansConfig {

    @Bean(name = "matrix500")
    @Scope("singleton")
    public int[][] createMatrix500() {
        return Matrix.randomMatrix(500, 500, 1, 9);
    }

    @Bean(name = "matrix1000")
    @Scope("singleton")
    public int[][] createMatrix1000() {
        return Matrix.randomMatrix(1000, 1000, 1, 9);
    }

    @Bean(name = "matrix1500")
    @Scope("singleton")
    public int[][] createMatrix1500() {
        return Matrix.randomMatrix(1500, 1500, 1, 9);
    }

    @Bean(name = "matrix2000")
    @Scope("singleton")
    public int[][] createMatrix2000() {
        return Matrix.randomMatrix(2000, 2000, 1, 9);
    }
}
