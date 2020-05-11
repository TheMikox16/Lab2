/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Figura circulo que contiene un atributo aunado con el atributo del padre,
 * Figure. Puede clonarse ademas de que permite imprimir sus atributos de forma
 * identada.
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Circle extends Figure implements Cloneable{
    
    private int radius;
    private Indentation inden;

    public Circle(Indentation inden) {
        this.inden = inden;
    }
    
    public Circle(int radius, Point coordenates) {
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

    /**
     * Agrega identacion a la impresion de el objeto
     * 
     * @return String del texto generado
     */
    @Override
    public String ls() {
        return inden.getIndentation() + "Circulo:\n" 
                +  inden.getIndentation() + super.ls() 
                + ", Radio: " + radius + "\n";
    }
    
    /**
     * Clona un circulo con los mismos atributos pero con punteros diferentes
     * (diferentes circulos) lo que permite modificar dicho clon sin modificar
     * el original.
     * 
     * @return Figure que es la copia del objeto original.
     * @throws CloneNotSupportedException cuando el clon no pudo ser creado
     */
    @Override
    public Figure clone() throws CloneNotSupportedException{
        return new Circle(this.radius, super.getCoordenates());
    }

}
