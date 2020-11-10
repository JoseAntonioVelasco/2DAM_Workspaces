package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Bookmarks extends AppCompatActivity {
    private ArrayList<Contacto> contactos;
    private ArrayList<Contacto> bookmarked_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        contactos = getIntent().getParcelableArrayListExtra("CONTACTOS");
        ListView lista = (ListView)findViewById(R.id.lista);


        //get the bookmarked contacts
        bookmarked_contacts = new ArrayList<Contacto>();
        for(int i=0;i<contactos.size();i++){
            if(contactos.get(i).getBookmarked()){
                bookmarked_contacts.add(contactos.get(i));
            }
        }

        final Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );
        lista.setAdapter(new Adaptador(bookmarked_contacts, R.layout.entrada, this) {
            @Override
            public void onEntrada(final Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.nombreContacto);
                TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.descripcion);
                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagen);

                Button bookmark = (Button) view.findViewById(R.id.button);
                Button edit = (Button) view.findViewById(R.id.button2);
                bookmark.setTypeface(font);
                edit.setTypeface(font);

                texto_superior_entrada.setText(((Contacto) entrada).getNombre());
                texto_inferior_entrada.setText(((Contacto) entrada).getDescripcion());
                imagen_entrada.setImageResource(((Contacto) entrada).getImagen());

                bookmark.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //set bookmarked to true
                        Contacto contacto = (Contacto) entrada;
                        int index = bookmarked_contacts.indexOf(contacto);
                        contacto.setBookmarked(false);
                        bookmarked_contacts.set(index,contacto);
                    }
                });
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //start activity and edit contact in that activity
                    }
                });
            }
        });

    }
    protected void onDestroy() {
        super.onDestroy();
        //merge the contacts arraylists (bookmarkeds and contacts)
        ArrayList<Contacto> updated_contacts = new ArrayList<Contacto>();
        for(int i=0; i<contactos.size();i++){
            for(int j=0; j<bookmarked_contacts.size(); j++){
                if(contactos.get(i).getId()==bookmarked_contacts.get(j).getId()){
                    contactos.set(i,bookmarked_contacts.get(j));
                }
            }
        }

        Intent main = new Intent(this, MainActivity.class);
        main.putParcelableArrayListExtra("CONTACTOS", contactos);
        startActivity(main);
    }
}