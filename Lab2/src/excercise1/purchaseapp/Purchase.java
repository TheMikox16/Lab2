/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import excercise1.patterns.Buyer;
import excercise1.patterns.IStrategy;
import excercise1.patterns.PurchaseObserver;
import excercise1.patterns.PurchaseSubscriber;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class Purchase extends StatusComparator implements Comparable<Purchase>, PurchaseSubscriber{
    
    private int consecutive;
    private GregorianCalendar date;
    private Status status;
    private TreeMap<String, Product> list;
    private IStrategy shipping;
    private ArrayList<PurchaseObserver> observers;

    public Purchase() {
        list = new TreeMap<String, Product>();
        observers = new ArrayList();
    }
    
    public Purchase(int consecutive, GregorianCalendar date, Status status, TreeMap<String, Product> list) {
        this.consecutive = consecutive;
        this.date = date;
        this.status = status;
        this.list = list;
    }

    public IStrategy getShipping() {
        return shipping;
    }

    public void setShipping(IStrategy shipping) {
        this.shipping = shipping;
    }
    public void shipping(){
        shipping.shipping(totalWeigth());
    }

    public int getConsecutive() {
        return consecutive;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public TreeMap<String, Product> getList() {
        return list;
    }

    public void setConsecutive(int consecutive) {
        this.consecutive = consecutive;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setList(TreeMap<String, Product> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        String productsText = "";
        Iterator<Product> iterator = list.values().iterator();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy - mm:ss:S");
        Product product;
        while(iterator.hasNext()){
            product = iterator.next();
            productsText += product +", peso unidades: " + product.generalWeigth() + "\n";
        }
        return "Compra #" + consecutive + ", fecha: " + format.format(date.getTime())
                + " Estado: " + status.getDescription().getDescription() + "\n\nLista de productos\n" 
                + productsText + "\nPeso total: " + totalWeigth();
    }
    
    public double totalWeigth(){
        double total = 0;
        Iterator<Product> iterator = list.values().iterator();
        while(iterator.hasNext()){
            total += iterator.next().generalWeigth();
        }
        return total;
    }
    
    public void addProduct(Product product){
        Product temp;
        
        if(list!= null && list.containsKey(product.getCode())){
            temp = list.get(product.getCode());
            temp.setQuantity(temp.getQuantity() + product.getQuantity());
        }else{
            list.put(product.getCode(), product);
        }
    }
    
    public Product removeProduct(String code){
        return list.remove(code);
    }
    
    public boolean updateStatus(){
        boolean temp = this.status.updateStatus();
        notifyObservers();
        return temp;
    }

    @Override
    public int compareTo(Purchase purchase) {
        return status.getDate().compareTo(purchase.status.getDate());
    }    
    
    @Override
    public void addPurchaseObserver(PurchaseObserver observer){
        observers.add(observer);
    }
    
    @Override
    public void removePurchaseObserver(PurchaseObserver observer){
        int i = observers.indexOf(observer);
        if(i >= 0){
            observers.remove(i);
        }
    }
    
    @Override
    public void notifyObservers(){
        Iterator iterator = observers.iterator();
        while(iterator.hasNext()){
            PurchaseObserver observer = (PurchaseObserver) iterator.next();
            observer.update(this.status, this);
        }
    }
    
    @Override
    public void printObservers(){
        Iterator iterator = observers.iterator();
        while(iterator.hasNext()){
            PurchaseObserver observer = (PurchaseObserver) iterator.next();
            if(observer instanceof Buyer){
                observer.printList();
            }
        }
    }

    
}
