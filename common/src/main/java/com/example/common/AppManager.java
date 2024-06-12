package com.example.common;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

public class AppManager {

    private static final String PREFS_NAME = "AppManagerPrefs";
    private static final String KEY_DAILY_CONSUMPTION_LIMIT = "dailyConsumptionLimit";
    private static final String KEY_DAILY_CONSUMPTION_VALUE = "dailyConsumptionValue";

    private int dailyConsumptionLimit;
    private int dailyConsumptionValue;
    private SharedPreferences sharedPreferences;

    public AppManager(){

    }

    public AppManager(Context context, int dailyConsumptionLimit){
        //read data from share preferences
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.dailyConsumptionValue = sharedPreferences.getInt(KEY_DAILY_CONSUMPTION_VALUE, 0);
        this.dailyConsumptionLimit = sharedPreferences.getInt(KEY_DAILY_CONSUMPTION_LIMIT, dailyConsumptionLimit);
    }

    public int getDailyConsumptionLimit() {
        return dailyConsumptionLimit;
    }

    public int getDailyConsumptionValue() {
        return dailyConsumptionValue;
    }

    public AppManager setDailyConsumptionLimit(int dailyConsumptionLimit) {
        this.dailyConsumptionLimit = dailyConsumptionLimit;
        saveData();
        return this;
    }

    public AppManager setDailyConsumptionValue(int dailyConsumptionValue) {
        this.dailyConsumptionValue = dailyConsumptionValue;
        saveData();
        return this;

    }

    public void addDailyConsumptionValue(int value){
        dailyConsumptionValue += value;
        if(dailyConsumptionValue > dailyConsumptionLimit)
            dailyConsumptionValue = dailyConsumptionLimit;
        saveData();
    }

    public void resetDailyConsumptionValue(){
        dailyConsumptionValue = 0;
        saveData();
    }

    public void addLimit(int factorLimit){
        dailyConsumptionLimit += factorLimit;
        saveData();
    }

    public void reduceLimit(int factorLimit){
        int temp = dailyConsumptionLimit - factorLimit;
        if(temp >= dailyConsumptionValue)
            dailyConsumptionLimit = temp;
        if(temp < 0)
            dailyConsumptionLimit = 0;
        saveData();
    }

    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_DAILY_CONSUMPTION_VALUE, dailyConsumptionValue);
        editor.putInt(KEY_DAILY_CONSUMPTION_LIMIT, dailyConsumptionLimit);
        editor.apply();
    }
}
