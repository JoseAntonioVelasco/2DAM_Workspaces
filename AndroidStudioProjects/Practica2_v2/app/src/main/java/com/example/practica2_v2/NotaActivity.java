package com.example.practica2_v2;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.practica2_v2.FragmentoPrincipal.bd;


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
    public void onBackPressed() {
        //guardar nota
        String tit = titulo.getText().toString();
        String cont = contenido.getText().toString();
        if (!notaCargada && ( (!tit.equals("") && cont.equals("")) || (tit.equals("") && !cont.equals("")) || (!tit.equals("") && !cont.equals("")))) {
            //si la nota tiene algo escrito y no habia sido cargada -> se guarda insert
            id = String.valueOf(bd.getNotas().size());
            Encapsulador nota = new Encapsulador(id, tit, cont);
            bd.insertarNota(nota);
        } else if (notaCargada && ((!tit.equals("") && !cont.equals("")) || (tit.equals("") && !cont.equals("")) || (!tit.equals("") && cont.equals("")))) {
            //nota cargada y tiene algo escrito -> se guarda update
            Encapsulador nota = new Encapsulador(id, tit, cont);
            bd.modificarNota(nota);
        } else if (notaCargada && tit.equals("") && cont.equals("")) {
            //nota cargada pero fue vaciada -> se borra delete
            Encapsulador nota = new Encapsulador(id, tit, cont);
            bd.borrarNota(nota);
        } else {
            //nota no fue cargada y se dejo en blanco -> no se guarda
        }
        setResult(RESULT_OK);
        finish();
        super.onBackPressed();
    }


}
