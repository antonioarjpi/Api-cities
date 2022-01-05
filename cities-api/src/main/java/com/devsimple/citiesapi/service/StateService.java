package com.devsimple.citiesapi.service;

import com.devsimple.citiesapi.exception.ResourceNotFoundException;
import com.devsimple.citiesapi.model.Country;
import com.devsimple.citiesapi.model.State;
import com.devsimple.citiesapi.repository.CountryRepository;
import com.devsimple.citiesapi.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Transactional
    public Page<State> listAll(Pageable page){
        return stateRepository.findAll(page);
    }

    @Transactional
    public State getOne(Long stateId){
        return stateRepository.findById(stateId)
                .orElseThrow(() -> new ResourceNotFoundException("Estado não encotrado!"));
    }

}
