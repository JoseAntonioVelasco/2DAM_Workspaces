/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import academia.modelo.PersonaDTO;
import academia.modelo.accesoADatos.PersonaDAO;

/**
 *
 * @author Raul Rubio
 */
public class Academia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDAO pDAO = new PersonaDAO();
        pDAO.buscarPersona(new PersonaDTO());
        System.out.println("Suceso: "+pDAO.getSuceso());
        for (int i = 0; i < pDAO.getAlumnos().size(); i++) {
            System.out.println(pDAO.getAlumnos().get(i).getDNI());
        }
    }
    
}
