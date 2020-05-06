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
public class Rectangle extends Figure{
    
    private int high;
    private int width;

    public Rectangle() {
    }
    
    public Rectangle(int high, int weigth, int coordenates) {
        super(coordenates);
        this.high = high;
        this.width = weigth;
    }

    public int getHigh() {
        return high;
    }

    public int getWidth() {
        return width;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangulo:\n" + super.toString() + ", Alto: " + high 
                + ", Ancho: " + width + "\n";
    }

    @Override
    public String ls() {
        return toString();
    }
    
    
    
}
