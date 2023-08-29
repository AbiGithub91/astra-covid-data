package com.astrazeneca.demo.repository;/*
 * @Author:Z0128489 nagaabimanyu.suryaprabhakar@zf.com
 * create on:  8/24/2023
 */

import com.astrazeneca.demo.entity.CovidData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidRepository extends JpaRepository<CovidData, String> {

    List<CovidData> findAll();
    List<CovidData> findByCountryregion(String country);
}
