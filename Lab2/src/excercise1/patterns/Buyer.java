/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;
import excercise1.purchaseapp.Status;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class Buyer implements PurchaseObserver{
    
    private ArrayList<Status> list = new ArrayList<>();

    @Override
    public void update(Status status, Purchase purchase) {
        list.add(status);
    }

    @Override
    public void printList() {
        String s = "";
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            s += iterator.next().toString() + "\n";
        }
        System.out.println("Historial de estados:\n" + s);
    }

    @Override
    public void addProduct(Integer key, Purchase value) {
    }
    
}
