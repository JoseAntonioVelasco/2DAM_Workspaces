package com.progmultimedia.tema9actividad6_guiadascheduledthreadpoolexecutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static Button iniciar;
    private static Button parar;
    private static TextView mensaje;
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar = findViewById(R.id.iniciar);
        parar = findViewById(R.id.parar);
        mensaje = findViewById(R.id.mensaje);

    }
    @Override
    protected void onResume() {
        super.onResume();
        iniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               mensaje.setText("INICIO DE LAS TAREAS");
               ScheduledFuture tarea1 = executor.scheduleAtFixedRate(new Tarea1(MainActivity.this,mensaje), 0, 5, TimeUnit.SECONDS);
               executor.schedule(new Tarea2(MainActivity.this, mensaje), 2,TimeUnit.SECONDS);
               executor.scheduleAtFixedRate(new Tarea3(MainActivity.this,mensaje), 0, 2, TimeUnit.SECONDS);
               executor.scheduleWithFixedDelay(new Tarea4(mensaje), 0 , 2, TimeUnit.SECONDS);
               mensaje.append("\nTAMAÑO DEL POOL = " +String.valueOf(executor.getPoolSize()));
            }
        });
        parar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mensaje.append("\nAPAGANDO EJECUCION DE TAREAS");
                executor.shutdown();
            }
        });
    }

}