/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;



/**
 *  Interfaz que se utiliza por varias clases para desarrollar
 *  los diferentes tipos de envio.
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public interface IStrategy {
    
    /*
    * Metodo encargado de mostrar los envios.
    */
    public void shipping(double totalWeight);
}
