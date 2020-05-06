/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public abstract class Figure implements AbstractComp{
    
    private int coordenates;

    public Figure() {
    }

    public Figure(int coordenates) {
        this.coordenates = coordenates;
    }

    public int getCoordenates() {
        return coordenates;
    }

    public void setCoordenates(int coordenates) {
        this.coordenates = coordenates;
    }

    @Override
    public String toString() {
        return "Coordenadas: " + coordenates;
    }
    
    public abstract String ls();
    
}
