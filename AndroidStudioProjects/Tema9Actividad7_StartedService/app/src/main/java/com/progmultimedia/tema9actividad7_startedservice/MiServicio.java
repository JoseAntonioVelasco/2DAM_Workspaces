package com.progmultimedia.tema9actividad7_startedservice;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class MiServicio extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(),"onBind",Toast.LENGTH_SHORT).show();
        return null;
    }
    @Override
    public void onCreate(){
        Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onUnbind(Intent intent){
        Toast.makeText(getApplicationContext(),"onUnbind",Toast.LENGTH_SHORT).show();
        return false;
    }
    @Override
    public void onDestroy(){
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show();
    }
}
