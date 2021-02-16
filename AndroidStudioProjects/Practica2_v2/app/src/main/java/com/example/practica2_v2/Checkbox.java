package com.example.practica2_v2;

public class Checkbox {
    //Pojo de la TO-DO list
    private String id;
    private String contenido;
    private Boolean terminado;

    public Checkbox(String id, String contenido, Boolean terminado) {
        this.id = id;
        this.contenido = contenido;
        this.terminado = terminado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
    }
}
