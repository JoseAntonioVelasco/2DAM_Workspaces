/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.t5ej4;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import javax.swing.ImageIcon;

import javax.swing.JPanel;


/**
 *
 * @author casa :)
 */
public class JPanelImagen extends JPanel implements Serializable{
    ImagenFondo imagenFondo;

    public JPanelImagen() {
    }

    public ImagenFondo getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(ImagenFondo imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(imagenFondo.getRutaImagen() != null){
            if(imagenFondo.getRutaImagen() != null && imagenFondo.getRutaImagen().exists()){
                 ImageIcon miImagen = new ImageIcon(imagenFondo.getRutaImagen().getAbsolutePath());
                 Graphics2D g2d = (Graphics2D)g;
                 g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,imagenFondo.getOpacidad()));
                 g.drawImage(miImagen.getImage(), 0, 0, null);
                 g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1));
            }
           
        }
    }

    
    
}
