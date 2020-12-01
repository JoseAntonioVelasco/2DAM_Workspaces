package com.progmultimedia.tema8actividad4_floatactionbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        Animation abrir = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.abrir);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.startAnimation(abrir);
                Snackbar bar = Snackbar.make(findViewById(R.id.floatingActionButton),"TEXTO", Snackbar.LENGTH_SHORT);
                bar.show();
            }
        });

    }
}