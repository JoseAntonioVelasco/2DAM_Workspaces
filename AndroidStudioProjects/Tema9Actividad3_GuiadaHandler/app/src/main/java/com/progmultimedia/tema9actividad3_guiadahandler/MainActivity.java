package com.progmultimedia.tema9actividad3_guiadahandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tiempo;
    Button inicio, parada, reset;
    long TiempoMilisegundos, tiempoInicial, TiempoPasado, TiempoActual = 0L;
    Handler miHandler;
    int segundos, minutos, milisegundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiempo = (TextView) findViewById(R.id.tiempo);
        inicio = (Button) findViewById(R.id.boton1);
        parada = (Button) findViewById(R.id.boton2);
        reset = (Button) findViewById(R.id.boton3);
        miHandler = new Handler();

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiempoInicial = SystemClock.uptimeMillis();
                miHandler.postDelayed(runnable,0);
                reset.setEnabled(false);
            }
        });

        parada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TiempoPasado += TiempoMilisegundos;
                miHandler.removeCallbacks(runnable);
                reset.setEnabled(true);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TiempoMilisegundos = 0L;
                tiempoInicial = 0L;
                TiempoPasado = 0L;
                TiempoActual = 0L;
                segundos = 0;
                minutos = 0;
                milisegundos = 0;
                tiempo.setText("00:00:00");
            }
        });
    }

    public Runnable runnable = new Runnable(){
        public void run(){
            TiempoMilisegundos = SystemClock.uptimeMillis() - tiempoInicial;
            TiempoActual = TiempoPasado + TiempoMilisegundos;
            segundos = (int) (TiempoActual/1000);
            minutos = segundos / 60;
            segundos = segundos % 60;
            milisegundos = (int)(TiempoActual%1000);
            tiempo.setText(""+String.format("%02d",minutos)
                    +":"
                    +String.format("%02d",segundos) + ":"
                    +String.format("%02d",milisegundos/10));
            miHandler.postDelayed(this,0);
        }
    };
}