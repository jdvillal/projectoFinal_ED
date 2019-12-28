/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorytreemapgenerator;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class PaneOrganizer {

    private Stage primaryStage;

    public PaneOrganizer(Stage stage) {
        this.primaryStage = stage;
    }

    public void drawStartPane() {
        Label titleLbl = new Label("Seleccione un directorio para comenzar");
        titleLbl.setFont(new Font("Tahoma", 22));
        Label dirLbl = new Label("No se ha seleccionado un directorio");
        Button selectDirBtn = new Button();
        selectDirBtn.setText("Seleccionar directorio");
        Button genTreeBtn = new Button();
        genTreeBtn.setText("Generar Treemap");
        genTreeBtn.setDisable(true);
        selectDirBtn.setOnAction((ActionEvent event) -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory = directoryChooser.showDialog(primaryStage);
            if (selectedDirectory == null) {
                System.out.println("No Directory selected");
            } else {
                genTreeBtn.setDisable(false);
                dirLbl.setText(selectedDirectory.getAbsolutePath());
            }
        });
        genTreeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File fl = new File(dirLbl.getText());
                File arr[] = fl.listFiles();
                for (File s : arr) {
                    if(s.isFile()){
                        System.out.println("FILE: "+s.getName()+" size: "+ s.length());
                   }else{
                       System.out.println("NOT FILE: " + s.getName() + " size: "+s.length());
                   }
                }
                System.out.println("Total size: " + getDirSize(fl));
            }
        });
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(titleLbl, dirLbl, selectDirBtn, genTreeBtn);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Directory Treemap Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static long getDirSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        for (File fl : files) {
            if (fl.isFile()) {
                length = length + fl.length();
            } else {
                length = length + getDirSize(fl);
            }
        }
        return length;
    }

}
