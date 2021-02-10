package com.example.practica2_v2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class AdaptadorLista extends BaseAdapter {
    private ArrayList<?> entradas;
    private int R_layout_idView;
    private Context contexto;

    public AdaptadorLista(ArrayList<?> entradas, int r_layout_idView, Context contexto) {
        super();
        this.entradas = entradas;
        this.R_layout_idView = r_layout_idView;
        this.contexto = contexto;
    }
    @Override
    public View getView(int posicion, View view, ViewGroup parent){
        if(view==null){
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_idView,null);
        }
        onEntrada(entradas.get(posicion),view);
        return view;
    }
    public void updateList(ArrayList<?> nuevas_entradas) {
        entradas.clear();
        entradas = nuevas_entradas;
        this.notifyDataSetChanged();
    }
    public abstract void onEntrada(Object entrada, View view);
    @Override
    public int getCount(){ return entradas.size(); }
    @Override
    public Object getItem(int posicion){return entradas.get(posicion); }
    @Override
    public long getItemId(int posicion){return posicion; }
}