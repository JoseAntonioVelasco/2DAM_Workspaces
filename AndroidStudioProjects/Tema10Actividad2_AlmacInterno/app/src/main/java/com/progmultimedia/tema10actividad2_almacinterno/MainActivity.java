package com.progmultimedia.tema10actividad2_almacinterno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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

        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    OutputStreamWriter miFichero = new OutputStreamWriter(openFileOutput("fichero.txt", Context.MODE_PRIVATE));
                    miFichero.write((String) texto1.getText());
                    miFichero.close();
                } catch (Exception ex) {
                }
            }
        });
        recuperar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    BufferedReader miFichero = new BufferedReader(new InputStreamReader(openFileInput("fichero.txt")));
                    String texto = miFichero.readLine();
                    texto2.setText(texto);
                    miFichero.close();
                }catch(Exception ex){
                }
            }
        });


    }


}
