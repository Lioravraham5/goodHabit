package com.example.protein;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.common.BasePanelActivity;

public class PanelActivity extends BasePanelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManagerProtein();
        super.onCreate(savedInstanceState);

    }
}