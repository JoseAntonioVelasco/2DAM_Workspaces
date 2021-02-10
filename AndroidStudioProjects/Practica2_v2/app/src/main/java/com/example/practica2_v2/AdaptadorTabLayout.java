package com.example.practica2_v2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdaptadorTabLayout extends FragmentStatePagerAdapter {
    int numTab;
    public AdaptadorTabLayout(@NonNull FragmentManager fm, int behavior, int numTab) {
        super(fm, behavior);
        this.numTab=numTab;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentoPrincipal primero = new FragmentoPrincipal();
                return primero;
            case 1:
                FragmentoCheckBoxes segun = new FragmentoCheckBoxes();
                return segun;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
