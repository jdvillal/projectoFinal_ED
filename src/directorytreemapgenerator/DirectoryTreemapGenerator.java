/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorytreemapgenerator;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class DirectoryTreemapGenerator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        PaneOrganizer pn = new PaneOrganizer(primaryStage);
        pn.drawStartPane();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
