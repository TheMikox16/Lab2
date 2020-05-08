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
 * Clase de la lista de procesamiento. Solo puede haber una clase de la misma en 
 * todo el programa (singleton)
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class ProcessingList implements PurchaseSubscriber{
    
    private TreeMap<Integer, Purchase> list;
    private static int consecutive;
    private ArrayList observers;
    private static ProcessingList instance = new ProcessingList();

    /**
     * Constructor privado para evitar otras instancias de la clase
     */
    private ProcessingList() {
        this.list = new TreeMap<Integer, Purchase>();
        this.consecutive = 1;
        observers = new ArrayList();
    }
    
    /**
     * Metodo que crea/regresa la unica instancia de la lista 
     * 
     * @return DeliveredList la instancia
     */
    public static ProcessingList getInstance(){
        if(instance == null){
            instance = new ProcessingList();
        }
        return instance;
    }
    
    /**
     * Añade una compra a la lista. Al añadir una compra debera añadirse a cada
     * empleado (observador) que exista para los productos
     * 
     * @param purchase compra a añadir
     */
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
    
    /**
     * Actualiza el 
     * 
     * @param consecutive
     */
    public void updateStatus(int consecutive){
        if(list != null && !list.get(consecutive).updateStatus()){
            Main.delivered.addPurchase(list.remove(consecutive));
        }
    }
    
    /**
     * Imprime las compras por codigo
     * 
     * @return String con la lista
     */
    public String purchasesByCode(){
        String s = "";
        Iterator<Purchase> iterator = list.values().iterator();
        while (iterator.hasNext()) {
            s += iterator.next() + "\n\n";
        }
        return s;
    }
    
    /**
     * Imprime las compras por fecha de estatus
     * 
     * @return String con la lista
     */
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
 
    /**
     * Añade un empleado (observador) a la lista
     * 
     * @param observer el empleado a añadir
     */
    @Override
    public void addPurchaseObserver(PurchaseObserver observer) {
        observers.add(observer);
    }

    /**
     * Remueve el empleado especificado 
     * 
     * @param observer el empleado
     */
    @Override
    public void removePurchaseObserver(PurchaseObserver observer) {
        observers.remove(observer);
    }
    
    /**
     * Imprime los empleados (observadores)
     */
    @Override
    public void printObservers(){
        Iterator iterator = observers.iterator();
        while(iterator.hasNext()){
            PurchaseObserver observer = (PurchaseObserver) iterator.next();
            observer.printList();
        }
    }

    /**
     * Añade una compra a cada empleado (observador) de la lista
     */
    @Override
    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while(iterator.hasNext()){
            ((WarehouseStaff) iterator.next()).addProduct(this.list.lastKey(),
                    this.list.lastEntry().getValue());
        }
    }
    
}
