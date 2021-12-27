package com.bida.matrix.multilication.dto;

import lombok.Data;

@Data
public class MatrixDTO {

    private int[][] matrixA;
    private int[][] matrixB;
    private int threadsSize;
}
