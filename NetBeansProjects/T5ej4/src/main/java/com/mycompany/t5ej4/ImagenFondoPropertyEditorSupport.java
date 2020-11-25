/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.t5ej4;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author cagan
 */
public class ImagenFondoPropertyEditorSupport extends PropertyEditorSupport{
    private ImagenFondoPanel imagenFondoPanel = new ImagenFondoPanel();
    
    @Override
    public boolean supportsCustomEditor() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component getCustomEditor() {
        return imagenFondoPanel; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJavaInitializationString() {
        return super.getJavaInitializationString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValue() {
        return imagenFondoPanel.getSelectedValue(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
