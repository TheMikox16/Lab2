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
    private Figure figure;
    private ArrayList<AbstractComp> absList;
    private Indentation inden;

    public MixedFigure() {
    }
    
    public MixedFigure(String name, Figure figure, Indentation inden) {
        this.name = name;
        this.figure = figure;
        this.inden = inden;
        absList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
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
    public String ls() {
        String txt = "";
        txt = inden.getIndentation() + "Nombre: " + name + "\n"
                + inden.getIndentation() + "Figura mixta:\n" + figure.ls()
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
