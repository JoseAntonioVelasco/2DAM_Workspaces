package com.progmultimedia.practica2_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reciclador;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;

    public static ArrayList<Encapsulador> datos = new ArrayList<>();
    public static BaseDatos bd = new BaseDatos();

    private static Integer RECARGAR_NOTAS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CREAR NOTA
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotaActivity.class);
                startActivityForResult(intent,RECARGAR_NOTAS);
                //despues de salir de aqui tiene que volver a recargar las notas y tal
            }
        });
        //source: https://stackoverflow.com/questions/8063439/android-edittext-finished-typing-event
        EditText buscador = findViewById(R.id.buscador);
        buscador.setOnEditorActionListener(
            new EditText.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                            actionId == EditorInfo.IME_ACTION_DONE ||
                            event != null &&
                                    event.getAction() == KeyEvent.ACTION_DOWN &&
                                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                        if (event == null || !event.isShiftPressed()) {
                            // the user is done typing. -> realizar busqueda de notas y mostrarlas
                            String buscar = buscador.getText().toString();
                            if(!buscar.equals("")) {
                                recargarNotas(bd.getNotas(buscador.getText().toString()));
                            }else{
                                recargarNotas(bd.getNotas());
                            }

                            return true; // consume.
                        }
                    }
                    return false; // pass on to other listeners.
                }
            }
        );
        //CARGAR DATOS DESDE PERSISTENCIA
        bd.crearBaseDatos(this,"Nota");
        try {
            //DATOS DE EJEMPLO
            bd.insertarNota(new Encapsulador("0", "DONUTS", "El 15 de septiembre de 2009, fue lanzado el SDK de Android 1.6 Donut, basado en el núcleo Linux 2.6.29. En la actualización se incluyen numerosas características nuevas."));
            bd.insertarNota(new Encapsulador("1", "FROYO", "El 20 de mayo de 2010, El SDK de Android 2.2 Froyo (Yogur helado) fue lanzado, basado en el núcleo Linux 2.6.32."));
        }catch(Exception e){}

        datos = bd.getNotas();
        reciclador = findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);
        adaptador = new Adaptador(bd.getNotas());
        gestor = new GridLayoutManager(this, 2);
        reciclador.setLayoutManager(gestor);
        reciclador.setAdapter(adaptador);

        reciclador.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                View hijo = rv.findChildViewUnder(e.getX(),e.getY());
                if(hijo != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(hijo);
                    //abrir nota
                    Encapsulador nota = new Encapsulador(datos.get(position).getId(),datos.get(position).getTitulo(),datos.get(position).getTexto());
                    Intent intent = new Intent(MainActivity.this, NotaActivity.class);
                    intent.putExtra("nota",nota);
                    startActivityForResult(intent,RECARGAR_NOTAS);
                }
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //recargar notas
        if(requestCode == RECARGAR_NOTAS && resultCode == RESULT_OK) {
            recargarNotas(bd.getNotas());
        }
    }
    public void recargarNotas(ArrayList<Encapsulador> notas){
        adaptador = new Adaptador(notas);
        reciclador.setAdapter(adaptador);
        datos = notas;
    }

}