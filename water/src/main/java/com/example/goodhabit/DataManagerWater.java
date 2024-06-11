package com.example.goodhabit;

import com.example.common.DataManager;

import java.util.ArrayList;
import java.util.Arrays;

public class DataManagerWater extends DataManager {

    public DataManagerWater(){
        super();
        defaultDailyConsumptionLimit = 3000;
        buttonsValues =new ArrayList<>(Arrays.asList(250, 500, 330, 1000));
    }


}
