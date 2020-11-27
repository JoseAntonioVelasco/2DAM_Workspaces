/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author cagan
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args)  {
        File source = new File("USB\\VID_2717&PID_FF48&MI_00\\7&1FE1136D&0&0000");
        File dest = new File("D:\\Fotosmobil xiomi\\copia3\\SD");
        
        try {
            FileUtils.copyDirectory(source,dest);
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    


    
}
