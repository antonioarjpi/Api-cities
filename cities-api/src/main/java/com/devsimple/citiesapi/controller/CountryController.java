package com.devsimple.citiesapi.controller;

import com.devsimple.citiesapi.model.Country;
import com.devsimple.citiesapi.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping
    public Page<Country> listCountries(Pageable page){
        return countryService.listAll(page);
    }

    @GetMapping("/{countryId}")
    public Country getOne(@PathVariable Long countryId){
        return countryService.getOne(countryId);
    }
}
