package com.astrazeneca.demo.dto;/*
 * @Author:Z0128489 nagaabimanyu.suryaprabhakar@zf.com
 * create on:  8/26/2023
 */

import com.astrazeneca.demo.entity.CovidData;

import java.util.List;
import java.util.Map;

public class CovidResponse {
    private Map<String, Integer> cumulativeValues;
    private List<CovidData> allData;

    public CovidResponse(Map<String, Integer> cumulativeValues, List<CovidData> allData) {
        this.cumulativeValues = cumulativeValues;
        this.allData = allData;
    }

    public Map<String, Integer> getCumulativeValues() {
        return cumulativeValues;
    }

    public void setCumulativeValues(Map<String, Integer> cumulativeValues) {
        this.cumulativeValues = cumulativeValues;
    }

    public List<CovidData> getAllData() {
        return allData;
    }

    public void setAllData(List<CovidData> allData) {
        this.allData = allData;
    }
}
