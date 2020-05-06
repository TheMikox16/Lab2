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
public class Indentation {

    private final StringBuffer sub;

    public Indentation() {
        sub = new StringBuffer();
    }

    public String getIndentation() {
        return sub.toString();
    }

    public void increaseIndentation() {
        sub.append("     ");
    }

    public void decreaseIndentation() {
        if (sub.length() >= 3) {
            sub.setLength(sub.length() - 3);
        }
    }
}
