/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.util.Comparator;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class StatusComparator implements Comparator<Purchase>{

    @Override
    public int compare(Purchase o1, Purchase o2) {
        return o1.getStatus().getDescription().compareTo(o2.getStatus().getDescription());
    }
    
}
