package com.example.medicalservice.repository;

import com.example.medicalservice.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,String> {
   Optional<Medicine>  findMedicineById(String medicineId);
}
