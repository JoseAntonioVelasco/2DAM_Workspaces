package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;


public class actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_actividad1);
        //setContentView(R.layout.textview2);
        setContentView(R.layout.textview3);
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

        /*textview3*/
        TextView miTexto = (TextView) findViewById(R.id.textView3);
        miTexto.append("\nTexto añadido con Append desde Java");
        //Typeface miFuente = Typeface.createFromAsset(getAssets(),"fonts/Italic.ttf");
        //miTexto.setTypeface(miFuente);
        miTexto.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        miTexto.setTextColor(Color.BLUE);
        miTexto.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        /*textview3*/

        /*textview4
        TextView miTexto = (TextView) findViewById(R.id.textView4);
        miTexto.setText("Texto escrito fuente umbrella");
        Typeface miFuente = Typeface.createFromAsset(getAssets(),"fonts/Umbrella.ttf");
        miTexto.setTypeface(miFuente);
        //miTexto.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        miTexto.setTextColor(Color.RED);
        miTexto.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        textview4*/

    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad2.class);
        startActivity(ejemplo);
    }
}