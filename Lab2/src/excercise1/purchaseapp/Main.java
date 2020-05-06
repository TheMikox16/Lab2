/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class Main {
    
    public static DeliveredList delivered = new DeliveredList();
    public static ProcessingList processing = new ProcessingList();
    
    public static void main(String[] args){
        try{
        Purchase p1 = new Purchase();
        p1.addProduct(new Product("123", 2, 2.6));
        p1.addProduct(new Product("123", 4, 3.6));
        p1.addProduct(new Product("321", 4, 9.0));
        p1.addProduct(new Product("213", 1, 5.7));
        p1.addProduct(new Product("111", 5, 0.7));
        
        p1.removeProduct("111");
                
        Purchase p2 = new Purchase();
        p2.addProduct(new Product("456", 3, 4.6));
        p2.addProduct(new Product("432", 2, 7.6));
        p2.addProduct(new Product("456", 6, 10.1));
        p2.addProduct(new Product("654", 3, 1.2));
                
        Purchase p3 = new Purchase();
        p3.addProduct(new Product("678", 2, 3.5));
        p3.addProduct(new Product("876", 9, 1.3));
        p3.addProduct(new Product("867", 7, 9.4));
        p3.addProduct(new Product("866", 2, 8.7));
        
        Purchase p4 = new Purchase();
        p4.addProduct(new Product("456", 3, 4.6));
        p4.addProduct(new Product("876", 9, 1.3));
        p4.addProduct(new Product("321", 4, 9.0));
        p4.addProduct(new Product("123", 2, 2.6));
        
        processing.addPurchase(p2);
        Thread.sleep(200);
        processing.addPurchase(p1);
        Thread.sleep(200);
        processing.addPurchase(p4);
        Thread.sleep(200);
        processing.addPurchase(p3);
        
        System.out.println("Lista por codigo:\n" 
                + processing.purchasesByCode());
        
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(3);
        Thread.sleep(100);
        processing.updateStatus(3);
        Thread.sleep(100);
        processing.updateStatus(4);
        Thread.sleep(100);
        
        System.out.println("Lista por estatus\n" 
                + processing.purchasesByStatus());
        
        System.out.println("Lista de entregados por status:\n\n" 
                + delivered.purchasesByStatusDate());
        
        }catch (InterruptedException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}