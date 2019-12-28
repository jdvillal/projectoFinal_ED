/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.fileDescriptor;

import javafx.scene.paint.Color;

/**
 *
 * @author danie
 */
public interface Descriptable {
    
    public long getSize();
    public String getDescription();
    public Color getColor();
}
