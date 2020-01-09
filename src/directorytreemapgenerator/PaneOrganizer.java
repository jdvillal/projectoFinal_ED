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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import project.Tree.Tree;
import project.fileDescriptor.Descriptable;
import project.fileDescriptor.FileDescriptor;
import project.linkedList.LinkedList;
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
                Tree<Descriptable> dirTree = createDirectoryTree(fl,0);
                TreeMap tm = new TreeMap(dirTree);
                tm.drawTreemap();
                System.out.println("Total size: " + getDirSize(fl));
                //treeIterator(dirTree, 0);
                //rectangle();
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
    
    public void rectangle(){
        Stage st2 = new Stage();
        Rectangle rc = new Rectangle();
        //rc.setTranslateX(0);rc.setTranslateY(100);
        rc.setWidth(100);
        rc.setHeight(100);
        GridPane sp = new GridPane();
        sp.getChildren().add(rc);
        Scene sc = new Scene(sp,400,400);
        st2.setScene(sc);
        st2.show();
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

    static Tree<Descriptable> createDirectoryTree(File folder, int tabs) {
        Tree<Descriptable> tree = new Tree(new FileDescriptor(folder));
        File[] files = folder.listFiles();
        if (files.length != 0) {
            LinkedList<Tree<Descriptable>> childrenList = new LinkedList();
            String identer = "|";
            for (int i = 0; i < tabs; i++) {
                identer = identer + "|    ";
            }
            for (File fl : files) {
                if (fl.isFile()) {
                    childrenList.add(new Tree(new FileDescriptor(fl)));
                } else {
                    childrenList.add(createDirectoryTree(fl,tabs+1));
                }
            }
            tree.setChildren(childrenList);
        } 
        return tree;
    }

    static void treeIterator(Tree<Descriptable> t, int tabs) {
        String identer = "";
        for (int i = 0; i < tabs; i++) {
            identer = identer + "|    ";
        }
        System.out.println(identer + t.getRoot().getContent().getDescription());
        LinkedList<Tree<Descriptable>> children = t.getChildren();
        for (int i = 0; i < t.countChildren(); i++) {
            treeIterator(children.get(i), tabs + 1);
        }
    }

}
