package com.example.practica;

import android.os.Parcel;
import android.os.Parcelable;

public class Contacto implements Parcelable {
    private int id;
    private int imagen;
    private String nombre;
    private String descripcion;
    private Boolean bookmarked;

    public Contacto(int id, int imagen, String nombre, String descripcion, Boolean bookmarked) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bookmarked = bookmarked;
    }

    protected Contacto(Parcel in) {
        imagen = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        byte tmpBookmarked = in.readByte();
        bookmarked = tmpBookmarked == 0 ? null : tmpBookmarked == 1;
    }

    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagen);
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeByte((byte) (bookmarked == null ? 0 : bookmarked ? 1 : 2));
    }
}
