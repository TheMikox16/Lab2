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
public interface FactoryInterface {
    
    public abstract Figure createFigure(int... specs) throws PersonalizedException;
    
    public abstract Figure createFigure(Figure... figures) throws PersonalizedException;
    
}
