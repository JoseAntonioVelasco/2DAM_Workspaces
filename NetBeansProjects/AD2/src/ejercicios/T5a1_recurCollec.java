/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Service;
import org.xmldb.api.base.XMLDBException;


/**
 *
 * @author JoseAntonioVelasco
 */
public class T5a1_recurCollec {
   private static Collection obtenColeccion(String nomCol) throws Exception {
        Database dbDriver;
        Collection col;
        dbDriver = (Database) Class.forName("org.exist.xmldb.DatabaseImpl").newInstance();
        DatabaseManager.registerDatabase(dbDriver);
        col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db" + nomCol, "admin", "ROOT");
        
        int numHijas = col.getChildCollectionCount();
        
        if (numHijas > 0) {
                String nomHijas[] = col.listChildCollections();
                for (int i = 0; i < numHijas; i++) {
                    col = obtenColeccion(col.getName()+"/"+nomHijas[i]);
                }
        }
  
        return col;
    }

    public static void main(String[] args) {
        Collection col = null;
        try {
            col = obtenColeccion("/apps/shared-resources");
            System.out.println("Colección actual: " + col.getName());

            int numHijas = col.getChildCollectionCount();
            System.out.println(numHijas + " colecciones hijas.");
            if (numHijas > 0) {
                String nomHijas[] = col.listChildCollections();
                for (int i = 0; i < numHijas; i++) {
                    System.out.println("\t" + nomHijas[i]);
                }
            }
            int numDocs = col.getResourceCount();
            System.out.println(numDocs + " doocumentos.");
            if (numDocs > 0) {
                String nomDocs[] = col.listResources();
                for (int i = 0; i < numDocs; i++) {
                    System.out.println("\t" + nomDocs[i]);
                }
            }

            Service servicios[] = col.getServices();
            System.out.println("Servicios proporcionados por colección " + col.getName() + ":");
            for (int i = 0; i < servicios.length; i++) {
                System.out.println("\t" + servicios[i].getName() + " - Versión: " + servicios[i].getVersion());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (col != null) {
                    col.close();
                }
            } catch (XMLDBException e) {
                e.printStackTrace();
            }
        }
    }
}
