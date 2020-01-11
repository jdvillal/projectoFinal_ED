package directorytreemapgenerator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
        Stage st = new Stage();
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
        st.setScene(sc);
        st.show();
        Stage st2 = drawInfoPallet();
        st.setOnCloseRequest(new EventHandler() {
            @Override
            public void handle(Event event) {
                st2.close();
            }
        });
        
    }
    
    
    public Stage drawInfoPallet(){
        Rectangle text = new Rectangle(); text.setHeight(30);text.setWidth(40);
        text.setStyle("-fx-fill: lavender; -fx-stroke: darkviolet; -fx-stroke-width: 3;");
        Label textLbl = new Label("text");textLbl.setFont(new Font("Tahoma",20));
        Rectangle word = new Rectangle();word.setHeight(30);word.setWidth(40);
        word.setStyle("-fx-fill: royalblue; -fx-stroke: powderblue; -fx-stroke-width: 3;");
        Label wordLbl = new Label("word");wordLbl.setFont(new Font("Tahoma",20));
        Rectangle excel = new Rectangle();excel.setHeight(30);excel.setWidth(40);
        excel.setStyle("-fx-fill: seagreen; -fx-stroke: palegreen; -fx-stroke-width: 3;");
        Label excelLbl = new Label("excel");excelLbl.setFont(new Font("Tahoma",20));
        Rectangle powerpoint = new Rectangle();powerpoint.setHeight(30);powerpoint.setWidth(40);
        powerpoint.setStyle("-fx-fill: tomato; -fx-stroke: red; -fx-stroke-width: 3;");
        Label powerpointLbl = new Label("power point");powerpointLbl.setFont(new Font("Tahoma",20));
        Rectangle audio = new Rectangle();audio.setHeight(30);audio.setWidth(40);
        audio.setStyle("-fx-fill: slateblue; -fx-stroke: deepskyblue; -fx-stroke-width: 3;");
        Label audioLbl = new Label("audio");audioLbl.setFont(new Font("Tahoma",20));
        Rectangle video = new Rectangle();video.setHeight(30);video.setWidth(40);
        video.setStyle("-fx-fill: lightpink; -fx-stroke: deeppink; -fx-stroke-width: 3;");
        Label videoLbl = new Label("video");videoLbl.setFont(new Font("Tahoma",20));
        Rectangle image = new Rectangle();image.setHeight(30);image.setWidth(40);
        image.setStyle("-fx-fill: mistyrose; -fx-stroke: palevioletred; -fx-stroke-width: 3;");
        Label imageLbl = new Label("image");imageLbl.setFont(new Font("Tahoma",20));
        Rectangle system = new Rectangle();system.setHeight(30);system.setWidth(40);
        system.setStyle("-fx-fill: tan; -fx-stroke: chocolate; -fx-stroke-width: 3;");
        Label systemLbl = new Label("system");systemLbl.setFont(new Font("Tahoma",20));
        Rectangle compressed = new Rectangle();compressed.setHeight(30);compressed.setWidth(40);
        compressed.setStyle("-fx-fill: sienna; -fx-stroke: tan; -fx-stroke-width: 3;");
        Label compressedLbl = new Label("compressed");compressedLbl.setFont(new Font("Tahoma",20));
        Rectangle internet = new Rectangle();internet.setHeight(30);internet.setWidth(40);
        internet.setStyle("-fx-fill: aquamarine; -fx-stroke: darkcyan; -fx-stroke-width: 3;");
        Label internetLbl = new Label("internet");internetLbl.setFont(new Font("Tahoma",20));
        Rectangle diskimage = new Rectangle();diskimage.setHeight(30);diskimage.setWidth(40);
        diskimage.setStyle("-fx-fill: skyblue; -fx-stroke: navy; -fx-stroke-width: 3;");
        Label diskimageLbl = new Label("diskimage");diskimageLbl.setFont(new Font("Tahoma",20));
        Rectangle other = new Rectangle();other.setHeight(30);other.setWidth(40);
        other.setStyle("-fx-fill: darkkhaki; -fx-stroke: yellow; -fx-stroke-width: 3;");
        Label otherLbl = new Label("other");otherLbl.setFont(new Font("Tahoma",20));
        Rectangle unknown = new Rectangle();unknown.setHeight(30);unknown.setWidth(40);
        unknown.setStyle("-fx-fill: dimgray; -fx-stroke: gainsboro; -fx-stroke-width: 3;");
        Label unknownLbl = new Label("unknown");unknownLbl.setFont(new Font("Tahoma",20));
        
        GridPane gp = new GridPane();
        gp.add(text, 0, 0);gp.add(textLbl, 1, 0);
        gp.add(word, 0, 1);gp.add(wordLbl, 1, 1);
        gp.add(excel, 0, 2);gp.add(excelLbl, 1, 2);
        gp.add(powerpoint, 0, 3);gp.add(powerpointLbl, 1, 3);
        gp.add(audio, 0, 4);gp.add(audioLbl, 1, 4);
        gp.add(video, 0, 5);gp.add(videoLbl, 1, 5);
        gp.add(image, 0, 6);gp.add(imageLbl, 1, 6);
        gp.add(system, 0, 7);gp.add(systemLbl, 1, 7);
        gp.add(compressed, 0, 8);gp.add(compressedLbl, 1, 8);
        gp.add(internet, 0, 9);gp.add(internetLbl, 1, 9);
        gp.add(diskimage, 0, 10);gp.add(diskimageLbl, 1, 10);
        gp.add(other, 0, 11);gp.add(otherLbl, 1, 11);
        gp.add(unknown, 0, 12);gp.add(unknownLbl, 1, 12);
        
        gp.setHgap(10);gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        
        Stage st = new Stage();
        Scene sc =  new Scene(gp,200,800);
        st.setScene(sc);
        st.show();
        return st;
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
        }
        return desplazamiento;
    }
}
