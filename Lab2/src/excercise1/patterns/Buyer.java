/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;
import excercise1.purchaseapp.Status;
import excercise1.purchaseapp.StatusEnum;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class Buyer implements PurchaseObserver{
    
    private ArrayList<StatusEnum> list = new ArrayList<>();

    @Override
    public void update(Status status, Purchase purchase) {
        list.add(status.getDescription());
    }

    @Override
    public void printList() {
        String s = "";
        System.out.println("COMPRADOR:\n");
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
