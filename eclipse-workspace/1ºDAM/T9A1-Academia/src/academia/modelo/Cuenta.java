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
public class Cuenta 
{
    private String entidad;
    private String oficina;
    private String control;
    private String numero;
    
    public Cuenta()
    {
        this.entidad="";
        this.oficina="";
        this.control="";
        this.numero="";
    }
    
    /**
     * Constructor de la clase Cuenta.
     * Da valor a los atributos de la clase segun los datos recibidos.
     *
     * @param entidad entidad bancaria a la que corresponde el numero de cuenta.
     * @param oficina oficina bancaria a la que corresponde el numero de cuenta.
     * @param control digito de control del numero de cuenta bancaria.
     * @param numero numero de cuenta propiamente dicho.
     */
    public Cuenta(String entidad, String oficina, String control, String numero)
    {
        this.entidad=entidad;
        this.oficina=oficina;
        this.control=control;
        this.numero=numero;
    }

    /**
     * @return the entidad
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the oficina
     */
    public String getOficina() {
        return oficina;
    }

    /**
     * @param oficina the oficina to set
     */
    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    /**
     * @return the control
     */
    public String getControl() {
        return control;
    }

    /**
     * @param control the control to set
     */
    public void setControl(String control) {
        this.control = control;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
