/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;
import excercise1.purchaseapp.Status;
import excercise1.purchaseapp.StatusEnum;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class WarehouseStaff implements PurchaseObserver{
    
    private TreeMap<Integer, Purchase> list = new TreeMap<>();

    @Override
    public void update(Status status, Purchase purchase) {
        Iterator iterator = list.values().iterator();
        while(iterator.hasNext()){
            Purchase temp = (Purchase) iterator.next();
            if(temp != null && temp.getStatus().getDescription() == StatusEnum.DELIVERED
                    && this.list != null){
                this.list.remove(purchase.getConsecutive());
                return;
            }else if(temp == purchase){
                temp.setStatus(status);
                return;
            }
        }
    }
    
    @Override
    public void printList() {
        String s = "";
        System.out.println("ENCARGADO DE BODEGA:\n");
        Iterator keys = this.list.keySet().iterator();
        Iterator values = this.list.values().iterator();
        while(keys.hasNext() & values.hasNext()){
            Purchase temp = (Purchase) values.next();
            s += keys.next() + " - " + temp.getStatus().getDescription() + "\n";
        }
        System.out.println("Lista de Bodega:\n" + s);
    }

    @Override
    public void addProduct(Integer key, Purchase value) {
        list.put(key, value);
    }
    
}
