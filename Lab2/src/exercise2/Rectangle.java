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
public class Rectangle extends Figure implements Cloneable{
    
    private int high;
    private int width;
    private Indentation inden;

    public Rectangle(Indentation inden) {
        this.inden = inden;
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
        return inden.getIndentation() + "Rectangulo:\n" 
                + inden.getIndentation() + super.ls() 
                + ", Alto: " + high 
                + ", Ancho: " + width + "\n";
    }
    
    @Override
    public Figure clone() throws CloneNotSupportedException{
        return new Rectangle(this.high, this.width, super.getCoordenates());
    }
    
    
}
