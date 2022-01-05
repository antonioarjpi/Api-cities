package com.devsimple.citiesapi.controller;

import com.devsimple.citiesapi.model.State;
import com.devsimple.citiesapi.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/states")
@AllArgsConstructor
public class StateController {

    private StateService stateService;

    @GetMapping
    public Page<State> listCountries(Pageable page){
        return stateService.listAll(page);
    }

    @GetMapping("/{stateId}")
    public State getOne(@PathVariable Long stateId){
        return stateService.getOne(stateId);
    }
}
