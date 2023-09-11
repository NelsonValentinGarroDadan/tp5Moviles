package com.example.clase1109;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.nio.file.LinkOption;

public class LlamadaWifi extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getBooleanExtra("connected", false)) {
            intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+"2664553747"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }
}