package com.astrazeneca.demo.entity;/*
 * @Author:Z0128489 nagaabimanyu.suryaprabhakar@zf.com
 * create on:  8/24/2023
 */


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "country_wise_latest")

public class CovidData {

    @Id
    private String countryregion;
    private int confirmed;
    private int deaths;
    private int recovered;
    private int active;
    private int newcases;
    private int newdeaths;

    private int newrecovered;
    private double deathsper100cases;
    private double recoveredper100cases;

    private double deathsper100recovered;

    private int confirmedlastweek;

    private int oneweekchange;

    private double oneweekpercentincrease;
    private String whoregion;

    public String getCountryregion() {
        return countryregion;
    }

    public void setCountryregion(String countryregion) {
        this.countryregion = countryregion;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getNewcases() {
        return newcases;
    }

    public void setNewcases(int newcases) {
        this.newcases = newcases;
    }

    public int getNewdeaths() {
        return newdeaths;
    }

    public void setNewdeaths(int newdeaths) {
        this.newdeaths = newdeaths;
    }

    public int getNewrecovered() {
        return newrecovered;
    }

    public void setNewrecovered(int newrecovered) {
        this.newrecovered = newrecovered;
    }

    public double getDeathsper100cases() {
        return deathsper100cases;
    }

    public void setDeathsper100cases(double deathsper100cases) {
        this.deathsper100cases = deathsper100cases;
    }

    public double getRecoveredper100cases() {
        return recoveredper100cases;
    }

    public void setRecoveredper100cases(double recoveredper100cases) {
        this.recoveredper100cases = recoveredper100cases;
    }

    public double getDeathsper100recovered() {
        return deathsper100recovered;
    }

    public void setDeathsper100recovered(double deathsper100recovered) {
        this.deathsper100recovered = deathsper100recovered;
    }

    public int getConfirmedlastweek() {
        return confirmedlastweek;
    }

    public void setConfirmedlastweek(int confirmedlastweek) {
        this.confirmedlastweek = confirmedlastweek;
    }

    public int getOneweekchange() {
        return oneweekchange;
    }

    public void setOneweekchange(int oneweekchange) {
        this.oneweekchange = oneweekchange;
    }

    public double getOneweekpercentincrease() {
        return oneweekpercentincrease;
    }

    public void setOneweekpercentincrease(double oneweekpercentincrease) {
        this.oneweekpercentincrease = oneweekpercentincrease;
    }

    public String getWhoregion() {
        return whoregion;
    }

    public void setWhoregion(String whoregion) {
        this.whoregion = whoregion;
    }

    @Override
    public String toString() {
        return "CovidData{" +
                "countryregion='" + countryregion + '\'' +
                ", confirmed=" + confirmed +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                ", active=" + active +
                ", newcases=" + newcases +
                ", newdeaths=" + newdeaths +
                ", newrecovered=" + newrecovered +
                ", deathsper100cases=" + deathsper100cases +
                ", recoveredper100cases=" + recoveredper100cases +
                ", deathsper100recovered=" + deathsper100recovered +
                ", confirmedlastweek=" + confirmedlastweek +
                ", oneweekchange=" + oneweekchange +
                ", oneweekpercentincrease=" + oneweekpercentincrease +
                ", whoregion='" + whoregion + '\'' +
                '}';
    }
}
