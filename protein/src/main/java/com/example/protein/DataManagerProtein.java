package com.example.protein;

import com.example.common.DataManager;

import java.util.ArrayList;
import java.util.Arrays;

public class DataManagerProtein extends DataManager {

    public DataManagerProtein(){
        super();
        defaultDailyConsumptionLimit = 60;
        buttonsValues =new ArrayList<>(Arrays.asList(10, 25, 20, 30));
        factorLimit = 5;
    }
}
