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
public class LinkedList<E> {
    private Node<E> head;
    private int effectiveSize;
    
    public LinkedList(){
    }
    
    public void addFirst(E content){
        Node<E> nNode = new Node(content);
        if(this.head == null){
            this.head = nNode;
            effectiveSize++;
        }else{
            Node<E> temp = this.head;
            this.head = nNode;
            this.head.setNext(temp);
            effectiveSize++;
        }
    }
    
    public void addLast(E content){
        Node<E> nNode = new Node(content);
        if(this.head == null){
            this.head = nNode;
            effectiveSize++;
        }else{
            Node<E> temp = getNodeAt(effectiveSize-1);
            temp.setNext(nNode);
            effectiveSize++;
        }
    }
    
    public void add(E content){
        addLast(content);
    }
    
    public void addAt(E content, int index){
        Node<E> nNode = new Node(content);
        if(index == 0){
            this.addFirst(content);
        }else{
            Node<E> last = getNodeAt(index-1);
            Node<E> next = last.getNext();        
            last.setNext(nNode);
            nNode.setNext(next);
            effectiveSize++;
        }
    }
    
    private Node<E> getNodeAt(int index){
        Node<E> itr =  this.head;
        for(int i = 0; i < index ; i++){
            itr = itr.getNext();
        }
        return itr;
    }
    
    public E get(int index){
        return getNodeAt(index).getContent();
    }
    
    public int getSize(){
        return this.effectiveSize;
    }
    
    public boolean isEmpty(){
        return this.effectiveSize == 0;
    }
    
    public boolean contains(E content){
        Node<E> str = this.head;
        for(int i = 0; i < this.effectiveSize;i++){
            if(str.getContent().equals(content)){
                return true;
            }
            str = str.getNext();
        }
        return false;
    }
    
    public void removeAll(){
        this.head = null;
        this.effectiveSize = 0;
    }
    
  
    
    
}
