/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;
import excercise1.purchaseapp.Status;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public interface PurchaseObserver {
    
    public abstract void update(Status status, Purchase purchase);
    
    public void addProduct(Integer key, Purchase value);
    
    public abstract void printList();
    
}
