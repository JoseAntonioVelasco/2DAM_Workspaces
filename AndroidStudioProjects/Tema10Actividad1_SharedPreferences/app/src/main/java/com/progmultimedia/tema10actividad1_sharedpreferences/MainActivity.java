package com.progmultimedia.tema10actividad1_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Button guardar,recuperar;
    private static TextView texto1,texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guardar = findViewById(R.id.guardar);
        recuperar = findViewById(R.id.recuperar);
        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);

        SharedPreferences prefs = getSharedPreferences("info.txt", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Clave1","Valor1");
        editor.putString("Clave2","Valor2");
        editor.commit();

        String valor1 = prefs.getString("Clave1","valor por defecto 1");
        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //iniciar servicio
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                texto1.setText(valor1);
                texto2.setText(valor1);
            }
        });

    }
}