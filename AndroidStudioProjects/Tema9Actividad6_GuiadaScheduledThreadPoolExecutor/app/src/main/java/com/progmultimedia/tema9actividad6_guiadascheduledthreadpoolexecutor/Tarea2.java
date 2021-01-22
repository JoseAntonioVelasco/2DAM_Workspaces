package com.progmultimedia.tema9actividad6_guiadascheduledthreadpoolexecutor;

import android.os.Process;
import android.widget.TextView;

import java.util.TimerTask;

public class Tarea2 extends TimerTask {
    private TextView mensaje;
    private MainActivity actividad;
    public Tarea2(MainActivity actividad,TextView mensaje){
        this.mensaje = mensaje;
        this.actividad = actividad;
    }
    @Override
    public void run() {
        actividad.runOnUiThread(new Runnable(){
            @Override
            public void run() {
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                final String tarea = Thread.currentThread().getName();
                mensaje.post(new Runnable(){
                    public void run(){
                        mensaje.append("\nEJECUTANDO TAREA 2");
                        mensaje.append("\nTAREA EN = "+tarea);
                    }
                });
             }
        });
    }
}
