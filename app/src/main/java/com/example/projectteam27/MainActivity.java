package com.example.projectteam27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView var_Time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        var_Time = findViewById(R.id.idTime);
        var_Time.setText(currentDateTimeString);
    }
}