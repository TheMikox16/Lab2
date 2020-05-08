/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;
import excercise1.purchaseapp.Status;
import excercise1.purchaseapp.StatusEnum;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Observador empleado de bodega que contiene una lista de todos los productos
 * (solo su consecutivo y estado) de la lista de compras en procesamiento
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class WarehouseStaff implements PurchaseObserver{
    
    private TreeMap<Integer, Purchase> list = new TreeMap<>();

    /**
     * Actualiza la lista cuando a un producto se le actualiza su estado. En el
     * caso de que el producto este en ENTREGADO se saca de la lista
     * 
     * @param status estado actualizado
     * @param purchase compra actualizada
     */
    @Override
    public void update(Status status, Purchase purchase) {
        Iterator iterator = list.values().iterator();
        while(iterator.hasNext()){
            Purchase temp = (Purchase) iterator.next();
            if(temp != null && temp.getStatus().getDescription() == StatusEnum.DELIVERED
                    && this.list != null){
                this.list.remove(purchase.getConsecutive());
                return;
            }else if(temp == purchase){
                temp.setStatus(status);
                return;
            }
        }
    }
    
    /**
     * Imprime la lista de comrpas
     */
    @Override
    public void printList() {
        String s = "";
        System.out.println("ENCARGADO DE BODEGA:\n");
        Iterator keys = this.list.keySet().iterator();
        Iterator values = this.list.values().iterator();
        while(keys.hasNext() & values.hasNext()){
            Purchase temp = (Purchase) values.next();
            s += keys.next() + " - " + temp.getStatus().getDescription().getDescription() + "\n";
        }
        System.out.println("Lista de Bodega:\n" + s);
    }

    /**
     * Añade un producto a la lista
     * 
     * @param key consecutivo a agregar
     * @param value producto
     */
    @Override
    public void addProduct(Integer key, Purchase value) {
        list.put(key, value);
    }
    
}
