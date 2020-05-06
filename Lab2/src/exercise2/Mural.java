/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sean
 */
public class Mural<T> implements Cloneable {
    
    private final List<T> figuresList = new LinkedList<>();

    public Mural() {
    }
    
    public List<T> getList(){
        return figuresList;
    }
    
    public void add(T object){
        figuresList.add(object);
    }
    
    public boolean delete(T object){
        return figuresList.remove(object);
    }
    
    public int hash(){
        return figuresList.hashCode();
    }
    
    public T search(int i){
        return figuresList.get(i);
    }
    
    public String print(){
        String s = "";
        Iterator itList = figuresList.iterator();
        while(itList.hasNext()){
            s += itList.next().toString() + "\n";
        }
        return s;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
}
