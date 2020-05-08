/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.util.Comparator;

/**
 * Interfaz comparador que implementan los estados para efectos de ordenamiento
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class StatusComparator implements Comparator<Purchase>{

    @Override
    public int compare(Purchase o1, Purchase o2) {
        return o1.getStatus().getDescription().compareTo(o2.getStatus().getDescription());
    }
    
}
