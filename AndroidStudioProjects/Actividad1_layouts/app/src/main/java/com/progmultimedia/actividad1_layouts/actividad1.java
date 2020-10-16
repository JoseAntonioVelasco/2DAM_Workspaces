package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act8_radiobutton);
        //setContentView(R.layout.textview2);
        //setContentView(R.layout.textview3);
        //setContentView(R.layout.textview4);


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


        /*radioButton*/
        RadioGroup miGrupo = (RadioGroup)findViewById(R.id.grupo);
        miGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView view = (TextView)findViewById(R.id.textView6);
                RadioButton boton_pulsado = (RadioButton)findViewById(checkedId);
                view.setText("Pulsado: "+boton_pulsado.getText());
            }
        });
        /*radioButton*/
    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad2.class);
        startActivity(ejemplo);
    }
}