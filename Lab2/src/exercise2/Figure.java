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
    
    private Point coordenates;

    public Figure() {
    }

    public Figure(Point coordenates) {
        this.coordenates = coordenates;
    }

    public Point getCoordenates() {
        return coordenates;
    }

    public void setCoordenates(Point coordenates) {
        this.coordenates = coordenates;
    }


    @Override
    public String toString() {
        return "Coordenadas: " + coordenates.toString();
    }
    
    @Override
    public String ls(){
        return "Coordenadas: " + coordenates.toString();
    }
    
    /**
     * Llama al clon de la clase hija
     * @return Figure figura clonada
     * @throws CloneNotSupportedException si no se pudo clonar
     */
    @Override
    public abstract Figure clone() throws CloneNotSupportedException;
    
}
