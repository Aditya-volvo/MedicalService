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
    public ResponseEntity<MedicineResponse> getMedicineById(@PathVariable Long medicineId){
        return medicineService.getMedicineById(medicineId);
    }

    public List<Medicine> getMedicineByPharmacyId(@PathVariable Long pharmacyId){
        return medicineService.getMedicineByPharmacyId(pharmacyId);
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<MedicineResponse> upadateMedicineById(@PathVariable Long medicineId, @RequestBody MedicineRequest medicineRequest){
        return medicineService.updateMedicineById(medicineId,medicineRequest);
    }

    @DeleteMapping("/{medicineId}")
    public String deleteMedicineById(@PathVariable Long medicineId){
        return  medicineService.deleteMedicineById(medicineId);
    }

}
