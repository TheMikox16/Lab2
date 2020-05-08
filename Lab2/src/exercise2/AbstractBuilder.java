/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Interfaz que indica lo que debe implementar un constructor de figuras
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public interface AbstractBuilder {
    
    public abstract void buildFigure(Indentation inden, int n);
    
    public abstract void buildCoordenates(int n);
    
    public abstract void buildSide(int n);
    
    public abstract void buildSide2(int n);
    
    public abstract void buildMixed(Figure... figures);
    
    public abstract Figure getFigure() throws PersonalizedException;
    
}
