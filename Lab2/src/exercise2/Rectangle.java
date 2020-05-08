/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Figura rectangulo que contiene dos atributos aunados con el atributo del padre,
 * Figure. Puede clonarse ademas de que permite imprimir sus atributos de forma
 * identada.
 *
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
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

    /**
     * Agrega identacion a la impresion de el objeto
     * 
     * @return String del texto generado
     */
    @Override
    public String ls() {
        return inden.getIndentation() + "Rectangulo:\n" 
                + inden.getIndentation() + super.ls() 
                + ", Alto: " + high 
                + ", Ancho: " + width + "\n";
    }
    
    /**
     * Clona un rectangulo con los mismos atributos pero con punteros diferentes
     * (diferentes rectangulos) lo que permite modificar dicho clon sin modificar
     * el original.
     * 
     * @return Figure que es la copia del objeto original.
     * @throws CloneNotSupportedException cuando el clon no pudo ser creado
     */
    @Override
    public Figure clone() throws CloneNotSupportedException{
        return new Rectangle(this.high, this.width, super.getCoordenates());
    }
    
    
}
