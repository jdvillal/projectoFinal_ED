/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.linkedList;

/**
 *
 * @author danie
 * @param <E>
 */
public class Node<E> {
    private E content;
    private Node<E> nextNode;
    
    public Node(E content) {
        this.content = content;
        this.nextNode = null;
    }

    public E getContent() {
        return content;
    }

    public Node<E> getNext() {
        return nextNode;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public void setNext(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    
    
    
}
