/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

/**
 * Clase que maneja la descripcion de un estado o el estado actual de un producto 
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public enum StatusEnum {
    
    DELIVERED("Entregado", null),
    IN_TRANSIT("En tránsito", DELIVERED),
    DISPATCH_WAITING("En espera para ser despachado", IN_TRANSIT),
    PROCESSING("En procesamiento", DISPATCH_WAITING),
    PROCESS_WAITING("En espera de ser procesado", PROCESSING);
    
    private final String description;
    private final StatusEnum next;
    
    private StatusEnum(String description, StatusEnum next){
        this.description = description;
        this.next = next;
    }

    public String getDescription() {
        return description;
    }

    public StatusEnum getNext() {
        return next;
    }
    
    public boolean hasNext(){
        return next != null;
    }
    
}
