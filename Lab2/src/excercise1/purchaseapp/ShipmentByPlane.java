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
public class ShipmentByPlane implements IStrategy{

    private Purchase purchase;
    @Override
    public void shipping(double totalWeight) {
        double price = totalWeight * 30;
        
        System.out.println("El precio del envio por avion es: "+ price);
    }
    
    
}
