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
public class CursoDTO 
{
    private int numero;
    private String titulo;
    private float precio;
    private int horas;
    private ProfesorDTO profesor;
    
    public void CursoDTO()
    {
        this.numero=0;
        this.titulo="";
        this.precio=0;
        this.horas=0;
        this.profesor=new ProfesorDTO();
    }
    public void CursoDTO(int numero, String titulo, float precio, int horas, ProfesorDTO profesor)
    {
        this.numero=numero;
        this.titulo=titulo;
        this.precio=precio;
        this.horas=horas;
        this.profesor=profesor;
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     * @return the profesor
     */
    public ProfesorDTO getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }
}
