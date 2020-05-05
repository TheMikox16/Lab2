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
    
    public abstract void buildCoordenates();
    
    public abstract void buildSide();
    
    public abstract void buildSide2();
    
    public abstract Figure getFigure() throws PersonalizedException();
    
}
