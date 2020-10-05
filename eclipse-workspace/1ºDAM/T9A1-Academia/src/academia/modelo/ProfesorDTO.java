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
public class ProfesorDTO extends PersonaDTO
{
    private String telefono;
    private String nss;
    private Cuenta cuenta;
    private ArrayList<CursoDTO> cursos;
    private ArrayList<ContratoDTO> contratos;
    
    public ProfesorDTO()
    {
        super();
        
        this.telefono="";
        this.nss="";
        this.cuenta=new Cuenta();
        this.cursos = new ArrayList<CursoDTO>();
        this.contratos = new ArrayList<ContratoDTO>();
    }
    
    public ProfesorDTO(String DNI, String nombre, String apellido1, 
            String apellido2, UsuarioDTO usuario, String telefono,
            String nss, Cuenta cuenta, ArrayList<CursoDTO> cursos,
            ArrayList<ContratoDTO> contratos, ArrayList<MatriculaDTO> matriculas)
    {
        
        super(DNI, nombre, apellido1, apellido2, usuario, matriculas);
        
        this.telefono=telefono;
        this.nss=nss;
        this.cuenta=cuenta;
        this.cursos = cursos;
        this.contratos = contratos;
        
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the nss
     */
    public String getNss() {
        return nss;
    }

    /**
     * @param nss the nss to set
     */
    public void setNss(String nss) {
        this.nss = nss;
    }

    /**
     * @return the cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the cursos
     */
    public ArrayList<CursoDTO> getCursos() {
        return cursos;
    }

    /**
     * @param cursos the cursos to set
     */
    public void setCursos(ArrayList<CursoDTO> cursos) {
        this.cursos = cursos;
    }

    /**
     * @return the contratos
     */
    public ArrayList<ContratoDTO> getContratos() {
        return contratos;
    }

    /**
     * @param contratos the contratos to set
     */
    public void setContratos(ArrayList<ContratoDTO> contratos) {
        this.contratos = contratos;
    }
}
