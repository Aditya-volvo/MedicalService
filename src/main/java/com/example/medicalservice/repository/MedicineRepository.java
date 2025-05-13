package com.example.medicalservice.repository;

import com.example.medicalservice.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,String> {
}
