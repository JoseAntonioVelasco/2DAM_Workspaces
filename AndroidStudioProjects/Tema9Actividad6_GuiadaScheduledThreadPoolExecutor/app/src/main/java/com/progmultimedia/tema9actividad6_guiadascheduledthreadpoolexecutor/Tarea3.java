package com.progmultimedia.tema9actividad6_guiadascheduledthreadpoolexecutor;

import android.widget.TextView;

public class Tarea3 implements Runnable{
    private TextView mensaje;
    private MainActivity actividad;
    public Tarea3(MainActivity actividad,TextView mensaje){
        this.mensaje = mensaje;
        this.actividad = actividad;
    }

    @Override
    public void run() {
        actividad.runOnUiThread(new Runnable(){
           @Override
           public void run(){
               mensaje.append("\nEJECUTANDO TAREA3");
               mensaje.append("\nTAREA EN = "+Thread.currentThread().getName());
           }
        });
    }
}
