package com.example.medicalservice.mapper;

import com.example.medicalservice.dto.MedicineResponse;
import com.example.medicalservice.model.Medicine;

public class GlobalMapper {
    public MedicineResponse mapToMedicineResponse(Medicine medicine1) {
        return MedicineResponse.builder()
                .medicineId(medicine1.getMedicineId())
                .medicineName(medicine1.getMedicineName())
                .medicineCategory(medicine1.getMedicineCategory())
                .medicineIngredients(medicine1.getMedicineIngredients())
                .form(medicine1.getForm())
                .dosageInMg(medicine1.getDosageInMg())
                .manufacturer(medicine1.getManufacturer())
                .stockQuantity(medicine1.getStockQuantity())
                .expireDate(medicine1.getExpireDate())
                .price(medicine1.getPrice())
                .pharmacyId(medicine1.getPharmacyId())
                .build();
    }
}
