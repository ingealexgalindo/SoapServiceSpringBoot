package com.example.producingwebservice.models;

import io.spring.guides.gs_producing_web_service.Country;

public class CountryConverter {
    public static Country convertToCountry(CountryDTO countryDTO) {
        if (countryDTO == null) {
            return null;
        }
        Country country = new Country();
        country.setName(countryDTO.getName());
        country.setCapital(countryDTO.getCapital());
        country.setCurrency(countryDTO.getCurrency());
        country.setPopulation(countryDTO.getPopulation());
        return country;
    }

    public static CountryDTO convertToCountryDTO(Country country) {
        if (country == null) {
            return null;
        }
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        countryDTO.setCapital(country.getCapital());
        countryDTO.setCurrency(country.getCurrency());
        countryDTO.setPopulation(country.getPopulation());
        return countryDTO;
    }

}
