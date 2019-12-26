package project.Tree;

import project.linkedList.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 * @param <T>
 */
public class Tree<T> {
    private TreeNode<T> root;
    
    public LinkedList<Tree> getChildre(){
        return root.getChildren();
    }
    
    public boolean isLeaf(){
        return root.getChildren().isEmpty();
    }
    
    public int countChildren(){
        return root.getChildren().getSize();
    }
    
    
    
}
