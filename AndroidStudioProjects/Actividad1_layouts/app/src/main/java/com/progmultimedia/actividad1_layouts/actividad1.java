package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
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
    private static final int MnOp1 = R.id.MnOp1;
    private static final int MnOp2 = R.id.MnOp2;
    private static final int MnOp3 = R.id.MnOp3;
    private static final int MnOp4 = R.id.MnOp4;
    private static final int MnOp5 = R.id.MnOp5;
    private static final int MnOp6 = R.id.MnOp6;
    private static final int MnOp7 = R.id.MnOp7;
    private static final int MnOp8 = R.id.MnOp8;
    private static final int MnOp9 = R.id.MnOp9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6a7_menu);



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

        /*t6a5 adaptador ejemplo
        Datos[] datos = new Datos[]{
            new Datos("Linea Superior 1", "Linea Inferior 1","ck1"),
            new Datos("Linea Superior 2", "Linea Inferior 2","ck2"),
            new Datos("Linea Superior 3", "Linea Inferior 3","ck3"),
            new Datos("Linea Superior 4", "Linea Inferior 4","ck4")
        };
        ListView listado = (ListView) findViewById(R.id.milista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
        t6a5 adaptador ejemplo*/


    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad2.class);
        startActivity(ejemplo);
    }
    /*t6a7*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        /*Manera 1 desde xml*/
        //getMenuInflater().inflate(R.menu.t6a7_menu, menu);

        /*Manera 2 desde java
        menu.add(Menu.NONE, MnOp1, Menu.NONE, "Lunes");
        menu.add(Menu.NONE, MnOp2, Menu.NONE, "Martes");
        menu.add(Menu.NONE, MnOp3, Menu.NONE, "Miercoles");
        menu.add(Menu.NONE, MnOp4, Menu.NONE, "Jueves");
        menu.add(Menu.NONE, MnOp5, Menu.NONE, "Viernes");
        menu.add(Menu.NONE, MnOp6, Menu.NONE, "Sabado");
        menu.add(Menu.NONE, MnOp7, Menu.NONE, "Domingo");
        */

        //submenus
        SubMenu smenu = menu.addSubMenu(Menu.NONE, MnOp1,Menu.NONE,"DIA");
        smenu.add(Menu.NONE, MnOp1, Menu.NONE, "Lunes");
        smenu.add(Menu.NONE, MnOp2, Menu.NONE, "Martes");
        smenu.add(Menu.NONE, MnOp3, Menu.NONE, "Miercoles");
        smenu.add(Menu.NONE, MnOp4, Menu.NONE, "Jueves");
        smenu.add(Menu.NONE, MnOp5, Menu.NONE, "Viernes");
        smenu.add(Menu.NONE, MnOp6, Menu.NONE, "Sabado");
        smenu.add(Menu.NONE, MnOp7, Menu.NONE, "Domingo");
        SubMenu smenu2 = menu.addSubMenu(Menu.NONE, MnOp1,Menu.NONE,"MES");
        smenu2.add(Menu.NONE, MnOp8, Menu.NONE, "Enero");
        smenu2.add(Menu.NONE, MnOp9, Menu.NONE, "Febrero");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        TextView view = findViewById(R.id.texto);
        //String mensaje= "";
        switch(item.getItemId()){
            case R.id.MnOp1:
                //codigo
                view.setText("LUNES");
                return true;
            case R.id.MnOp2:
                //codigo
                view.setText("MARTES");
                return true;
            case R.id.MnOp3:
                //codigo
                view.setText("MIERCOLES");
                return true;
            case R.id.MnOp4:
                //codigo
                view.setText("JUEVES");
                return true;
            case R.id.MnOp5:
                //codigo
                view.setText("VIERNES");
                return true;
            case R.id.MnOp6:
                //codigo
                view.setText("SABADO");
                return true;
            case R.id.MnOp7:
                //codigo
                view.setText("DOMINGO");
                return true;
            case R.id.MnOp8:
                //codigo
                view.setText("ENERO");
                return true;
            case R.id.MnOp9:
                //codigo
                view.setText("FEBRERO");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /*t6a7*/
}