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
    private LinkedList<Tree> children;
    
    public TreeNode(T content){
        this.content = content;
        this.children = new LinkedList<>();
    }

    public T getContent() {
        return content;
    }

    public LinkedList getChildren() {
        return children;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public void setChildren(LinkedList children) {
        this.children = children;
    }
    
    
    
    
}
