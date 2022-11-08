package com.example.projectteam27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
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

    public void toDatabase(View view) {
        Intent db_intent = new Intent(this, DBActivity.class);
        startActivity(db_intent);
    }
}