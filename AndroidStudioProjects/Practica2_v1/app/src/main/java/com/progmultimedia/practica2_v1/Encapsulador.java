package com.progmultimedia.practica2_v1;

import android.os.Parcel;
import android.os.Parcelable;

public class Encapsulador implements Parcelable {
    private String titulo;
    private String texto;
    private String id;

    public Encapsulador(String id,String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    protected Encapsulador(Parcel in) {
        titulo = in.readString();
        texto = in.readString();
        id = in.readString();
    }

    public static final Creator<Encapsulador> CREATOR = new Creator<Encapsulador>() {
        @Override
        public Encapsulador createFromParcel(Parcel in) {
            return new Encapsulador(in);
        }

        @Override
        public Encapsulador[] newArray(int size) {
            return new Encapsulador[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(texto);
        dest.writeString(id);
    }
}
