package com.example.practica2_v2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.practica2_v2.FragmentoPrincipal.bd;


public class NotaActivity extends AppCompatActivity {
    private EditText titulo;
    private EditText contenido;
    private String id;
    private Boolean notaCargada;
    private String fecha;

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
            fecha = nota.getFech();
            notaCargada = true;
        }catch (Exception e){}

        //boton que se encuentra arriba a la derecha para poder borrar nota
        ImageButton bt = findViewById(R.id.button_nota);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(NotaActivity.this, v);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.elim:
                                //eliminar nota
                                String tit = titulo.getText().toString();
                                String cont = contenido.getText().toString();
                                Encapsulador nota = new Encapsulador(id, tit, cont,fecha);
                                bd.borrarNota(nota);
                                Toast.makeText(NotaActivity.this, "Eliminada: " +titulo.getText().toString(), Toast.LENGTH_SHORT).show();
                                setResult(RESULT_OK);
                                finish();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.inflate(R.menu.menu_checkbox);
                popup.show();
            }
        });

    }
    @Override
    public void onBackPressed() {
        //guardar nota
        String tit = titulo.getText().toString();
        String cont = contenido.getText().toString();
        if (!notaCargada && ( (!tit.equals("") && cont.equals("")) || (tit.equals("") && !cont.equals("")) || (!tit.equals("") && !cont.equals("")))) {
            //si la nota tiene algo escrito y no habia sido cargada -> se guarda insert
            id = genId(0);
            Date dat = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fecha_actual = formatter.format(dat);
            Encapsulador nota = new Encapsulador(id, tit, cont,fecha_actual);
            bd.insertarNota(nota);
        } else if (notaCargada && ((!tit.equals("") && !cont.equals("")) || (tit.equals("") && !cont.equals("")) || (!tit.equals("") && cont.equals("")))) {
            //nota cargada y tiene algo escrito -> se guarda update
            Encapsulador nota = new Encapsulador(id, tit, cont,fecha);
            bd.modificarNota(nota);
        } else if (notaCargada && tit.equals("") && cont.equals("")) {
            //nota cargada pero fue vaciada -> se borra delete
            Encapsulador nota = new Encapsulador(id, tit, cont,fecha);
            bd.borrarNota(nota);
        } else {
            //nota no fue cargada y se dejo en blanco -> no se guarda
        }
        setResult(RESULT_OK);
        finish();
        super.onBackPressed();
    }
    //genera un id unico para que la base de datos siga siendo integra
    private String genId(Integer depth){
        ArrayList<Encapsulador> datos = bd.getNotas();
        String id = String.valueOf(datos.size()+depth);
        for(int i=0; i<datos.size(); i++){
            if(datos.get(i).getId().equals(id)){
                id=genId(depth+1);
            }
        }
        return id;
    }

}
