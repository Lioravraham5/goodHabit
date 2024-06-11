package com.example.common;

import java.util.ArrayList;

public abstract class DataManager {

    protected int defaultDailyConsumptionLimit;
    protected ArrayList<Integer> buttonsValues;

    public int getDefaultDailyConsumptionLimit() {
        return defaultDailyConsumptionLimit;
    }

    public DataManager setDefaultDailyConsumptionLimit(int defaultDailyConsumptionLimit) {
        this.defaultDailyConsumptionLimit = defaultDailyConsumptionLimit;
        return this;
    }

    public ArrayList<Integer> getButtonsValues() {
        return buttonsValues;
    }

    public DataManager setButtonsValues(ArrayList<Integer> buttonsValues) {
        this.buttonsValues = buttonsValues;
        return this;
    }
}
