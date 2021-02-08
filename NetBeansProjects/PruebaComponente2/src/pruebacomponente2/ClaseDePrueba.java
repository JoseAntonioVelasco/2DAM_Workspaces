package pruebacomponente2;

import java.io.*;
import beans.*;
/**
 *
 * @author JoseAntonioVelasco
 */
public class ClaseDePrueba implements Serializable{
    public static void main(String args[]) {
        Producto p = new Producto("tornillo",1,10,3,14.3F);
        
        AccesoBaseDatos abd = new AccesoBaseDatos();
        abd.insertaProducto(p);
    }
}
