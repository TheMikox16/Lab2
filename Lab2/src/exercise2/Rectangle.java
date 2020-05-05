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
    private int weigth;

    public Rectangle(int high, int weigth, int coordenates) {
        super(coordenates);
        this.high = high;
        this.weigth = weigth;
    }

    public int getHigh() {
        return high;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    @Override
    public String toString() {
        return "Rectangulo:\n" + super.toString() + ", Alto: " + high 
                + ", Ancho: " + weigth;
    }
    
    
    
}
