package com.astrazeneca.demo.serviceimpl;/*
 * @Author:Z0128489 nagaabimanyu.suryaprabhakar@zf.com
 * create on:  8/24/2023
 */

import com.astrazeneca.demo.dto.CovidResponse;
import com.astrazeneca.demo.entity.CovidData;
import com.astrazeneca.demo.repository.CovidRepository;
import com.astrazeneca.demo.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CovidServiceImpl implements CovidService {

    private final CovidRepository covidRepository;

    public CovidServiceImpl(CovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    public CovidResponse getCumulativeValues() {
        List<CovidData> allData = covidRepository.findAll();
        System.out.println(allData);
        int totalConfirmed = allData.stream().mapToInt(CovidData::getConfirmed).sum();
        int totalDeaths = allData.stream().mapToInt(CovidData::getDeaths).sum();
        int totalRecovered = allData.stream().mapToInt(CovidData::getRecovered).sum();
        int totalActive = allData.stream().mapToInt(CovidData::getActive).sum();

        int totalNewCases = allData.stream().mapToInt(CovidData::getNewcases).sum();
        int totalNewDeaths = allData.stream().mapToInt(CovidData::getNewdeaths).sum();
        int totalNewRecovered = allData.stream().mapToInt(CovidData::getNewrecovered).sum();

        Map<String, Integer> cumulativeValues = new HashMap<>();
        cumulativeValues.put("confirmed", totalConfirmed);
        cumulativeValues.put("deaths", totalDeaths);
        cumulativeValues.put("recovered", totalRecovered);
        cumulativeValues.put("active", totalActive);
        cumulativeValues.put("newactive", totalNewCases);
        cumulativeValues.put("newdeaths", totalNewDeaths);
        cumulativeValues.put("newrecovered", totalNewRecovered);

        CovidResponse response = new CovidResponse(cumulativeValues, allData);

        return response;
    }

    public CovidResponse getCumulativeValuesByCountry(String country) {
        List<CovidData> countryData = covidRepository.findByCountryregion(country);
        if (countryData.isEmpty()) {
            return null;
        }

        int totalConfirmed = countryData.stream().mapToInt(CovidData::getConfirmed).sum();
        int totalDeaths = countryData.stream().mapToInt(CovidData::getDeaths).sum();
        int totalRecovered = countryData.stream().mapToInt(CovidData::getRecovered).sum();
        int totalActive = countryData.stream().mapToInt(CovidData::getActive).sum();

        Map<String, Integer> cumulativeValues = new HashMap<>();
        cumulativeValues.put("confirmed", totalConfirmed);
        cumulativeValues.put("deaths", totalDeaths);
        cumulativeValues.put("recovered", totalRecovered);
        cumulativeValues.put("active", totalActive);
        CovidResponse response = new CovidResponse(cumulativeValues, countryData);

        return response;
    }

}
