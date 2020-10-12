package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class actividad4 extends AppCompatActivity {
    private View.OnClickListener corkyListener1 = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            TextView texto =(TextView)findViewById(R.id.textView9);
            texto.setText("BOTON 1 PULSADO");
            texto.setTextColor(Color.RED);
        }
    };
    private View.OnClickListener corkyListener2 = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            TextView texto =(TextView)findViewById(R.id.textView9);
            texto.setText("BOTON 2 PULSADO");
            texto.setTextColor(Color.GREEN);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act4b_boton);

        Button button1 =(Button)findViewById(R.id.button2);
        button1.setOnClickListener(corkyListener1);

        Button button2 =(Button)findViewById(R.id.button3);
        button2.setOnClickListener(corkyListener2);
    }
}