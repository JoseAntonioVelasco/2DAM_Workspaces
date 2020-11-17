package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int BOOKMARKS_ACTIVITY_REQUEST_CODE = 0;
    private static final int ADDCONTACT_ACTIVITY_REQUEST_CODE = 1;
    private static final int EDITCONTACT_ACTIVITY_REQUEST_CODE = 2;
    private ArrayList<Contacto> contactos;
    private Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        font = Typeface.createFromAsset( getAssets(), "fonts/fontawesome-webfont.ttf" );

        //add the font to the buttons
        Button addContact = (Button)findViewById( R.id.button );
        Button call = (Button)findViewById( R.id.button2 );
        Button bookmarks = (Button)findViewById( R.id.button3 );
        Button history =(Button)findViewById( R.id.button4) ;

        addContact.setTypeface(font);
        call.setTypeface(font);
        bookmarks.setTypeface(font);
        history.setTypeface(font);

        //lista
        cargarDatos();
        cargarlista();

        /*listeners for the bottom buttons*/
        bookmarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookmarks = new Intent(MainActivity.this, Bookmarks.class);
                bookmarks.putParcelableArrayListExtra("CONTACTOS", contactos);
                startActivityForResult(bookmarks, BOOKMARKS_ACTIVITY_REQUEST_CODE);
            }
        });

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit = new Intent(MainActivity.this, AddContact.class);
                edit.putParcelableArrayListExtra("CONTACTOS", contactos);
                startActivityForResult(edit, ADDCONTACT_ACTIVITY_REQUEST_CODE);
            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ""));
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO startactivity history of calls
            }
        });


        /*listeners for the bottom buttons*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check that it is the Bookmarks activity with an OK result
        if(requestCode == BOOKMARKS_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Updated ArrayList from Bookmarks
                contactos = data.getParcelableArrayListExtra("CONTACTOS");
                cargarlista();
            }
        }
        else if(requestCode == ADDCONTACT_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                // Updated ArrayList from Addcontact
                Contacto c = data.getParcelableExtra("CONTACTO");
                c.setId(contactos.size()+1);
                contactos.add(c);
                cargarlista();
            }
        }
        else if(requestCode == EDITCONTACT_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                // Updated ArrayList from editContact add the modified contact to the list
                Contacto c = data.getParcelableExtra("CONTACTO");
                System.out.println(c.getNombre());
                for(int i=0;i<contactos.size();i++){
                    if(contactos.get(i).getId()==c.getId()){
                        System.out.println("entro");
                        contactos.set(i,c);
                    }
                }
                cargarlista();
            }
        }

    }
    private void cargarDatos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(1,R.drawable.diegop,"Diego P","El de la 09","567 345 123",false));
        contactos.add(new Contacto(2,R.drawable.misi,"Diego Misi","","123 456 789",true));
    }

    private void cargarlista(){
        ListView lista = (ListView)findViewById(R.id.lista);

        lista.setAdapter(new Adaptador(contactos, R.layout.entrada, this) {
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
                        Contacto contacto = (Contacto) entrada;
                        int index = contactos.indexOf(contacto);
                        if(isChecked){
                            //set bookmarked to true
                            bookmark.setTextColor(Color.parseColor("#5B0000"));
                            contacto.setBookmarked(true);
                        }else{
                            //set bookmarked to false
                            bookmark.setTextColor(Color.RED);
                            contacto.setBookmarked(false);
                        }
                        contactos.set(index,contacto);
                    }
                });
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //start activity and edit contact in that activity
                        Intent edit = new Intent(MainActivity.this, AddContact.class);
                        Contacto contacto = (Contacto) entrada;
                        edit.putExtra("CONTACTO",contacto);
                        startActivityForResult(edit,EDITCONTACT_ACTIVITY_REQUEST_CODE);
                    }
                });

            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //call the contact clicked
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contactos.get(position).getTelefono()));
                startActivity(intent);
            }
        });
    }
}