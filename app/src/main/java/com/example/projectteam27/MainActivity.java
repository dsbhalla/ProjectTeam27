package com.example.projectteam27;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView var_Time;
    private Button sendBroadcastButton;
    private String param;
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

    public void sendCustomBroadCastIntent(View view){
        Intent intent = new Intent("com.example.homework");
        //broadcast_intent.setAction("com.example.homework.CUSTOM_INTENT");
        //broadcast_intent.putExtra("mssg", param = "Custom broadcast message");
        Log.d("MainActivity", " Inside SendCustomBroadCastIntent ");
        sendBroadcast(intent);
    }
}