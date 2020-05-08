/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Figura mixta que contiene una lista de AbstactComp (figuras). Puede clonarse 
 * ademas de que permite imprimir sus atributos de forma identada. Esta figura
 * puede tener una figura mixta y dentro otra mas, es decir, puede tneer distintos
 * niveles de composicion.
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class MixedFigure extends Figure implements AbstractComp , Cloneable {

    private ArrayList<AbstractComp> absList = new ArrayList<>();
    private Indentation inden;

    public MixedFigure(Indentation inden) {
        this.inden = inden;
    }
    
    public MixedFigure(ArrayList<AbstractComp> absList) {
        this.absList = absList;
    }

    public ArrayList<AbstractComp> getAbsList() {
        return absList;
    }

    public void setAbsList(ArrayList<AbstractComp> absList) {
        this.absList = absList;
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
    
    /**
     * Meotodo que es llamado por cada figura mixta de distintos
     * niveles y se encarga de imprimir los datos de cada figura
     * mixta de forma identada y ordenada
     * 
     * @return String con datos de la figura mixta 
     */
    @Override
    public String ls() {
        String txt;
        txt = inden.getIndentation() + "Figura Mixta:\n" 
                + inden.getIndentation() + " Lista de figuras:\n"
                + print();
        return txt;
    }
    
    /**
     * Metodo para recorrer y llamar todos los metodos ls() de la lista
     * de figuras. Se ha separado de ls() para mejorar el entendimiento
     * del proceso que se impresion realiza.
     * 
     * @return String retornado a ls 
     */
    public String print(){
        String txt = "";
        Iterator itList = absList.iterator();
        inden.increaseIndentation();
        while(itList.hasNext()){
            Figure temp = (Figure) itList.next();
            txt += temp.ls();
        }
        inden.decreaseIndentation();
        return txt;
    }
    
    /**
     * Clona una figura mixta con los mismos atributos pero con punteros diferentes
     * (diferentes figuras mixtas) lo que permite modificar dicho clon sin modificar
     * el original.
     * 
     * @return Figure que es la copia del objeto original.
     * @throws CloneNotSupportedException cuando el clon no pudo ser creado
     */
    @Override
    public Figure clone() throws CloneNotSupportedException{
        return new MixedFigure(this.absList);
    }
}
