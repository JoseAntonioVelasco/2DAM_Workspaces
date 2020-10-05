package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad2.class);
        startActivity(ejemplo);
    }
}