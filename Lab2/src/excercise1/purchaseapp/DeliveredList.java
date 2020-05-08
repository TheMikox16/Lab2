/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Clase de la lista de entregados. Solo puede haber una clase de la misma en 
 * todo el programa (singleton)
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class DeliveredList {
    
    private TreeSet<Purchase> list;
    private static DeliveredList instance = new DeliveredList();
    
    /**
     * Constructor privado para evitar otras instancias de la clase
     */
    private DeliveredList() {
        this.list = new TreeSet<Purchase>();
    }
    
    /**
     * Metodo que crea/regresa la unica instancia de la lista 
     * 
     * @return DeliveredList la instancia
     */
    public static DeliveredList getInstance(){
        if(instance == null){
            instance = new DeliveredList();
        }
        return instance;
    }
    
    /**
     * Añade una compra a la lista
     * 
     * @param purchase compra a añadir
     */
    public void addPurchase(Purchase purchase){
        this.list.add(purchase);
    }
    
    /**
     * Imprime las compras por fecha de estatus
     * 
     * @return String con la lista
     */
    public String purchasesByStatusDate(){
        String s = "";
        Iterator iterator = this.list.iterator();
        while(iterator.hasNext()){
            s += iterator.next().toString() + "\n";
        }
        return s;
    }
    
}
