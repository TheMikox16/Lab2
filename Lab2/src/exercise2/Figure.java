/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Clase padre de todas las figuras que contiene el atributo comun
 * coordenates (coordenadas). Puede ser clonado mediante las clases hijas.
 * Cualquier figura de un nuevo tipo debera ser hija de esta clase
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public abstract class Figure implements AbstractComp, Cloneable{
    
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
    
    @Override
    public String ls(){
        return "Coordenadas: " + coordenates;
    }
    
    /**
     * Llama al clon de la clase hija
     * @return Figure figura clonada
     * @throws CloneNotSupportedException si no se pudo clonar
     */
    @Override
    public abstract Figure clone() throws CloneNotSupportedException;
    
}
