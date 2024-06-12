package com.example.common;

import java.util.Calendar;

public class AppManager {

    private int dailyConsumptionLimit;
    private int dailyConsumptionValue;

    public AppManager(){

    }

    public AppManager(int dailyConsumptionLimit){
        this.dailyConsumptionValue = 0;
        this.dailyConsumptionLimit = dailyConsumptionLimit;
    }

    public int getDailyConsumptionLimit() {
        return dailyConsumptionLimit;
    }

    public int getDailyConsumptionValue() {
        return dailyConsumptionValue;
    }

    public AppManager setDailyConsumptionLimit(int dailyConsumptionLimit) {
        this.dailyConsumptionLimit = dailyConsumptionLimit;
        return this;
    }

    public AppManager setDailyConsumptionValue(int dailyConsumptionValue) {
        this.dailyConsumptionValue = dailyConsumptionValue;
        return this;
    }

    public void addDailyConsumptionValue(int value){
        dailyConsumptionValue += value;
        if(dailyConsumptionValue > dailyConsumptionLimit)
            dailyConsumptionValue = dailyConsumptionLimit;
    }

    public void resetDailyConsumptionValue(){
        dailyConsumptionValue = 0;
    }

    public void addLimit(int factorLimit){
        dailyConsumptionLimit += factorLimit;
    }

    public void reduceLimit(int factorLimit){
        int temp = dailyConsumptionLimit - factorLimit;
        if(temp >= dailyConsumptionValue)
            dailyConsumptionLimit = temp;
        if(temp < 0)
            dailyConsumptionLimit = 0;
    }
}
