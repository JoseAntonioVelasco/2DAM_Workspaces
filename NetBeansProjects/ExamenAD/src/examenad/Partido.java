/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Partido {
    private int idPartido;
    private int idLocal;
    private int idVisitante;
    private int marcadorLocal;
    private int marcadorVisitante;

    public Partido(int idPartido, int idLocal, int idVisitante, int marcadorLocal, int marcadorVisitante) {
        this.idPartido = idPartido;
        this.idLocal = idLocal;
        this.idVisitante = idVisitante;
        this.marcadorLocal = marcadorLocal;
        this.marcadorVisitante = marcadorVisitante;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Partido() {
    }

    public int getMarcadorLocal() {
        return marcadorLocal;
    }

    public void setMarcadorLocal(int marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public int getMarcadorVisitante() {
        return marcadorVisitante;
    }

    public void setMarcadorVisitante(int marcadorVisitante) {
        this.marcadorVisitante = marcadorVisitante;
    }

  
}
