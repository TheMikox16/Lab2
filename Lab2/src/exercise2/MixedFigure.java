/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sean
 */
public class MixedFigure extends Figure implements AbstractComp {

    private String name;
    private ArrayList<AbstractComp> absList = new ArrayList<>();
    private Indentation inden = new Indentation();

    public MixedFigure() {
    }
    
    public MixedFigure(String name, Indentation inden) {
        this.name = name;
        this.inden = inden;
        absList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<AbstractComp> getAbsList() {
        return absList;
    }

    public void setAbsList(ArrayList<AbstractComp> absList) {
        this.absList = absList;
    }

    public Indentation getInden() {
        return inden;
    }

    public void setInden(Indentation inden) {
        this.inden = inden;
    }
    
    public void addAbs(AbstractComp abs){
        if(!absList.contains(abs)){
            absList.add(abs);
        }  
    }
    
    public void deleteAbs(AbstractComp abs){
        absList.remove(abs);
    }

    @Override
    public String toString() {
        return ls();
    }
    
    @Override
    public String ls() {
        String txt = "";
        txt = inden.getIndentation() + "Nombre: " + name + "\n"
                + inden.getIndentation() + "Lista de figuras:\n" + print() +"\n";
        inden.increaseIndentation();
        
        for(AbstractComp comp: absList){
            txt += comp.ls();
        }
        inden.decreaseIndentation();
        return txt;
    }
    
    public String print(){
        String txt = "";
        Iterator itList = absList.iterator();
        while(itList.hasNext()){
            Figure temp = (Figure) itList.next();
            txt += temp.ls();
        }
        return txt;
    }
    
}
