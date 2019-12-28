package project.Tree;

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
 * @param <T>
 */
public class Tree<T> {
    private TreeNode<T> root;
    
    public Tree(T content){
        this.root = new TreeNode(content);
    }
    
    public TreeNode<T> getRoot(){
        return root;
    }
    
    public LinkedList<Tree<T>> getChildren(){
        return root.getChildren();
    }
    
    public boolean isLeaf(){
        return root.getChildren().isEmpty();
    }
    
    public int countChildren(){
        return root.getChildren().getSize();
    }
    
    public void addChild(T content){
        Tree<T> nChild = new Tree(content);
        this.root.addChild(nChild);
    }
    
    public void setChildren(LinkedList<Tree<T>> children){
        this.root.setChildren(children);
    }
    
    
    
    
    
}
