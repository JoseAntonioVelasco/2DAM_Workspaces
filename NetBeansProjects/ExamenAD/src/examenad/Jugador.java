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
public class Jugador {

    public Jugador() {
    }

    public Jugador(int idJugador, int idEquipo, String nombre, String apellidos, int edad) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    private int idJugador;
    private int idEquipo;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    private String nombre;
    private String apellidos;
    private int edad;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}