/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.util.ArrayList;
import java.util.Collections;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;


/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class ProcessingList {
    
    private TreeMap<Integer, Purchase> list;
    private static int consecutive;

    public ProcessingList() {
        this.list = new TreeMap<Integer, Purchase>();
        this.consecutive = 1;
    }
    
    public void addPurchase(Purchase purchase){
        if(purchase != null && !list.containsKey(purchase.getConsecutive())){
            GregorianCalendar gregorian = new GregorianCalendar();
            purchase.setConsecutive(consecutive++);
            purchase.setDate(gregorian);
            purchase.setStatus(new Status(gregorian));
            this.list.put(purchase.getConsecutive(), purchase);
        }
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
            s += iterator.next()+ "\n\n";
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
    
}
