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
public class Valoracion {
    private int idJugador;
    private int idEquipo;
    private int idPArtido;
    private int valoracion;

    public Valoracion(int idJugador,int idEquipo, int idPArtido, int valoracion) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.idPArtido = idPArtido;
        this.valoracion = valoracion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Valoracion() {
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdPArtido() {
        return idPArtido;
    }

    public void setIdPArtido(int idPArtido) {
        this.idPArtido = idPArtido;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
    
    
}