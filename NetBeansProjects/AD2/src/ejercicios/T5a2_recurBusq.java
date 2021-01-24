/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;

/**
 *
 * @author JoseAntonioVelasco
 */
public class T5a2_recurBusq {
    private static Collection obtenColeccion(String nomCol) throws Exception {
        Database dbDriver;
        Collection col;
        dbDriver = (Database) Class.forName("org.exist.xmldb.DatabaseImpl").newInstance();
        DatabaseManager.registerDatabase(dbDriver);
        col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc" + nomCol, "admin", "ROOT");
        return col;
    }
    public static void checkDocs(Collection col,String patron) throws XMLDBException{
        int numDocs = col.getResourceCount();
        if (numDocs > 0) {
            String nomDocs[] = col.listResources();
            for (int i = 0; i < numDocs; i++) {
                if(nomDocs[i].contains(patron)){
                    System.out.println(nomDocs[i]);
                }
            }
        }
    }
    public static void recur(String nomCol,String patron) throws XMLDBException, Exception{
        Collection col = obtenColeccion(nomCol);
        if(col.getChildCollectionCount()>=0){
            checkDocs(col,patron);
            String[] hijos = col.listChildCollections();
            for(String hijo : hijos){
                recur(col.getChildCollection(hijo).getName(),patron);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        recur("/db/apps/shared-resources",".png"); 
    }
}
