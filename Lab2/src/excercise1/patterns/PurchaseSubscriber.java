/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public interface PurchaseSubscriber {
    
    public void addPurchaseObserver(PurchaseObserver observer);
    
    public void removePurchaseObserver(PurchaseObserver observer);
    
    public void notifyObservers();
    
}
