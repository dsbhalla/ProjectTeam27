package com.example.projectteam27;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.time.LocalDateTime;

public class CustomBroadCastReceiver extends BroadcastReceiver {
    private String TAG = "Receiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: inside");

        new Handler(Looper.getMainLooper()).post(() -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Toast.makeText(context, "" + intent.getAction() + "Current time is " + LocalDateTime.now().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
