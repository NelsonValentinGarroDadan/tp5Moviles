package com.example.clase1109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    private CambiarAvion brcast;
    private LlamadaWifi LlW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);

        }
        registrarBroadcast();
        registrarBroadcastLlW();
    }
    private void registrarBroadcastLlW (){

        this.LlW = new LlamadaWifi();

        registerReceiver(this.LlW,new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));

    }
    public void registrarBroadcast(){
        this.brcast = new CambiarAvion();
        registerReceiver(this.brcast,new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.brcast);
        unregisterReceiver(this.LlW);
    }
}