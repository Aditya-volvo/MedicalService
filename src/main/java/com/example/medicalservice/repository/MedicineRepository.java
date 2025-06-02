package com.example.medicalservice.repository;

import com.example.medicalservice.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
   Optional<Medicine>  findMedicineById(Long medicineId);


    List<Medicine> findMedicineByPharmacyId(Long pharmacyId);
}
