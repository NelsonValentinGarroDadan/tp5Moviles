package com.example.clase1109;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CambiarAvion extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getBooleanExtra("state", false))
        {
            Toast.makeText(context, "Modo Avion Activado ", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Modo Avion Desactivado ", Toast.LENGTH_LONG).show();
        }

    }
}
