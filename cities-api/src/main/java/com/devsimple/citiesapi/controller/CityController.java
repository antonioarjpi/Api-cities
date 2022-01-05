package com.devsimple.citiesapi.controller;

import com.devsimple.citiesapi.model.City;
import com.devsimple.citiesapi.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private CityService cityService;

    @GetMapping
    public Page<City> listCountries(Pageable page){
        return cityService.listAll(page);
    }

    @GetMapping("/{cityId}")
    public City getOne(@PathVariable Long cityId){
        return cityService.getOne(cityId);
    }
}
