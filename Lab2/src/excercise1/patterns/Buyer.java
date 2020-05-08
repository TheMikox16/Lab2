/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;
import excercise1.purchaseapp.Status;
import excercise1.purchaseapp.StatusEnum;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Observador comprador que se le notifica cuando se actualiza el estado de una
 * compra y que ademas posee una lista de estos estados
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Buyer implements PurchaseObserver{
    
    private ArrayList<StatusEnum> list = new ArrayList<>();

    /**
     * Añade un estado nuevo a la lista para asi tener las diferentes etapas por
     * la que el mismo ha pasado
     * 
     * @param status el estado actualizado
     * @param purchase
     */
    @Override
    public void update(Status status, Purchase purchase) {
        list.add(status.getDescription());
    }

    /**
     * Imprime la lista de los estados por los que ha pasado la compra
     */
    @Override
    public void printList() {
        String s = "";
        System.out.println("COMPRADOR:\n");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            StatusEnum temp = (StatusEnum) iterator.next();
            s += temp.getDescription() + "\n";
        }
        System.out.println("Historial de estados:\n" + s);
    }

    @Override
    public void addProduct(Integer key, Purchase value) {
    }
    
}
