/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

/**
 *
 * @author Sean
 */
public class ShipmentByBoat implements IStrategy{

    private Purchase purchase;
    @Override
    public void shipping(double totalWeight) {
        double price = (totalWeight + totalWeight* 0.15);
        
        System.out.println("El precio del envio por bote es: "+ price);
    }
    
}
