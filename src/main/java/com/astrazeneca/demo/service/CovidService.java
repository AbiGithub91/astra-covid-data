package com.astrazeneca.demo.service;/*
 * @Author:Z0128489 nagaabimanyu.suryaprabhakar@zf.com
 * create on:  8/24/2023
 */

import com.astrazeneca.demo.dto.CovidResponse;

import java.util.Map;

public interface CovidService {

    public CovidResponse getCumulativeValues();

    public CovidResponse getCumulativeValuesByCountry(String country);

}
