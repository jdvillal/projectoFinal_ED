package directorytreemapgenerator;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import project.Tree.Tree;
import project.fileDescriptor.Descriptable;
import project.linkedList.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */

public class TreeMap {
    private final Tree<Descriptable> directoryTree;
    private LinkedList<Rectangle> rectangles;
    
    public TreeMap(Tree<Descriptable> directoryTree){
        this.directoryTree = directoryTree;
        this.rectangles =  new LinkedList<>();
    }
    
    public void drawTreemap(){
        Stage st2 = new Stage();
        Rectangle rc = new Rectangle();
        rc.setManaged(false);
        rc.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");
        rc.setWidth(1600);
        rc.setHeight(800);
        rc.setTranslateX(0);
        rc.setTranslateY(0);
        getTreemapRectangles(this.directoryTree,rc,this.directoryTree.getRoot().getContent().getSize(),0,0d);
        GridPane sp = new GridPane();
        for(int i = 0; i < this.rectangles.getSize();i++){
            sp.add(this.rectangles.get(i),0,0);
        }
        Scene sc = new Scene(sp,1601,801);
        st2.setScene(sc);
        st2.show();
        
    }
    
    private Double getTreemapRectangles(Tree<Descriptable> tree, Rectangle parentRectangle, double parentSize, int level, Double desplazamiento){
        double d;
        Rectangle rectangle = new Rectangle();
        rectangle.setManaged(false);
        double part = tree.getRoot().getContent().getSize()/parentSize;
        double xLen = parentRectangle.getWidth();
        double yLen = parentRectangle.getHeight();
        double xPos = parentRectangle.getTranslateX();
        double yPos = parentRectangle.getTranslateY();
        if(level%2==1){
            //Dividir el rectangulo original en bloques horizontales(x)
            rectangle.setTranslateX(xPos+desplazamiento);
            rectangle.setTranslateY(yPos);
            rectangle.setWidth(part*xLen);
            rectangle.setHeight(yLen);
            desplazamiento = desplazamiento + rectangle.getWidth();
        }else if(level%2==0){
            //Dividir el rectangulo orignial en bloques verticales(y)
            rectangle.setTranslateX(xPos);
            rectangle.setTranslateY(yPos+desplazamiento);
            rectangle.setWidth(xLen);
            rectangle.setHeight(part*yLen);
            desplazamiento = desplazamiento + rectangle.getHeight();
        }
        
        if(tree.isLeaf()){
            
            rectangle.setStyle(tree.getRoot().getContent().getStyle());
            rectangles.add(rectangle);
        }else{
            LinkedList<Tree<Descriptable>> children = tree.getChildren();
            Double desp = 0d;
            for(int i = 0; i < children.getSize(); i++){
                desp = getTreemapRectangles(children.get(i),rectangle,tree.getRoot().getContent().getSize(),level+1,desp); 
            }
            rectangle.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 1;");
        }
        return desplazamiento;
        
    }
    
}
