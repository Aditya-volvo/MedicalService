package com.example.medicalservice.dto;

import com.example.medicalservice.enums.Form;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicineResponse {
    private String medicineId;
    private String medicineName;
    private String medicineCategory;
    private List<String> medicineIngredients;
    private int dosageInMg;
    private Form form;
    private String manufacturer;
    private int stockQuantity;
    private LocalDate expireDate;
    private Double price;
    private Long pharmacyId;
}
