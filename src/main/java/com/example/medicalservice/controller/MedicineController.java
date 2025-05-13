package com.example.medicalservice.controller;

import com.example.medicalservice.dto.MedicineRequest;
import com.example.medicalservice.dto.MedicineResponse;
import com.example.medicalservice.model.Medicine;
import com.example.medicalservice.service.MedicineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@RequiredArgsConstructor
public class MedicineController {
    private final MedicineService medicineService;

    @PostMapping
    public ResponseEntity<MedicineResponse> addMedicine(@Valid @RequestBody MedicineRequest medicineRequest){
    return medicineService.addMedicine(medicineRequest);
    }

    @GetMapping
    public List<MedicineResponse> getListOfAllMedicines(){
        return medicineService.getListOfAllMedicines();
    }

    @GetMapping("/{medicineId}")
    public ResponseEntity<MedicineResponse> getMedicineById(@PathVariable String medicineId){
        return medicineService.getMedicineById(medicineId);
    }

}
