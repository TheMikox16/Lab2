/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase encargada de manejar todas las figuras hechas en el mural
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Mural {
    
    private final List<Figure> figuresList = new LinkedList<Figure>();

    public Mural() {
    }
    
    public List<Figure> getList(){
        return figuresList;
    }
    
    /**
     * Añade una figura a la lista
     * @param figure figura que se añadira
     */
    public void add(Figure figure){
        figuresList.add(figure);
    }
    
    /**
     * elimina una figura de la lisa
     * @param figure figura a elminar
     * @return boolean que afirma o niega laeliminacion de la figura
     */
    public boolean delete(Figure figure){
        return figuresList.remove(figure);
    }
    
    /**
     * hash code de la lista
     * @return int codigo hash de la lista
     */
    public int hash(){
        return figuresList.hashCode();
    }
    
    /**
     * Imprime la lista
     * 
     * @return String todos los valores añadidos de la figuras
     */
    public String print(){
        String s = "";
        Iterator itList = figuresList.iterator();
        while(itList.hasNext()){
            s += itList.next().toString() + "\n";
        }
        return s;
    }
    
    /**
     * Hace un clon en de una figura en base a un indice determinado.
     * 
     * @param n indice de la figura a clonar
     * @return Figure figura clonada
     * @throws CloneNotSupportedException cuando no se puede clonar
     */
    public Figure clone(int n) throws CloneNotSupportedException{
        Object[] temp = this.figuresList.toArray();
        return ((Figure) temp[n]).clone();
    }
    
}
