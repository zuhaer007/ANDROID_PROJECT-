package com.example.innvision;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class StatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);

        // Change the status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));
    }
}
