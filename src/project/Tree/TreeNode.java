/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Tree;

import project.linkedList.LinkedList;

/**
 *
 * @author daniel
 * @param <T>
 */
public class TreeNode<T> {
    private T content;
    private LinkedList<Tree<T>> children;
    
    public TreeNode(T content){
        this.content = content;
        this.children = new LinkedList<>();
    }

    public T getContent() {
        return content;
    }

    public LinkedList<Tree<T>> getChildren() {
        return children;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void addChildren(LinkedList<T> children) {
        for(int i = 0; i <  children.getSize();i++){
            Tree nTree = new Tree(children.get(i));
            this.children.add(nTree);
        }
    }
    
    public void setChildren(LinkedList<Tree<T>> children){
        this.children = children;
    }
    
    public void addChild(Tree child){
        this.children.add(child);
    }
    
    
    
    
}
