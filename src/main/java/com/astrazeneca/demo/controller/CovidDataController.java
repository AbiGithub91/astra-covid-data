package com.astrazeneca.demo.controller;/*
 * @Author:Z0128489 nagaabimanyu.suryaprabhakar@zf.com
 * create on:  8/24/2023
 */

import com.astrazeneca.demo.dto.CovidResponse;
import com.astrazeneca.demo.entity.CovidData;
import com.astrazeneca.demo.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/covid")
public class CovidDataController {

    private final CovidService covidDataService;

    public CovidDataController(CovidService covidDataService) {
        this.covidDataService = covidDataService;
    }
    @GetMapping("/cumulative")
    public ResponseEntity<CovidResponse> getCumulativeValues() {
        CovidResponse cumulativeValues = covidDataService.getCumulativeValues();
        return ResponseEntity.ok(cumulativeValues);
    }

    @GetMapping("/cumulative/{country}")
    public ResponseEntity<CovidResponse> getCumulativeValuesByCountry(@PathVariable String country) {
        CovidResponse cumulativeCountryData = covidDataService.getCumulativeValuesByCountry(country);
        if (cumulativeCountryData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cumulativeCountryData);
    }
}

