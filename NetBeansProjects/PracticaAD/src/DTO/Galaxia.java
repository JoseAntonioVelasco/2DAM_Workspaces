package DTO;

import java.io.Serializable;

public class Galaxia implements Serializable {
    private String nombre;
    private String tipo;
    private Double masa;
    private String nombre_cumulo;

    public Galaxia() {
    }

    public Galaxia(String nombre, String tipo, Double masa, String nombre_cumulo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.masa = masa;
        this.nombre_cumulo = nombre_cumulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getMasa() {
        return masa;
    }

    public void setMasa(Double masa) {
        this.masa = masa;
    }

    public String getNombre_cumulo() {
        return nombre_cumulo;
    }

    public void setNombre_cumulo(String nombre_cumulo) {
        this.nombre_cumulo = nombre_cumulo;
    }
    
    
}
