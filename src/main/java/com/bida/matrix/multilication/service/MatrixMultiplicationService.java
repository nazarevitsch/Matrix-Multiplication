package com.bida.matrix.multilication.service;

import com.bida.matrix.multilication.dto.MatrixDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MatrixMultiplicationService {

    @Autowired
    @Qualifier(value = "matrix500")
    private int[][] matrix500;

    @Autowired
    @Qualifier(value = "matrix1000")
    private int[][] matrix1000;

    @Autowired
    @Qualifier(value = "matrix1500")
    private int[][] matrix1500;

    @Autowired
    @Qualifier(value = "matrix2000")
    private int[][] matrix2000;


    public int[][] multiplication(MatrixDataDTO matrixDataDTO) throws Exception{
        int[][] matrix;
        if (matrixDataDTO.getMatrixSize() == 500) {
            matrix = matrix500;
        } else if (matrixDataDTO.getMatrixSize() == 1000) {
            matrix = matrix1000;
        } else if (matrixDataDTO.getMatrixSize() == 1500) {
            matrix = matrix1500;
        } else {
            matrix = matrix2000;
        }

        return multiplication(matrix, matrix, matrixDataDTO.getThreadsSize());
    }

    public int[][] multiplication(int[][] a, int[][] b, int threadsSize) throws Exception {
        Matrix.check(a, b);
        Result result = new Result(Matrix.zeroMatrix(a.length, b[0].length));

        long start = System.currentTimeMillis();
        if (threadsSize <= 0) threadsSize = a.length;
        LinearThread[] linearThread = new LinearThread[threadsSize];

        int rowsPerThread = a.length / threadsSize;
        for (int i = 0; i < threadsSize; i++) {
            linearThread[i] = new LinearThread(b, rowsPerThread, rowsPerThread * i, rowsPerThread * (i + 1));
            for (int l = 0; l < rowsPerThread; l++) {
                linearThread[i].setRowAAndC(a[rowsPerThread * i + l], result.getMatrix()[rowsPerThread * i + l], l);
            }
            linearThread[i].start();
        }
        for (LinearThread thread : linearThread) {
            thread.join();
        }
        long finish = System.currentTimeMillis();
        double t = (finish - start) / 1000.0;
        System.out.println("Time Linear: " + t + " sec.");
        return result.getMatrix();
    }
}
