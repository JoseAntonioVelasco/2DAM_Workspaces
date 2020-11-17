package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Bookmarks extends AppCompatActivity {
    private static final int EDITCONTACT_ACTIVITY_REQUEST_CODE = 2;
    private ArrayList<Contacto> contactos;
    private ArrayList<Contacto> bookmarked_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);

        contactos = getIntent().getParcelableArrayListExtra("CONTACTOS");

        //get the bookmarked contacts
        bookmarked_contacts = new ArrayList<Contacto>();
        for(int i=0;i<contactos.size();i++){
            if(contactos.get(i).getBookmarked()){
                bookmarked_contacts.add(contactos.get(i));
            }
        }

        cargarlista();

    }
    public void cargarlista(){
        ListView lista = (ListView)findViewById(R.id.lista);

        final Typeface font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );
        lista.setAdapter(new Adaptador(bookmarked_contacts, R.layout.entrada, this) {
            @Override
            public void onEntrada(final Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.nombreContacto);
                TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.descripcion);
                TextView telefono = (TextView) view.findViewById(R.id.telefono);
                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imagen);

                final ToggleButton bookmark = (ToggleButton) view.findViewById(R.id.toggleButton);
                Contacto contacto = (Contacto) entrada;
                if(contacto.getBookmarked()){
                    bookmark.setChecked(true);
                    bookmark.setTextColor(Color.parseColor("#5B0000"));
                }
                Button edit = (Button) view.findViewById(R.id.button2);
                bookmark.setTypeface(font);
                edit.setTypeface(font);

                texto_superior_entrada.setText(((Contacto) entrada).getNombre());
                texto_inferior_entrada.setText(((Contacto) entrada).getDescripcion());
                telefono.setText(((Contacto) entrada).getTelefono());
                //imagen_entrada.setImageResource(((Contacto) entrada).getImagen());

                bookmark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        //set bookmarked to true
                        Contacto contacto = (Contacto) entrada;
                        int index = bookmarked_contacts.indexOf(contacto);
                        if(isChecked){
                            //set bookmarked to true
                            bookmark.setTextColor(Color.parseColor("#5B0000"));
                            contacto.setBookmarked(true);
                        }else{
                            //set bookmarked to false
                            bookmark.setTextColor(Color.RED);
                            contacto.setBookmarked(false);
                        }
                        bookmarked_contacts.set(index,contacto);
                    }
                });
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //start activity and edit contact in that activity
                        Intent edit = new Intent(Bookmarks.this, AddContact.class);
                        Contacto contacto = (Contacto) entrada;
                        edit.putExtra("CONTACTO",contacto);
                        startActivityForResult(edit,EDITCONTACT_ACTIVITY_REQUEST_CODE);
                    }
                });
            }
        });
    }
    public void onBackPressed(){
        //merge the contacts arraylists (bookmarkeds and contacts)
        for(int i=0; i<contactos.size();i++){
            for(int j=0; j<bookmarked_contacts.size(); j++){
                System.out.println(bookmarked_contacts.get(j).getId());
                if(contactos.get(i).getId()==bookmarked_contacts.get(j).getId()){
                    contactos.set(i,bookmarked_contacts.get(j));
                }
            }
        }

        //source: https://stackoverflow.com/questions/920306/sending-data-back-to-the-main-activity-in-android/947560#:~:text=Put%20the%20data%20that%20you,to%20close%20the%20Second%20Activity.
        //sending data back to MainActivity
        Intent main = new Intent();
        main.putParcelableArrayListExtra("CONTACTOS", contactos);
        setResult(RESULT_OK, main);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == EDITCONTACT_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                // Updated ArrayList from editContact add the modified contact to the list
                Contacto c = data.getParcelableExtra("CONTACTO");
                System.out.println(c.getNombre());
                for(int i=0;i<bookmarked_contacts.size();i++){
                    if(bookmarked_contacts.get(i).getId()==c.getId()){
                        System.out.println("entro");
                        bookmarked_contacts.set(i,c);
                    }
                }
                cargarlista();
            }
        }

    }

}