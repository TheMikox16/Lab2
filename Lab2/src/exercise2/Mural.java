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
 *
 * @author Sean
 */
public class Mural {
    
    private final List<Figure> figuresList = new LinkedList<Figure>();

    public Mural() {
    }
    
    public List<Figure> getList(){
        return figuresList;
    }
    
    public void add(Figure figure){
        figuresList.add(figure);
    }
    
    public boolean delete(Figure figure){
        return figuresList.remove(figure);
    }
    
    public int hash(){
        return figuresList.hashCode();
    }
    
    public String print(){
        String s = "";
        Iterator itList = figuresList.iterator();
        while(itList.hasNext()){
            s += itList.next().toString() + "\n";
        }
        return s;
    }
    
    public Figure clone(int n) throws CloneNotSupportedException{
        Object[] temp = this.figuresList.toArray();
        return ((Figure) temp[n]).clone();
    }
    
}
