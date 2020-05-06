/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public interface AbstractBuilder {
    
    public abstract void buildCoordenates(int n);
    
    public abstract void buildSide(int n);
    
    public abstract void buildSide2(int n);
    
    public abstract Figure getFigure() throws PersonalizedException;
    
}
