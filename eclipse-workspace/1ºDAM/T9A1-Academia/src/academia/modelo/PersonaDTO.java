/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.modelo;

import java.util.ArrayList;

/**
 *
 * @author Raul Rubio
 */
public class PersonaDTO 
{
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String DNI;
    private UsuarioDTO usuario;
    private ArrayList<MatriculaDTO> matriculas;

    public PersonaDTO() {
        this.nombre="";
        this.apellido1="";
        this.apellido2="";
        this.DNI="";
        this.usuario=new UsuarioDTO();
        this.matriculas=new ArrayList<MatriculaDTO>();
    }
    
    public PersonaDTO(String DNI, String nombre, String apellido1, String apellido2) 
    {
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.DNI=DNI;
        this.usuario=new UsuarioDTO();
        this.matriculas=new ArrayList<MatriculaDTO>();
    }
    
    public PersonaDTO(String DNI, String nombre, String apellido1, String apellido2, UsuarioDTO usuario, ArrayList<MatriculaDTO> matriculas)
    {
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.DNI=DNI;
        this.usuario=usuario;
        this.matriculas=matriculas;
    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * @return the usuario
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the matriculas
     */
    public ArrayList<MatriculaDTO> getMatriculas() {
        return matriculas;
    }

    /**
     * @param matriculas the matriculas to set
     */
    public void setMatriculas(ArrayList<MatriculaDTO> matriculas) {
        this.matriculas = matriculas;
    }

    
}
