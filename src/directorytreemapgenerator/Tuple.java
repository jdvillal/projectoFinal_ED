/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorytreemapgenerator;

/**
 *
 * @author danie
 * @param <A>
 * @param <B>
 */
public class Tuple<A,B> {
    A first;
    B second;
    
    public Tuple(A a, B b){
        this.first = a;
        this.second = b;
    }
    
    public A getFirst(){
        return this.first;
    }
    
    public B getSecond(){
        return this.second;
    }
            
            
}
