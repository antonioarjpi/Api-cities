package com.devsimple.citiesapi.controller;


import com.devsimple.citiesapi.model.City;
import com.devsimple.citiesapi.service.DistanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nearby")
@AllArgsConstructor
public class NearbyController {

    private DistanceService distanceService;

    @GetMapping
    public List<City> nearby(@RequestParam(name = "city_id") final Long cityId,
                             @RequestParam(name = "radius") final Double radius){
        return distanceService.nearby(cityId, radius);
    }
}
