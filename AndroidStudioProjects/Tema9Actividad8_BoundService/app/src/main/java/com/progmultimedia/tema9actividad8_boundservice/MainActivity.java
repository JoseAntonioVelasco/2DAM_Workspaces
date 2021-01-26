package com.progmultimedia.tema9actividad8_boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button iniciar,cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar = findViewById(R.id.iniciar);
        cancelar = findViewById(R.id.cancelar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //iniciar servicio
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //cancelar servicio
            }
        });
    }
}