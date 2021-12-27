package com.bida.matrix.multilication.web;

import com.bida.matrix.multilication.dto.MatrixDTO;
import com.bida.matrix.multilication.dto.MatrixDataDTO;
import com.bida.matrix.multilication.service.MatrixMultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrixController {

    @Autowired
    private MatrixMultiplicationService matrixMultiplicationService;

    @PostMapping("/multiply1")
    public ResponseEntity<?> multiply1(@RequestBody MatrixDTO matrixDTO) throws Exception {
        matrixMultiplicationService.multiplication(matrixDTO.getMatrixA(), matrixDTO.getMatrixB(), matrixDTO.getThreadsSize());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/multiply2")
    public ResponseEntity<?> multiply2(@RequestBody MatrixDataDTO matrixDTO) throws Exception {
        matrixMultiplicationService.multiplication(matrixDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
