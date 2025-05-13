package com.example.medicalservice.service;

import com.example.medicalservice.dto.MedicineRequest;
import com.example.medicalservice.dto.MedicineResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MedicineService {
    ResponseEntity<MedicineResponse> addMedicine(@Valid MedicineRequest medicineRequest);

    List<MedicineResponse> getListOfAllMedicines();

    ResponseEntity<MedicineResponse> getMedicineById(String medicineId);

    ResponseEntity<MedicineResponse> updateMedicineById(String medicineId, MedicineRequest medicineRequest);

    String deleteMedicineById(String medicineId);
}
