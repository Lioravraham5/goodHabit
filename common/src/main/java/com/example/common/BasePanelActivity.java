package com.example.common;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.android.material.button.MaterialButton;

public class BasePanelActivity extends AppCompatActivity {


    AppManager appManager;
    protected DataManager dataManagerBase;

    private TextView panel_base_daily_consumption_value;
    private TextView panel_base_daily_consumption_limit;

    private MaterialButton main_BTN_1;
    private MaterialButton main_BTN_2;
    private MaterialButton main_BTN_3;
    private MaterialButton main_BTN_4;
    private MaterialButton main_BTN_reset;
    private MaterialButton main_BTN_edit;

    private CircleProgress circleProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_panel_base);

        appManager = new AppManager(dataManagerBase.getDefaultDailyConsumptionLimit());

        findViews();
        initialUI();

        main_BTN_1.setOnClickListener(view -> button1IsClicked());
        main_BTN_2.setOnClickListener(view -> button2IsClicked());
        main_BTN_3.setOnClickListener(view -> button3IsClicked());
        main_BTN_4.setOnClickListener(view -> button4IsClicked());

    }

    private void button1IsClicked() {
        // update appManger
        appManager.addDailyConsumptionValue(dataManagerBase.buttonsValues.get(0));
        updateUIAfterAdding();
    }

    private void button2IsClicked() {
        // update appManger
        appManager.addDailyConsumptionValue(dataManagerBase.buttonsValues.get(1));
        updateUIAfterAdding();
    }

    private void button3IsClicked() {
        // update appManger
        appManager.addDailyConsumptionValue(dataManagerBase.buttonsValues.get(2));
        updateUIAfterAdding();
    }

    private void button4IsClicked() {
        // update appManger
        appManager.addDailyConsumptionValue(dataManagerBase.buttonsValues.get(3));
        updateUIAfterAdding();
    }

    private void updateUIAfterAdding(){
        // update circle progress
        circleProgress.setProgress(appManager.getDailyConsumptionValue());

        // update textView
        panel_base_daily_consumption_value.setText("" + appManager.getDailyConsumptionValue());
    }

    private void initialUI() {
        //initialize texts
        panel_base_daily_consumption_value.setText("" + appManager.getDailyConsumptionValue());
        panel_base_daily_consumption_limit.setText("" + appManager.getDailyConsumptionLimit());

        //initialize circle progress
        circleProgress.setProgress(appManager.getDailyConsumptionValue());
        circleProgress.setMax(appManager.getDailyConsumptionLimit());
    }

    private void findViews() {
        //texts
        panel_base_daily_consumption_value = findViewById(R.id.panel_base_daily_consumption_value);
        panel_base_daily_consumption_limit = findViewById(R.id.panel_base_daily_consumption_limit);

        //buttons
        main_BTN_1 = findViewById(R.id.main_BTN_1);
        main_BTN_2 = findViewById(R.id.main_BTN_2);
        main_BTN_3 = findViewById(R.id.main_BTN_3);
        main_BTN_4 = findViewById(R.id.main_BTN_4);
        main_BTN_reset = findViewById(R.id.main_BTN_reset);
        main_BTN_edit = findViewById(R.id.main_BTN_edit);

        //circleProgress
        circleProgress = findViewById(R.id.circle_progress);



    }
}