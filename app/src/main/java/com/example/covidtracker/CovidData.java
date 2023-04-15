package com.example.covidtracker;

import com.google.gson.annotations.SerializedName;

public class CovidData {

    @SerializedName("cases")
    private Integer casesData;

    public Integer getCasesData(){
        return casesData;
    }

    public void setCasesData(Integer casesData){
        this.casesData = casesData;
    }

    @SerializedName("recovered")
    private Integer recoveredData;

    public Integer getRecoveredData(){
        return recoveredData;
    }

    public void setRecoveredData(Integer recoveredData){
        this.recoveredData = recoveredData;
    }

    @SerializedName("deaths")
    private Integer deathsData;

    public Integer getDeathsData(){
        return deathsData;
    }

    public void setDeathsData(Integer deathsData){
        this.deathsData = deathsData;
    }


}
