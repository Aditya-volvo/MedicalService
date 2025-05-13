package com.example.medicalservice.response;

import com.example.medicalservice.dto.MedicineResponse;
import com.example.medicalservice.model.Medicine;
import org.springframework.http.ResponseEntity;

public class GlobalResponseEntity {

    public ResponseEntity<MedicineResponse> ok(Medicine medicine){
        return ResponseEntity.ok(
                new MedicineResponse(
                        medicine.getMedicineId(),
                        medicine.getMedicineName(),
                        medicine.getMedicineCategory(),
                        medicine.getMedicineIngredients(),
                        medicine.getDosageInMg(),
                        medicine.getForm(),
                        medicine.getManufacturer(),
                        medicine.getStockQuantity(),
                        medicine.getExpireDate(),
                        medicine.getPrice(),
                        medicine.getPharmacyId()
                ));
    }
}
