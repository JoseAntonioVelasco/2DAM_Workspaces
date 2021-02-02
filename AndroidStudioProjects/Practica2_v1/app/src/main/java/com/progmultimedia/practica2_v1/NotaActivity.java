package com.progmultimedia.practica2_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotaActivity extends AppCompatActivity {
    private TextView titulo;
    private TextView contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nota);
        titulo = findViewById(R.id.titulo);
        contenido = findViewById(R.id.textArea);
    }
}
