/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class DeliveredList {
    
    private TreeSet<Purchase> list;

    public DeliveredList() {
        this.list = new TreeSet<Purchase>();
    }
    
    public void addPurchase(Purchase purchase){
        this.list.add(purchase);
    }
    
    public String purchasesByStatusDate(){
        String s = "";
        Iterator iterator = this.list.iterator();
        while(iterator.hasNext()){
            s += iterator.next().toString() + "\n";
        }
        return s;
    }
    
}
