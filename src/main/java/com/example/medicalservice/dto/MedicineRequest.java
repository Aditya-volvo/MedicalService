package com.example.medicalservice.dto;

import com.example.medicalservice.enums.Form;
import jakarta.persistence.*;
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
public class MedicineRequest {
    @NotBlank
    private String medicineName;

    @NotBlank
    private String medicineCategory;

    @NotBlank
    private List<String> medicineIngredients;

    @NotBlank
    private int dosageInMg;

    @NotBlank
    private Form form;

    @NotBlank
    private String manufacturer;

    @NotBlank
    private int stockQuantity;

    @NotBlank
    private LocalDate expireDate;

    @NotBlank
    private Double price;

    @NotBlank
    private Long pharmacyId;
}
