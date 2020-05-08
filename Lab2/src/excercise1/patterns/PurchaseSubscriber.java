/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;


/**
 * Interfaz que deben implementar todas las clases que poseean observadores
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public interface PurchaseSubscriber {
    
    public void addPurchaseObserver(PurchaseObserver observer);
    
    public void removePurchaseObserver(PurchaseObserver observer);
    
    public void printObservers();
    
    public void notifyObservers();
    
}
