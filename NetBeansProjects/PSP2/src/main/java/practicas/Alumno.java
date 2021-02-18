/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

/**
 * Aqui se comenta la clase
 * <h1>Esto es un titulo</h1>
 * @author JoseAntonioVelasco
 * @see practicas.Alumno
 * @version 1-2021 version-año
 * @since 1-1-2021
 */
public class Alumno {
    private String nombre;
    private String apellido;
    private String ciclo;
    private int curso;

    public Alumno(String nombre, String apellido, String ciclo, int curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciclo = ciclo;
        this.curso = curso;
    }
    /**
     * asd
     * @return asd
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre {@link #nombre} 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    /**
     * 
     * @return <ul>
     * <li>True: si que puede ir
     * <li>False: no puede ir
     * </ul>
     */
    public boolean fct(){
        return false;
    }
    /**
     * aksdhkahjsdkajhsk
     * @return el numero
     */
    private Integer pruebaPublica(){
        return 3;
    }
}
