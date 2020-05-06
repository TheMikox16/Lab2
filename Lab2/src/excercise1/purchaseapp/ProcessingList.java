/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import excercise1.patterns.PurchaseObserver;
import excercise1.patterns.PurchaseSubscriber;
import excercise1.patterns.WarehouseStaff;
import java.util.ArrayList;
import java.util.Collections;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class ProcessingList implements PurchaseSubscriber{
    
    private TreeMap<Integer, Purchase> list;
    private static int consecutive;
    private ArrayList observers;

    public ProcessingList() {
        this.list = new TreeMap<Integer, Purchase>();
        this.consecutive = 1;
        observers = new ArrayList();
    }
    
    public void addPurchase(Purchase purchase){
        if(purchase != null && !list.containsKey(purchase.getConsecutive())){
            GregorianCalendar gregorian = new GregorianCalendar();
            purchase.setConsecutive(consecutive++);
            purchase.setDate(gregorian);
            purchase.setStatus(new Status(gregorian));
            this.list.put(purchase.getConsecutive(), purchase);
        }
        notifyObservers();
    }
    
    public void updateStatus(int consecutive){
        if(list != null && !list.get(consecutive).updateStatus()){
            Main.delivered.addPurchase(list.remove(consecutive));
        }
    }
    
    public String purchasesByCode(){
        String s = "";
        Iterator<Purchase> iterator = list.values().iterator();
        while (iterator.hasNext()) {
            s += iterator.next() + "\n\n";
        }
        return s;
    }
    
    public String purchasesByStatus(){
        String s = "";
       
        List<Purchase> temp = new ArrayList<>(list.values());

        Collections.sort(temp, new StatusComparator());
        
        Iterator<Purchase> iterator = temp.iterator();
        while (iterator.hasNext()) {
            s += iterator.next() + "\n\n";
        }
        return s;
    }

    @Override
    public void addPurchaseObserver(PurchaseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removePurchaseObserver(PurchaseObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void printObservers(){
        Iterator iterator = observers.iterator();
        while(iterator.hasNext()){
            PurchaseObserver observer = (PurchaseObserver) iterator.next();
            observer.printList();
        }
    }

    @Override
    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while(iterator.hasNext()){
            ((WarehouseStaff) iterator.next()).addProduct(this.list.lastKey(),
                    this.list.lastEntry().getValue());
        }
    }
    
}
