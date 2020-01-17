/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorytreemapgenerator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author danie
 */
public class RectangleAnimator extends Thread{
    private final Rectangle rectangle;
    
    public RectangleAnimator(Rectangle rc){
        this.rectangle = rc;
    }
    
    
    @Override
    public void run(){
        System.out.println("running");
        boolean state = false;
        this.rectangle.setVisible(state);
        for(int i = 0; i < 10 ; i++){
            if(state){
                state = false;
                this.rectangle.setVisible(state);
            }else{
                state = true;
                this.rectangle.setVisible(state);
            }
            try {
                RectangleAnimator.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(RectangleAnimator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        state = false;
        this.rectangle.setVisible(state);
    }
    
}
