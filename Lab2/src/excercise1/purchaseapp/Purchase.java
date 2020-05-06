/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class Purchase extends StatusComparator implements Comparable<Purchase>{
    
    private int consecutive;
    private GregorianCalendar date;
    private Status status;
    private TreeMap<String, Product> list;

    public Purchase() {
        list = new TreeMap<String, Product>();
    }
    
    public Purchase(int consecutive, GregorianCalendar date, Status status, TreeMap<String, Product> list) {
        this.consecutive = consecutive;
        this.date = date;
        this.status = status;
        this.list = list;
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
                + " Estado: " + status.getDescription() + "\n\nLista de productos\n" 
                + productsText + "\nPeso total: " + totalWeigth() + "\n";
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
        return this.status.updateStatus();
    }

    @Override
    public int compareTo(Purchase purchase) {
        return status.getDate().compareTo(purchase.status.getDate());
    }    
    
    
}
