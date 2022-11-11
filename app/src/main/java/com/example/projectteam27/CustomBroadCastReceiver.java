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
    public void onReceive(final Context context, final Intent intent) {

        Log.d(TAG, ""+intent.getAction());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(context, "" + intent.getAction() + "\nEmbedded Time: " + intent.getStringExtra("TEXT").trim(), Toast.LENGTH_LONG).show();
        }
    }
}

