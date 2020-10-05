/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.t1_ej6;

/**
 *
 * @author ADMIN
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private String equipo;
    private String fecha_alta;
    private String pais;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String equipo, String fecha_alta, String pais) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
        this.fecha_alta = fecha_alta;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
