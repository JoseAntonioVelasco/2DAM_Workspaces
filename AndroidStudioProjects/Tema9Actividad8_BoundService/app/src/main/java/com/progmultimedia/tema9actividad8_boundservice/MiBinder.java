package com.progmultimedia.tema9actividad8_boundservice;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MiBinder extends Binder {

    private final IBinder miBinder = new MiBinder();
    public IBinder onBind(Intent intent){
        return miBinder;
    }
}
