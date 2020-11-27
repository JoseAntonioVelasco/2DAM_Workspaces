package com.progmultimedia.tema8actividad2_tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Adaptador extends FragmentStatePagerAdapter {
    int numTab;
    public Adaptador(@NonNull FragmentManager fm, int behavior,int numTab) {
        super(fm, behavior);
        this.numTab=numTab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragmento1 primero = new Fragmento1();
                return primero;
            case 1:
                Fragmento2 segun = new Fragmento2();
                return segun;
            case 2:
                Fragmento3 tercer = new Fragmento3();
                return tercer;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
