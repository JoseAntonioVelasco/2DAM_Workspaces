package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad3.class);
        startActivity(ejemplo);
    }
}