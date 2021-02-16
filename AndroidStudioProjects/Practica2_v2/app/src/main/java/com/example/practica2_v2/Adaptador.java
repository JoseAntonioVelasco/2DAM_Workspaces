package com.example.practica2_v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.miHolder>{
    //Adaptador de las notas
    private ArrayList<Encapsulador> entradas;
    public Adaptador(ArrayList<Encapsulador> entradas) {
        this.entradas = entradas;
    }

    public static class miHolder extends RecyclerView.ViewHolder{
        //los atributos de una nota
        public TextView titulo;
        public TextView texto;
        public TextView fecha;
        public miHolder(@NonNull View vista) {
            super(vista);
            titulo = (TextView) vista.findViewById(R.id.titulo);
            texto = (TextView) vista.findViewById(R.id.texto);
            fecha = (TextView) vista.findViewById(R.id.fecha);
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
        holder.fecha.setText(entradas.get(position).getFech());
        String txt=String.valueOf(entradas.get(position).getTexto());
        //Si el contenido de una nota es mayor o igual a 80 caracteres solo se muestran los 77 primeros
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
