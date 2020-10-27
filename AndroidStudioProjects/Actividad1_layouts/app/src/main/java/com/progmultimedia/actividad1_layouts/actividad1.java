package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import t6a5_adaptador.Adaptador;
import t6a5_adaptador.Datos;


public class actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6a1_listview);


        /*textview2
        TextView miTexto = (TextView) findViewById(R.id.textView2);
        miTexto.setText("Texto construido desde Java \n Tamaño 20dp, Italic y color Blue");
        //Typeface miFuente = Typeface.createFromAsset(getAssets(),"fonts/Italic.ttf");
        //miTexto.setTypeface(miFuente);
        miTexto.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        miTexto.setTextColor(Color.BLUE);
        miTexto.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        textview2*/

        /*textview3
        TextView miTexto = (TextView) findViewById(R.id.textView3);
        miTexto.append("\nTexto añadido con Append desde Java");
        miTexto.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        miTexto.setTextColor(Color.BLUE);
        miTexto.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        textview3*/

        /*textview4
        TextView miTexto = (TextView) findViewById(R.id.textView4);
        miTexto.setText("Texto escrito fuente umbrella");
        Typeface miFuente = Typeface.createFromFile("C:\\Users\\USER\\Documents\\GitWorkspaces\\2DAM_Workspaces\\AndroidStudioProjects\\Actividad1_layouts\\app\\src\\fonts\\Umbrella.ttf");
        miTexto.setTypeface(miFuente);
        //miTexto.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        miTexto.setTextColor(Color.RED);
        miTexto.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        textview4*/


        /*radioButton
        RadioGroup miGrupo = (RadioGroup)findViewById(R.id.grupo);
        miGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView view = (TextView)findViewById(R.id.textView6);
                RadioButton boton_pulsado = (RadioButton)findViewById(checkedId);
                view.setText("Pulsado: "+boton_pulsado.getText());
            }
        });
        radioButton*/


        /*ListView t6a2
        ListView listado = (ListView) findViewById(R.id.milista);
        final String[] datos = new String[]{"Francia","Portugal","Alemania","Italia","Grecia","Holanda","Suecia","Noruega","Polonia","Austria"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) parent.getItemAtPosition(position);
                TextView texto = (TextView) findViewById(R.id.textView7);
                texto.setText(elemento);
            }
        });
        ListView t6a2*/


        /*GridView t6a3
        GridView grid = (GridView) findViewById(R.id.migrid);
        final String[] datos = new String[]{"Francia","Portugal","Alemania","Italia","Grecia","Holanda","Suecia","Noruega","Polonia","Austria"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) parent.getItemAtPosition(position);
                TextView texto = (TextView) findViewById(R.id.textView7);
                texto.setText(elemento);
            }
        });
        GridView t6a3*/

        /*SpinnerView t6a4
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        final String[] datos = new String[]{"Francia","Portugal","Alemania","Italia","Grecia","Holanda","Suecia","Noruega","Polonia","Austria"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos);
        spin.setAdapter(adaptador);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elemento = (String) parent.getItemAtPosition(position);
                TextView texto = (TextView) findViewById(R.id.textView7);
                texto.setText(elemento);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SpinnerView t6a4*/

        /*t6a5 adaptador ejemplo*/
        Datos[] datos = new Datos[]{
            new Datos("Linea Superior 1", "Linea Inferior 1","ck1"),
            new Datos("Linea Superior 2", "Linea Inferior 2","ck2"),
            new Datos("Linea Superior 3", "Linea Inferior 3","ck3"),
            new Datos("Linea Superior 4", "Linea Inferior 4","ck4")
        };
        ListView listado = (ListView) findViewById(R.id.milista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
        /*t6a5 adaptador ejemplo*/
    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad2.class);
        startActivity(ejemplo);
    }
}