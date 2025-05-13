package com.example.medicalservice.exception;

public class MedicineNotFoundException extends RuntimeException{
    public MedicineNotFoundException(String message){
        super(message);
    }
}
