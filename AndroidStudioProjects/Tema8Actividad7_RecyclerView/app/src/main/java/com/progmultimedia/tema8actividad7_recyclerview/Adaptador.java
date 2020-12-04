package com.progmultimedia.tema8actividad7_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.AnimeViewHolder>{
    private List<Encapsulador> item;

    public Adaptador(List<Encapsulador> items) {
        this.item = items;
    }
    public static class AnimeViewHolder extends RecyclerView.ViewHolder{

        public AnimeViewHolder(@NonNull View vista) {
            super(vista);
        }
    }
    @NonNull
    @Override
    public Adaptador.AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.carta,
                viewGroup,false);
        return new AnimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.AnimeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
