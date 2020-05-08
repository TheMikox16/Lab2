/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Clase de excepciones personalizadas que es llamada cuando en algun punto del
 * programa se realiza una validacion erronea
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class PersonalizedException extends Exception{

    public PersonalizedException(String msg) {
        super(msg);
    }
    
}
