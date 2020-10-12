package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class actividad3 extends AppCompatActivity {
    private View.OnClickListener corkyListener1 = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            TextView texto =(TextView)findViewById(R.id.textView5);
            texto.setText("BOTON PULSADO");
            texto.setTextColor(Color.RED);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act4_boton);

        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(corkyListener1);
    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad4.class);
        startActivity(ejemplo);
    }
}