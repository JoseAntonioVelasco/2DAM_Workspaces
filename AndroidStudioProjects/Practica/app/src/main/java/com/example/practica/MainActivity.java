package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //font added
        final Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );

        //add the font to the buttons
        Button addContact = (Button)findViewById( R.id.button );
        Button call = (Button)findViewById( R.id.button2 );
        Button bookmarks = (Button)findViewById( R.id.button3 );
        addContact.setTypeface(font);
        call.setTypeface(font);
        bookmarks.setTypeface(font);


        //list
        ListView lista = (ListView)findViewById(R.id.lista);

        /*Contact list*/
        final ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(1,R.drawable.diegop,"Diego P","El de la 09",false));
        contactos.add(new Contacto(2,R.drawable.misi,"Diego Misi","",false));
        /*Contact list*/

        lista.setAdapter(new Adaptador(contactos, R.layout.entrada, this) {
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
                        int index = contactos.indexOf(contacto);
                        contacto.setBookmarked(true);
                        contactos.set(index,contacto);
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

        bookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookmarks = new Intent(MainActivity.this, Bookmarks.class);
                bookmarks.putParcelableArrayListExtra("CONTACTOS", contactos);
                startActivity(bookmarks);
            }
        });
    }
}