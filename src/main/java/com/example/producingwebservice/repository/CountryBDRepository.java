package com.example.producingwebservice.repository;

import com.example.producingwebservice.models.CountryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryBDRepository  extends JpaRepository<CountryDTO, Long> {
    CountryDTO findByName(String name);
    CountryDTO findFirstByCapital(String name);
}
