package com.example.medicalservice.exceptionhandeling;

import com.example.medicalservice.dto.MedicineNotFoundResponse;
import com.example.medicalservice.exception.MedicineNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandelMedicineNotFoundException {

    @ExceptionHandler(MedicineNotFoundException.class)
    public ResponseEntity<MedicineNotFoundResponse> handleMedicineNotFoundExceptions(MedicineNotFoundException ex){
        MedicineNotFoundResponse error = new MedicineNotFoundResponse(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
