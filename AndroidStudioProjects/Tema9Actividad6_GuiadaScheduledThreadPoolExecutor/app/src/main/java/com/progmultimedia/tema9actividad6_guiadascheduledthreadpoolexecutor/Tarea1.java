package com.progmultimedia.tema9actividad6_guiadascheduledthreadpoolexecutor;


import android.content.Context;
import android.widget.TextView;

import java.util.TimerTask;

public class Tarea1 extends TimerTask {
    private TextView mensaje;
    private MainActivity actividad;
    public Tarea1(MainActivity actividad,TextView mensaje){
        this.mensaje = mensaje;
        this.actividad = actividad;
    }
    @Override
    public void run() {
        actividad.runOnUiThread(new Runnable(){
            @Override
            public void run(){
                mensaje.append("\nEJECUTANDO LA TAREA 1");
                mensaje.append("\nTAREA EN = "+Thread.currentThread().getName());
            }
        });
    }
}
