package com.example.producingwebservice.endpoint;

import com.example.producingwebservice.component.CountryComponent;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


    private final CountryComponent countryComponent;

    @Autowired
    public CountryEndpoint(CountryComponent countryRepository) {
        this.countryComponent = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryComponent.findCountry(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCountryRequest")
    @ResponsePayload
    public CreateCountryResponse createCountry(@RequestPayload CreateCountryRequest request) {
        CreateCountryResponse response = new CreateCountryResponse();
        Country country = new Country();
        country.setName(request.getCountry().getName());
        country.setCapital(request.getCountry().getCapital());
        country.setCurrency(request.getCountry().getCurrency());
        country.setPopulation(request.getCountry().getPopulation());
        response.setSuccess(countryComponent.saveCountry(country) != null);
        return response;
    }

    /*
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCountryRequest")
    @ResponsePayload
    public UpdateCountryResponse updateCountry(@RequestPayload UpdateCountryRequest request) {
        UpdateCountryResponse response = new UpdateCountryResponse();
        Country country = new Country();
        country.setName(request.getCountry().getName());
        country.setCapital(request.getCountry().getCapital());
        country.setCurrency(request.getCountry().getCurrency());
        country.setPopulation(request.getCountry().getPopulation());
        response.setSuccess(countryService.saveCountry(country) != null);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
    @ResponsePayload
    public DeleteCountryResponse deleteCountry(@RequestPayload DeleteCountryRequest request) {
        DeleteCountryResponse response = new DeleteCountryResponse();
        response.setSuccess(countryService.deleteCountry(request.getName()));
        return response;
    }
*/

}