/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.t5ej4b;

import java.awt.Graphics;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author cagan
 */
public class JPanelImagen extends JPanel implements Serializable{
    
    private File rutaImagen;

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    
    public JPanelImagen() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        if(rutaImagen != null && rutaImagen.exists()){
            ImageIcon miImagen = new ImageIcon(rutaImagen.getAbsolutePath());
            g.drawImage(miImagen.getImage(), 0, 0, null);
        }
       
    }
    
    
    
}
