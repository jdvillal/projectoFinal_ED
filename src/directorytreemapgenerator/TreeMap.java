package directorytreemapgenerator;

import project.Tree.Tree;
import project.fileDescriptor.Descriptable;

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
    
    public TreeMap(Tree<Descriptable> directoryTree){
        this.directoryTree = directoryTree;
    }
    
}
