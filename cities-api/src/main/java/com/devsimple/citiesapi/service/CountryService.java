package com.devsimple.citiesapi.service;

import com.devsimple.citiesapi.exception.ResourceNotFoundException;
import com.devsimple.citiesapi.model.Country;
import com.devsimple.citiesapi.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Page<Country> listAll(Pageable page){
        return countryRepository.findAll(page);
    }

    @Transactional
    public Country getOne(Long countryId){
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new ResourceNotFoundException("País não encotrado!"));
    }

}
