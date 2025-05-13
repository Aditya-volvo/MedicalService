package com.example.medicalservice.service;

import com.example.medicalservice.dto.MedicineRequest;
import com.example.medicalservice.dto.MedicineResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface MedicineService {
    ResponseEntity<MedicineResponse> addMedicine(@Valid MedicineRequest medicineRequest);
}
