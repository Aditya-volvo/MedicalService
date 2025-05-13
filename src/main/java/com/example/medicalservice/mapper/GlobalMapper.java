package com.example.medicalservice.mapper;

import com.example.medicalservice.dto.MedicineRequest;
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

    public Medicine mapMedicineRequestToMedicine(MedicineRequest medicineRequest){
        return Medicine.builder()
                .medicineName(medicineRequest.getMedicineName())
                .medicineCategory(medicineRequest.getMedicineCategory())
                .medicineIngredients(medicineRequest.getMedicineIngredients())
                .dosageInMg(medicineRequest.getDosageInMg())
                .form(medicineRequest.getForm())
                .manufacturer(medicineRequest.getManufacturer())
                .stockQuantity(medicineRequest.getStockQuantity())
                .expireDate(medicineRequest.getExpireDate())
                .price(medicineRequest.getPrice())
                .pharmacyId(medicineRequest.getPharmacyId())
                .build();
    }
}
