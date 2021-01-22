package com.progmultimedia.tema9actividad6_guiadascheduledthreadpoolexecutor;

import android.os.Process;
import android.widget.TextView;

public class Tarea4 implements Runnable{
    private TextView mensaje;

    public Tarea4(TextView mensaje){
        this.mensaje=mensaje;
    }

    @Override
    public void run() {
        android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        final String tarea = Thread.currentThread().getName();
        mensaje.post(new Runnable(){

            @Override
            public void run() {
                mensaje.append("\nEJECUTANDO TAREA 4");
                mensaje.append("\nTAREA EN = "+tarea);
            }
        });
    }
}
