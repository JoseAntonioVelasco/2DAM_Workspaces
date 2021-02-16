package com.example.practica2_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ViewPager paginador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabLayout tb = findViewById(R.id.tablayout);
        //nombres de las diferentes pestañas
        tb.addTab(tb.newTab().setText("NOTAS"));
        tb.addTab(tb.newTab().setText("TO-DO"));
        //iconos de las pestañas
        tb.getTabAt(0).setIcon(R.drawable.ic_baseline_note_add_24);
        tb.getTabAt(1).setIcon(R.drawable.ic_baseline_assignment_turned_in_24);
        paginador = findViewById(R.id.contenedor2);

        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

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
        //se le asigna el adaptador al tablayout
        AdaptadorTabLayout adaptador = new AdaptadorTabLayout(getSupportFragmentManager(), 0, tb.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tb));
    }

}