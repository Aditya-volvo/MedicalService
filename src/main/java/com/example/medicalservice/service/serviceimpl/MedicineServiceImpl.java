package com.example.medicalservice.service.serviceimpl;

import com.example.medicalservice.dto.MedicineRequest;
import com.example.medicalservice.dto.MedicineResponse;
import com.example.medicalservice.model.Medicine;
import com.example.medicalservice.repository.MedicineRepository;
import com.example.medicalservice.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

    @Override
    public List<MedicineResponse> getListOfAllMedicines() {
       List<Medicine>  medicine = medicineRepository.findAll();
        return medicine.stream().map(this::mapToMedicineResponse).toList();
    }

    @Override
    public ResponseEntity<MedicineResponse> getMedicineById(String medicineId) {
        Medicine medicine = medicineRepository.findMedicineById(medicineId).orElseThrow();
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

    @Override
    public ResponseEntity<MedicineResponse> updateMedicineById(String medicineId, MedicineRequest medicineRequest) {
        Medicine medicine = medicineRepository.findMedicineById(medicineId).orElseThrow();

        medicine.setMedicineName(medicineRequest.getMedicineName());
        medicine.setMedicineCategory(medicineRequest.getMedicineCategory());
        medicine.setMedicineIngredients(medicineRequest.getMedicineIngredients());
        medicine.setDosageInMg(medicineRequest.getDosageInMg());
        medicine.setForm(medicineRequest.getForm());
        medicine.setManufacturer(medicineRequest.getManufacturer());
        medicine.setStockQuantity(medicineRequest.getStockQuantity());
        medicine.setExpireDate(medicineRequest.getExpireDate());
        medicine.setPrice(medicineRequest.getPrice());
        medicine.setPharmacyId(medicineRequest.getPharmacyId());

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

    @Override
    public String deleteMedicineById(String medicineId) {
        Medicine medicine = medicineRepository.findMedicineById(medicineId).orElseThrow();
        medicineRepository.delete(medicine);
        return "Medicine with Id:"+medicine.getMedicineId()+"was Deleted.";
    }


    private MedicineResponse mapToMedicineResponse(Medicine medicine1) {
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
