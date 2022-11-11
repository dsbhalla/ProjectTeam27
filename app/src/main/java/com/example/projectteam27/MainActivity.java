package com.example.projectteam27;

import android.content.Intent;
import android.content.IntentFilter;
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
    CustomBroadCastReceiver receiver;
    IntentFilter intentFilter;
    String currentDateTimeString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        var_Time = findViewById(R.id.idTime);
        var_Time.setText(currentDateTimeString);

        receiver = new CustomBroadCastReceiver();
        intentFilter = new IntentFilter("com.example.homework");
        registerReceiver(receiver, intentFilter);

    }

    public void toDatabase(View view) {
        Intent db_intent = new Intent(this, DBActivity.class);
        startActivity(db_intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }

    public void sendCustomBroadCastIntent(View view){
        Intent intent = new Intent("com.example.homework");
        //broadcast_intent.setAction("com.example.homework.CUSTOM_INTENT");
        //broadcast_intent.putExtra("mssg", param = "Custom broadcast message");
        Log.d("MainActivity", " Inside SendCustomBroadCastIntent ");
        intent.putExtra("TEXT", currentDateTimeString);
        sendBroadcast(intent);
    }
}