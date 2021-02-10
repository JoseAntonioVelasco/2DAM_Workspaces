package com.example.practica2_v2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Encapsulador implements Parcelable {
    private String titulo;
    private String texto;
    private String id;
    private String fech;


    protected Encapsulador(Parcel in) {
        titulo = in.readString();
        texto = in.readString();
        id = in.readString();
        fech = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(texto);
        dest.writeString(id);
        dest.writeString(fech);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getFech() {
        return fech;
    }

    public void setFech(String fech) {
        this.fech = fech;
    }

    public static Creator<Encapsulador> getCREATOR() {
        return CREATOR;
    }

    public Encapsulador(String id, String titulo, String texto,  String fech) {
        this.titulo = titulo;
        this.texto = texto;
        this.id = id;
        this.fech = fech;
    }
}
