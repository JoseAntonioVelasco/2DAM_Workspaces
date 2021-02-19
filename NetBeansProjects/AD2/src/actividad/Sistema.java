package actividad;

import java.io.Serializable;

public class Sistema implements Serializable {
    private String nombre;
    private String tipo;
    private Double masa;
    private String nombre_galaxia;

    public Sistema(String nombre, String tipo, Double masa, String nombre_galaxia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.masa = masa;
        this.nombre_galaxia = nombre_galaxia;
    }

    public Sistema() {
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

    public String getNombre_galaxia() {
        return nombre_galaxia;
    }

    public void setNombre_galaxia(String nombre_galaxia) {
        this.nombre_galaxia = nombre_galaxia;
    }
    
    
}
