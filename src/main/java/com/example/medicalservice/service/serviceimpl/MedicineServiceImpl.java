package com.example.medicalservice.service.serviceimpl;

import com.example.medicalservice.dto.MedicineRequest;
import com.example.medicalservice.dto.MedicineResponse;
import com.example.medicalservice.exception.MedicineNotFoundException;
import com.example.medicalservice.mapper.GlobalMapper;
import com.example.medicalservice.model.Medicine;
import com.example.medicalservice.repository.MedicineRepository;
import com.example.medicalservice.response.GlobalResponseEntity;
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
    private final GlobalMapper globalMapper;
    private final GlobalResponseEntity globalResponseEntity;
    @Override
    public ResponseEntity<MedicineResponse> addMedicine(MedicineRequest medicineRequest) {
        Medicine medicine = globalMapper.mapMedicineRequestToMedicine(medicineRequest);

        Medicine saved = medicineRepository.save(medicine);

        return globalResponseEntity.ok(saved);
    }

    @Override
    public List<MedicineResponse> getListOfAllMedicines() {
       List<Medicine>  medicine = medicineRepository.findAll();
        return medicine.stream().map(globalMapper::mapToMedicineResponse).toList();
    }

    @Override
    public ResponseEntity<MedicineResponse> getMedicineById(Long medicineId) {
        Medicine medicine = medicineRepository.findMedicineById(medicineId)
                .orElseThrow(()-> new MedicineNotFoundException("Medicine with ID:"+medicineId+"Not Found"));
       return globalResponseEntity.ok(medicine);
    }

    @Override
    public ResponseEntity<MedicineResponse> updateMedicineById(Long medicineId, MedicineRequest medicineRequest) {
        Medicine medicine = medicineRepository.findMedicineById(medicineId)
                .orElseThrow(()-> new MedicineNotFoundException("Medicine with ID:"+medicineId+"Not Found"));

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

        return globalResponseEntity.ok(saved);
    }

    @Override
    public String deleteMedicineById(Long medicineId) {
        Medicine medicine = medicineRepository.findMedicineById(medicineId)
                .orElseThrow(()-> new MedicineNotFoundException("Medicine with ID:"+medicineId+"Not Found"));
        medicineRepository.delete(medicine);
        return "Medicine with Id:"+medicine.getMedicineId()+"was Deleted.";
    }
}
