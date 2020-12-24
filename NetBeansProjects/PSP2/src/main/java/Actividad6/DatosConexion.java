/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad6;

import java.io.Serializable;
import java.net.InetAddress;

/**
 *
 * @author JoseAntonioVelasco
 */
public class DatosConexion implements Serializable{
    private InetAddress host;
    private Integer numPuerto;

    public DatosConexion(InetAddress host, Integer numPuerto) {
        this.host = host;
        this.numPuerto = numPuerto;
    }

    public InetAddress getHost() {
        return host;
    }

    public void setHost(InetAddress host) {
        this.host = host;
    }

    public Integer getNumPuerto() {
        return numPuerto;
    }

    public void setNumPuerto(Integer numPuerto) {
        this.numPuerto = numPuerto;
    }

    
    
    
}
