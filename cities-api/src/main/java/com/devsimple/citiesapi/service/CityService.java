package com.devsimple.citiesapi.service;

import com.devsimple.citiesapi.exception.ResourceNotFoundException;
import com.devsimple.citiesapi.model.City;
import com.devsimple.citiesapi.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public Page<City> listAll(Pageable page){
        return cityRepository.findAll(page);
    }

    @Transactional
    public City getOne(Long cityId){
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException("Cidade não encotrado!"));
    }

}
