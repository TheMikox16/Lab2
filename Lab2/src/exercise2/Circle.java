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

    public Circle() {
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
        return toString();
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}
