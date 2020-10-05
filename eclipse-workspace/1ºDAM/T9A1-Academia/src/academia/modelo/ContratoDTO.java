/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.modelo;

/**
 *
 * @author Raul Rubio
 */
public class ContratoDTO 
{
    private int numero;
    private String finicio;
    private String ffin;
    private String tipo;
    private String descripcion;
    
    public ContratoDTO()
    {   
        this.numero = 0;
        this.finicio="";
        this.ffin="";
        this.tipo="";
        this.descripcion="";
    }
    
    public ContratoDTO(int numero, String finicio, String ffin, String tipo, String descripcion)
    {   
        this.numero = numero;
        this.finicio=finicio;
        this.ffin=ffin;
        this.tipo=tipo;
        this.descripcion=descripcion;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the finicio
     */
    public String getFinicio() {
        return finicio;
    }

    /**
     * @param finicio the finicio to set
     */
    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }

    /**
     * @return the ffin
     */
    public String getFfin() {
        return ffin;
    }

    /**
     * @param ffin the ffin to set
     */
    public void setFfin(String ffin) {
        this.ffin = ffin;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
