/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Interfaz con todos los metodos que han de implementar las fabricas
 * de figuras
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public interface FactoryInterface {
    
    public abstract Figure createFigure(Indentation inden, Point coordenates, int... specs) throws PersonalizedException;
    
    public abstract Figure createFigure(Indentation inden, Figure... figures) throws PersonalizedException;
    
}
