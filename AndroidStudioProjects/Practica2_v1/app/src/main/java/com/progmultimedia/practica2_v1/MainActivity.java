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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reciclador;
    private RecyclerView.Adapter adaptador;
    private RecyclerView.LayoutManager gestor;
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
                startActivity(intent);
            }
        });
        ArrayList<Encapsulador> datos = new ArrayList<>();
        //CARGAR DATOS DESDE PERSISTENCIA
        SharedPreferences prefs = getSharedPreferences("meta", Context.MODE_PRIVATE);
        Integer numNotas = prefs.getInt("numNotas",0);
        for(int i=0; i<numNotas; i++){
            String nota = "nota".concat(String.valueOf(i));
            SharedPreferences notaN = getSharedPreferences(nota,Context.MODE_PRIVATE);
            //sacamos los datos de la nota y los
            String titulo = notaN.getString("titulo","");
            String texto = notaN.getString("texto","");
            datos.add(new Encapsulador(titulo,texto));

        }
        //DATOS DE EJEMPLO
        datos.add(new Encapsulador( "DONUTS", "El 15 de septiembre de 2009, fue lanzado el SDK de Android 1.6 Donut, basado en el núcleo Linux 2.6.29. En la actualización se incluyen numerosas características nuevas."));
        datos.add(new Encapsulador( "FROYO", "El 20 de mayo de 2010, El SDK de Android 2.2 Froyo (Yogur helado) fue lanzado, basado en el núcleo Linux 2.6.32."));

        reciclador = findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);
        adaptador = new Adaptador(datos);
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
                    Toast.makeText(getApplicationContext(),datos.get(position).getTexto(),Toast.LENGTH_SHORT).show();
                    //abrir nota
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
}