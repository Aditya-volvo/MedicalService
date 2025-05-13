package com.example.medicalservice.model;

import com.example.medicalservice.enums.Form;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medicine")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private String medicineId;

    @Column(name = "m_name")
    private String medicineName;

    @Column(name = "m_category")
    private String medicineCategory;

    @ElementCollection
    @CollectionTable(name = "medicine_ingredients", joinColumns = @JoinColumn(name = "m_id"))
    @Column(name = "m_Ingredients")
    private List<String> medicineIngredients;

    @Column(name = "m_dosage")
    private int dosageInMg;

    @Enumerated(EnumType.STRING)
    @Column(name = "m_from")
    private Form form;

    @Column(name = "manufacture")
    private String manufacturer;

    @Column(name = "m_stock")
    private int stockQuantity;

    @Column(name = "m_expire_at")
    private LocalDate expireDate;

    @Column(name = "m_price")
    private Double price;

    // Link to pharmacy-service by ID
    private String pharmacyId;

}
