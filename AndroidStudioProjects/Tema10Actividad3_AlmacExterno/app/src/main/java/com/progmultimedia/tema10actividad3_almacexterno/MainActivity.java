package com.progmultimedia.tema10actividad3_almacexterno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private static Button guardar,recuperar;
    private static TextView texto2;
    private static EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guardar = findViewById(R.id.guardar);
        recuperar = findViewById(R.id.recuperar);
        editText = findViewById(R.id.editText);
        texto2 = findViewById(R.id.texto2);

        boolean sdExiste = false;
        boolean sdEscritura = false;
        String sdEstado = Environment.getExternalStorageState();
        if(sdEstado.equals(Environment.MEDIA_MOUNTED)){
            sdExiste=true;
            sdEscritura=true;
        }else if(sdEstado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            sdExiste = true;
            sdEscritura = false;
        }else{
            sdExiste = false;
            sdEscritura = false;
        }


        boolean finalSdExiste = sdExiste;
        boolean finalSdEscritura = sdEscritura;
        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //ESCRIBIR
                if(finalSdExiste && finalSdEscritura){
                    try{
                        //Ruta para directorio raiz
                        //File ruta_sd = Environment.getExternalStorageDirectory();
                        //Ruta para directorios predefinidos
                        File ruta_sd = getExternalFilesDir(null);

                        File mifichero = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                        OutputStreamWriter ficht = new OutputStreamWriter(new FileOutputStream(mifichero));
                        ficht.write(editText.getText().toString());
                        ficht.close();
                    }catch(Exception ex){
                        Log.e("Ficheros","Error al escribir fichero en la SD");
                    }
                }
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //LEER
                if(finalSdExiste) {
                    try {
                        //Ruta para directorio raiz
                        //File ruta_sd = Environment.getExternalStorageDirectory();
                        //Ruta para directorios predefinidos
                        File ruta_sd = getExternalFilesDir(null);

                        File mifichero = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
                        BufferedReader fichsd = new BufferedReader(new InputStreamReader(new FileInputStream(mifichero)));
                        String texto = fichsd.readLine();
                        texto2.setText(texto);
                        fichsd.close();
                    } catch (Exception ex) {
                        Log.e("Ficheros", "Error al leer fichero de la SD");
                    }
                }
            }
        });
    }
}