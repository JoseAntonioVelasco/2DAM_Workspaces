package DTO;

import java.io.Serializable;

public class Planeta implements Serializable {
    private String nombre;
    private Double masa;
    private Double volumen;
    private String nombre_sistema;

    public Planeta() {
    }

    public Planeta(String nombre, Double masa, Double volumen, String nombre_sistema) {
        this.nombre = nombre;
        this.masa = masa;
        this.volumen = volumen;
        this.nombre_sistema = nombre_sistema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMasa() {
        return masa;
    }

    public void setMasa(Double masa) {
        this.masa = masa;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getNombre_sistema() {
        return nombre_sistema;
    }

    public void setNombre_sistema(String nombre_sistema) {
        this.nombre_sistema = nombre_sistema;
    }
    
}
