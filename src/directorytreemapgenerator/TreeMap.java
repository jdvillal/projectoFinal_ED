package directorytreemapgenerator;

import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import project.Tree.Tree;
import project.fileDescriptor.Descriptable;
import project.fileDescriptor.FileDescriptor;
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

    private Tree<Descriptable> directoryTree;
    private LinkedList<Rectangle> rectangles;
    private LinkedList<Rectangle> directChildren;
    private final Stage mainSt;
    private Scene mainSc;
    private Stack<Tree<Descriptable>> lastScenes;
    Boolean horizontalSense = true;

    public TreeMap(Tree<Descriptable> directoryTree) {
        this.directoryTree = directoryTree;
        this.rectangles = new LinkedList<>();
        this.directChildren = new LinkedList();
        this.mainSt = new Stage();
        lastScenes = new Stack();
    }

    public void updateTreemap(boolean horizontal) {
        this.drawTreemapScene(horizontal);
        mainSt.setScene(mainSc);
        mainSt.setTitle("Tremap: " + this.directoryTree.getRoot().getContent().getDescription());
        mainSt.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
        mainSt.show();
    }

    public void drawTreemapScene(boolean horizontal) {
        Rectangle rc = new Rectangle();
        rc.setManaged(false);
        rc.setWidth(1250);
        rc.setHeight(800);
        rc.setTranslateX(0);
        rc.setTranslateY(0);
        if(horizontal){
            getTreemapRectangles(this.directoryTree, rc, this.directoryTree.getRoot().getContent().getSize(), 0, 0d);
        }else{
            getTreemapRectangles(this.directoryTree, rc, this.directoryTree.getRoot().getContent().getSize(), 1, 0d);
        }
        GridPane sp = new GridPane();
        for (int i = 0; i < this.rectangles.getSize(); i++) {
            sp.add(this.rectangles.get(i), 0, 0);
        }
        getChildrenRectangles(rc, this.directoryTree.getRoot().getContent().getSize(), horizontal);
        for (int i = 0; i < directChildren.getSize(); i++) {
            sp.add(this.directChildren.get(i), 0, 0);
        }
        GridPane sp2 = drawInfoPallet();
        sp.add(sp2, 0, 0);
        sp2.setTranslateX(1300);
        sp2.setTranslateY(5);
        mainSc = new Scene(sp, 1620, 801);
    }

    public GridPane drawInfoPallet() {
        Rectangle text = new Rectangle();
        text.setHeight(25);
        text.setWidth(40);
        text.setStyle("-fx-fill: lavender; -fx-stroke: darkviolet; -fx-stroke-width: 3;");
        Label textLbl = new Label("text");
        textLbl.setFont(new Font("Tahoma", 15));
        Rectangle word = new Rectangle();
        word.setHeight(25);
        word.setWidth(40);
        word.setStyle("-fx-fill: royalblue; -fx-stroke: powderblue; -fx-stroke-width: 3;");
        Label wordLbl = new Label("word");
        wordLbl.setFont(new Font("Tahoma", 15));
        Rectangle excel = new Rectangle();
        excel.setHeight(25);
        excel.setWidth(40);
        excel.setStyle("-fx-fill: seagreen; -fx-stroke: palegreen; -fx-stroke-width: 3;");
        Label excelLbl = new Label("excel");
        excelLbl.setFont(new Font("Tahoma", 15));
        Rectangle powerpoint = new Rectangle();
        powerpoint.setHeight(25);
        powerpoint.setWidth(40);
        powerpoint.setStyle("-fx-fill: tomato; -fx-stroke: red; -fx-stroke-width: 3;");
        Label powerpointLbl = new Label("power point");
        powerpointLbl.setFont(new Font("Tahoma", 15));
        Rectangle audio = new Rectangle();
        audio.setHeight(25);
        audio.setWidth(40);
        audio.setStyle("-fx-fill: slateblue; -fx-stroke: deepskyblue; -fx-stroke-width: 3;");
        Label audioLbl = new Label("audio");
        audioLbl.setFont(new Font("Tahoma", 15));
        Rectangle video = new Rectangle();
        video.setHeight(25);
        video.setWidth(40);
        video.setStyle("-fx-fill: lightpink; -fx-stroke: deeppink; -fx-stroke-width: 3;");
        Label videoLbl = new Label("video");
        videoLbl.setFont(new Font("Tahoma", 15));
        Rectangle image = new Rectangle();
        image.setHeight(25);
        image.setWidth(40);
        image.setStyle("-fx-fill: mistyrose; -fx-stroke: palevioletred; -fx-stroke-width: 3;");
        Label imageLbl = new Label("image");
        imageLbl.setFont(new Font("Tahoma", 15));
        Rectangle system = new Rectangle();
        system.setHeight(25);
        system.setWidth(40);
        system.setStyle("-fx-fill: tan; -fx-stroke: chocolate; -fx-stroke-width: 3;");
        Label systemLbl = new Label("system");
        systemLbl.setFont(new Font("Tahoma", 15));
        Rectangle compressed = new Rectangle();
        compressed.setHeight(25);
        compressed.setWidth(40);
        compressed.setStyle("-fx-fill: sienna; -fx-stroke: tan; -fx-stroke-width: 3;");
        Label compressedLbl = new Label("compressed");
        compressedLbl.setFont(new Font("Tahoma", 15));
        Rectangle internet = new Rectangle();
        internet.setHeight(25);
        internet.setWidth(40);
        internet.setStyle("-fx-fill: aquamarine; -fx-stroke: darkcyan; -fx-stroke-width: 3;");
        Label internetLbl = new Label("internet");
        internetLbl.setFont(new Font("Tahoma", 15));
        Rectangle diskimage = new Rectangle();
        diskimage.setHeight(25);
        diskimage.setWidth(40);
        diskimage.setStyle("-fx-fill: skyblue; -fx-stroke: navy; -fx-stroke-width: 3;");
        Label diskimageLbl = new Label("diskimage");
        diskimageLbl.setFont(new Font("Tahoma", 15));
        Rectangle other = new Rectangle();
        other.setHeight(25);
        other.setWidth(40);
        other.setStyle("-fx-fill: darkkhaki; -fx-stroke: yellow; -fx-stroke-width: 3;");
        Label otherLbl = new Label("other");
        otherLbl.setFont(new Font("Tahoma", 15));
        Rectangle unknown = new Rectangle();
        unknown.setHeight(25);
        unknown.setWidth(40);
        unknown.setStyle("-fx-fill: dimgray; -fx-stroke: gainsboro; -fx-stroke-width: 3;");
        Label unknownLbl = new Label("unknown");
        unknownLbl.setFont(new Font("Tahoma", 15));

        Button printButton = new Button("Print tree");
        printButton.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                treeIterator(directoryTree, 0);
            }
        });

        TableView<Descriptable> table = new TableView<>();
        table.setMaxWidth(210);
        table.setMaxHeight(200);
        TableColumn firstNameCol = new TableColumn("Hijos directos");
        firstNameCol.setMinWidth(125);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        TableColumn secondNameCol = new TableColumn("Tamaño(Bytes)");
        secondNameCol.setMinWidth(85);
        secondNameCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        ObservableList<Descriptable> data = FXCollections.observableArrayList();
        LinkedList<Tree<Descriptable>> children = this.directoryTree.getChildren();
        for (int i = 0; i < children.getSize(); i++) {
            data.add((FileDescriptor) children.get(i).getRoot().getContent());
        }
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, secondNameCol);

        LinkedList<Tuple<String, Rectangle>> tuplas = new LinkedList();
        for (int i = 0; i < children.getSize(); i++) {
            Tuple<String, Rectangle> nTuple = new Tuple(children.get(i).getRoot().getContent().getDescription(), directChildren.get(i));
            tuplas.add(nTuple);
        }

        Button showButton = new Button("Show me");
        showButton.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    for (int i = 0; i < tuplas.getSize(); i++) {
                        if (tuplas.get(i).getFirst().equals(table.getSelectionModel().getSelectedItem().getDescription())) {
                            System.out.print("found");
                            RectangleAnimator ra = new RectangleAnimator(tuplas.get(i).getSecond());
                            ra.start();
                        }
                    }
                } catch (NullPointerException npe) {
                    Alert al = new Alert(AlertType.ERROR);
                    al.setTitle("No child selected");
                    al.setContentText("Asegurece de seleccionar un hijo!");
                    al.showAndWait();
                }

            }
        });

        Button mapChildBtn = new Button("Map child");
        Button backButton = new Button("<-");
        mapChildBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                try {
                    Descriptable selectedChild = table.getSelectionModel().getSelectedItem();
                    for (int i = 0; i < children.getSize(); i++) {
                        Descriptable ds = children.get(i).getRoot().getContent();
                        if (ds.equals(selectedChild)) {
                            lastScenes.push(directoryTree);
                            backButton.setDisable(false);
                            directoryTree = children.get(i);
                            rectangles.removeAll();
                            directChildren.removeAll();
                            updateTreemap(true);
                        }
                    }
                } catch (NullPointerException npe) {
                    Alert al = new Alert(AlertType.ERROR);
                    al.setTitle("No child selected");
                    al.setContentText("Asegurece de seleccionar un hijo!");
                    al.showAndWait();
                }
            }
        });

        backButton.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (!lastScenes.isEmpty()) {
                    rectangles.removeAll();
                    directChildren.removeAll();
                    directoryTree = lastScenes.pop();
                    updateTreemap(true);
                } else {
                    backButton.setDisable(true);
                }
            }
        });
        
        Button turnButton = new Button("Girar");
        turnButton.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                rectangles.removeAll();
                directChildren.removeAll();
                if(horizontalSense){
                    updateTreemap(false);
                    horizontalSense = false;
                }else{
                    updateTreemap(true);
                    horizontalSense = true;
                }
                
            }
        });

        VBox buttonsVB = new VBox();
        buttonsVB.setAlignment(Pos.CENTER);
        buttonsVB.setSpacing(10);
        buttonsVB.getChildren().addAll(backButton, printButton, showButton, mapChildBtn, turnButton);

        GridPane gp = new GridPane();
        gp.add(text, 0, 1);
        gp.add(textLbl, 1, 1);
        gp.add(word, 0, 2);
        gp.add(wordLbl, 1, 2);
        gp.add(excel, 0, 3);
        gp.add(excelLbl, 1, 3);
        gp.add(powerpoint, 0, 4);
        gp.add(powerpointLbl, 1, 4);
        gp.add(audio, 0, 5);
        gp.add(audioLbl, 1, 5);
        gp.add(video, 0, 6);
        gp.add(videoLbl, 1, 6);
        gp.add(image, 0, 7);
        gp.add(imageLbl, 1, 7);
        gp.add(system, 0, 8);
        gp.add(systemLbl, 1, 8);
        gp.add(compressed, 0, 9);
        gp.add(compressedLbl, 1, 9);
        gp.add(internet, 0, 10);
        gp.add(internetLbl, 1, 10);
        gp.add(diskimage, 0, 11);
        gp.add(diskimageLbl, 1, 11);
        gp.add(other, 0, 12);
        gp.add(otherLbl, 1, 12);
        gp.add(unknown, 0, 13);
        gp.add(unknownLbl, 1, 13);
        gp.add(buttonsVB, 0, 14);//add printButton
        gp.add(table, 1, 14);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        return gp;
    }

    private Double getTreemapRectangles(Tree<Descriptable> tree, Rectangle parentRectangle, double parentSize, int level, Double desplazamiento) {
        Rectangle rectangle = new Rectangle();
        rectangle.setManaged(false);
        double part = tree.getRoot().getContent().getSize() / parentSize;
        double xLen = parentRectangle.getWidth();
        double yLen = parentRectangle.getHeight();
        double xPos = parentRectangle.getTranslateX();
        double yPos = parentRectangle.getTranslateY();
        if (level % 2 == 1) {
            //Dividir el rectangulo original en bloques horizontales(x)
            rectangle.setTranslateX(xPos + desplazamiento);
            rectangle.setTranslateY(yPos);
            rectangle.setWidth(part * xLen);
            rectangle.setHeight(yLen);
            desplazamiento = desplazamiento + rectangle.getWidth();
        } else if (level % 2 == 0) {
            //Dividir el rectangulo orignial en bloques verticales(y)
            rectangle.setTranslateX(xPos);
            rectangle.setTranslateY(yPos + desplazamiento);
            rectangle.setWidth(xLen);
            rectangle.setHeight(part * yLen);
            desplazamiento = desplazamiento + rectangle.getHeight();
        }

        if (tree.isLeaf()) {
            rectangle.setStyle(tree.getRoot().getContent().getStyle());
            rectangles.add(rectangle);
        } else {
            LinkedList<Tree<Descriptable>> children = tree.getChildren();
            Double desp = 0d;
            for (int i = 0; i < children.getSize(); i++) {
                desp = getTreemapRectangles(children.get(i), rectangle, tree.getRoot().getContent().getSize(), level + 1, desp);
            }
        }
        return desplazamiento;
    }

    private void getChildrenRectangles(Rectangle parentRectangle, double parentSize, Boolean horizontal) {
        Double desp = 0d;
        LinkedList<Tree<Descriptable>> children = this.directoryTree.getChildren();
        for (int i = 0; i < children.getSize(); i++) {
            System.out.println(children.get(i).getRoot().getContent().getDescription());
            double part = children.get(i).getRoot().getContent().getSize() / parentSize;

            Rectangle rectangle = new Rectangle();
            rectangle.setStyle("-fx-fill: black; -fx-stroke: white; -fx-stroke-width: 1;");
            rectangle.setManaged(false);
            rectangle.setVisible(false);
            double xLen = parentRectangle.getWidth();
            double yLen = parentRectangle.getHeight();
            double xPos = parentRectangle.getTranslateX();
            double yPos = parentRectangle.getTranslateY();

            if (horizontal) {
                rectangle.setTranslateX(xPos + desp);
                rectangle.setTranslateY(yPos);
                rectangle.setWidth(part * xLen);
                rectangle.setHeight(yLen);
                directChildren.add(rectangle);
                desp = desp + rectangle.getWidth();
            } else {
                rectangle.setTranslateX(xPos);
                rectangle.setTranslateY(yPos + desp);
                rectangle.setWidth(xLen);
                rectangle.setHeight(part * yLen);
                directChildren.add(rectangle);
                desp = desp + rectangle.getHeight();
            }
        }
    }

    static void treeIterator(Tree<Descriptable> t, int tabs) {
        String identer = "";
        for (int i = 0; i < tabs; i++) {
            identer = identer + "│     ";
        }
        System.out.println(identer + t.getRoot().getContent().getDescription());
        LinkedList<Tree<Descriptable>> children = t.getChildren();
        for (int i = 0; i < t.countChildren(); i++) {
            treeIterator(children.get(i), tabs + 1);
        }
    }
}
