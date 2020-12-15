package com.progmultimedia.tema9actividad2_fragmentsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();

        Frag1 frag_1 = new Frag1();
        Frag2 frag_2 = new Frag2();

        FT.add(R.id.contenedor1,frag_1);
        FT.add(R.id.contenedor2,frag_2);

        FT.commit();
    }
}