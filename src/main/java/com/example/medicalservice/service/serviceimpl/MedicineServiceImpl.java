package com.example.medicalservice.service.serviceimpl;

import com.example.medicalservice.dto.MedicineRequest;
import com.example.medicalservice.dto.MedicineResponse;
import com.example.medicalservice.model.Medicine;
import com.example.medicalservice.repository.MedicineRepository;
import com.example.medicalservice.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private final MedicineRepository medicineRepository;
    @Override
    public ResponseEntity<MedicineResponse> addMedicine(MedicineRequest medicineRequest) {
        Medicine medicine = Medicine.builder()
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
        Medicine saved = medicineRepository.save(medicine);

        return ResponseEntity.ok(
                new MedicineResponse(
                        saved.getMedicineId(),
                        saved.getMedicineName(),
                        saved.getMedicineCategory(),
                        saved.getMedicineIngredients(),
                        saved.getDosageInMg(),
                        saved.getForm(),
                        saved.getManufacturer(),
                        saved.getStockQuantity(),
                        saved.getExpireDate(),
                        saved.getPrice(),
                        saved.getPharmacyId()
                ));
    }


}
