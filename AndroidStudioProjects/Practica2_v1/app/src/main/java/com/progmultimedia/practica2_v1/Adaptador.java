package com.progmultimedia.practica2_v1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.miHolder>{
    private ArrayList<Encapsulador> entradas;
    //20*4=80
    public Adaptador(ArrayList<Encapsulador> entradas) {
        this.entradas = entradas;
    }

    public static class miHolder extends RecyclerView.ViewHolder{
        public TextView titulo;
        public TextView texto;

        public miHolder(@NonNull View vista) {
            super(vista);
            titulo = (TextView) vista.findViewById(R.id.titulo);
            texto = (TextView) vista.findViewById(R.id.texto);
        }
    }

    @NonNull
    @Override
    public miHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int R_layout_IdView) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.carta,viewGroup,false);
        return new miHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull miHolder holder, final int position) {
        holder.titulo.setText(entradas.get(position).getTitulo());
        String txt=String.valueOf(entradas.get(position).getTexto());
        if(txt.length()<=80) {
            holder.texto.setText(txt);
        }else{
            holder.texto.setText(((String)txt.subSequence(0,77)).concat("..."));
        }
    }

    @Override
    public int getItemCount() {
        return entradas.size();
    }


}
