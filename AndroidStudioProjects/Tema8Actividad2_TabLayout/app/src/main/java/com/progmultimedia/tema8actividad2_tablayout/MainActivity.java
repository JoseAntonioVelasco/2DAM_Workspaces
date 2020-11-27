package com.progmultimedia.tema8actividad2_tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    public static ViewPager paginador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabLayout tb = findViewById(R.id.tablayout);
        tb.addTab(tb.newTab().setText("PRIMERO"));
        tb.addTab(tb.newTab().setText("SEGUNDO"));
        tb.addTab(tb.newTab().setText("TERCERO"));
        tb.getTabAt(0).setIcon(android.R.drawable.ic_media_play);
        tb.getTabAt(1).setIcon(android.R.drawable.ic_media_pause);
        tb.getTabAt(2).setIcon(android.R.drawable.ic_media_previous);
        paginador = findViewById(R.id.contenedor2);
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                paginador.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Adaptador adaptador = new Adaptador(getSupportFragmentManager() ,0,tb.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tb));

    }
}