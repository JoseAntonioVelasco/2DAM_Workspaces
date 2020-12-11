package com.progmultimedia.tema8actividad7_recyclerview;

public class Encapsulador {
    private int idimagen;
    private String textoTitulo;
    private String textoContenido;

    public Encapsulador(int idimagen, String textoTitulo, String textoContenido) {
        this.idimagen = idimagen;
        this.textoTitulo = textoTitulo;
        this.textoContenido = textoContenido;
    }

    public int getIdimagen() {
        return idimagen;
    }

    public void setIdimagen(int idimagen) {
        this.idimagen = idimagen;
    }

    public String getTextoTitulo() {
        return textoTitulo;
    }

    public void setTextoTitulo(String textoTitulo) {
        this.textoTitulo = textoTitulo;
    }

    public String getTextoContenido() {
        return textoContenido;
    }

    public void setTextoContenido(String textoContenido) {
        this.textoContenido = textoContenido;
    }
}
