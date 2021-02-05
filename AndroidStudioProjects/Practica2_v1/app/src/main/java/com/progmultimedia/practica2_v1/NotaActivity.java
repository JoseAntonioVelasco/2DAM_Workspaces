package com.progmultimedia.practica2_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static com.progmultimedia.practica2_v1.MainActivity.datos;

public class NotaActivity extends AppCompatActivity {
    private EditText titulo;
    private EditText contenido;
    private String id;
    private Boolean notaCargada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nota);
        titulo = findViewById(R.id.texto_titulo);
        contenido = findViewById(R.id.textArea);
        notaCargada = false;
        //cargar nota
        try {
            Encapsulador nota = (Encapsulador) getIntent().getParcelableExtra("nota");
            titulo.setText(nota.getTitulo());
            contenido.setText(nota.getTexto());
            id = nota.getId();
            notaCargada = true;
        }catch (Exception e){}

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //guardar nota
        if(!notaCargada && (!titulo.getText().toString().equals("") || contenido.getText().toString().equals(""))){
            //si la nota tiene algo escrito y no habia sido cargada -> se guarda
            id = String.valueOf(datos.size());
            Encapsulador nota = new Encapsulador(id,titulo.getText().toString(),contenido.getText().toString());

        }else if(notaCargada && (!titulo.getText().toString().equals("") || contenido.getText().toString().equals(""))){
            //la nota fue cargada y tiene algo escrito -> se guarda
            Encapsulador nota = new Encapsulador(id,titulo.getText().toString(),contenido.getText().toString());
        }else if(notaCargada && (!titulo.getText().toString().equals("") || contenido.getText().toString().equals(""))){
            //nota cargada pero fue vaciada -> se borra

        }else{
            //nota no fue cargada y se dejo en blanco -> no se guarda
        }

    }


}
