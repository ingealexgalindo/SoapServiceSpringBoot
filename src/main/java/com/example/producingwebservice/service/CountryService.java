package com.example.producingwebservice.service;

import com.example.producingwebservice.models.CountryDTO;
import com.example.producingwebservice.repository.CountryBDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryBDRepository countryRepository;

    @Autowired
    public CountryService(CountryBDRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryDTO findCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    public CountryDTO findByCapital(String name) {
        return countryRepository.findFirstByCapital(name);
    }


    public Optional<CountryDTO> findById(Long id) {
        return countryRepository.findById(id);
    }

    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll();
    }
}
