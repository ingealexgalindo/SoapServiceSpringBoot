package com.example.producingwebservice.component;

import com.example.producingwebservice.models.CountryConverter;
import com.example.producingwebservice.models.CountryDTO;
import com.example.producingwebservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

import io.spring.guides.gs_producing_web_service.Country;
import org.springframework.util.Assert;


@Component
public class CountryComponent {
    private CountryService service;

    @Autowired
    public CountryComponent(CountryService service) {
        this.service = service;
    }

    public Country findCountry(String name) {
        Country countries= new Country();
        Assert.notNull(name, "The country's name must not be null");

        CountryDTO response = service.findCountryByName(name);

        if(Objects.nonNull(response)){
        countries = CountryConverter.convertToCountry(response);
        }
        return countries;
    }


    public Country saveCountry( Country country) {
        Country countries= new Country();
        //convert to dto
        CountryDTO countryDTO = CountryConverter.convertToCountryDTO(country);
        //send to save
        CountryDTO response = service.createCountry(countryDTO);
        return countries;
    }

}
