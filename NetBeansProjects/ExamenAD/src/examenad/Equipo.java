/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenad;


/**
 *
 * @author miguelrojorevenga
 */
public class Equipo {
    private int idEquipo;
    private String nombreEquipo;
    private String abreviatura;
    private String ciudad;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Equipo(int idEquipo, String nombreEquipo, String abreviatura, String ciudad) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.abreviatura = abreviatura;
        this.ciudad = ciudad;
    }

    public Equipo() {
    }
    
    
}