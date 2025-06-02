package com.example.medicalservice.client;

import com.example.medicalservice.dto.PharmacyDto;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "pharmacy-service", url = "${pharmacy.service.url}")
public interface PharmacyClient {
    @GetMapping("/api/pharmacy/{pharmacyId}")
    PharmacyDto getPharmacyById(@NotBlank Long pharmacyId);


}
