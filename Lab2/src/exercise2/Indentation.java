/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Clase que se encarga del espaciado al imprimir. Ha de manejarse una misma
 * identacion en todo el programa.
 *
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Indentation {

    private StringBuffer sub;

    public Indentation() {
        sub = new StringBuffer();
    }

    public String getIndentation() {
        return sub.toString();
    }

    public void increaseIndentation() {
        sub.append("   ");
    }

    public void decreaseIndentation() {
        if (sub.length() >= 3) {
            sub.setLength(sub.length() - 3);
        }
    }
}
