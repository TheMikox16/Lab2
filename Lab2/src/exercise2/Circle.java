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
public class Circle extends Figure implements Cloneable{
    
    private int radius;
    private Indentation inden;

    public Circle(Indentation inden) {
        this.inden = inden;
    }
    
    public Circle(int radius, int coordenates) {
        super(coordenates);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circulo:\n" + super.toString() + ", Radio: " + radius + "\n";
    }

    @Override
    public String ls() {
        return inden.getIndentation() + "Circulo:\n" 
                +  inden.getIndentation() + super.ls() 
                + ", Radio: " + radius + "\n";
    }
    
    @Override
    public Figure clone() throws CloneNotSupportedException{
        return new Circle(this.radius, super.getCoordenates());
    }

}
