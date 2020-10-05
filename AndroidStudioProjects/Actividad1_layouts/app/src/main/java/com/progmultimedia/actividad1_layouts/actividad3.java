package com.progmultimedia.actividad1_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class actividad3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);
    }
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo = new Intent(this, actividad4.class);
        startActivity(ejemplo);
    }
}