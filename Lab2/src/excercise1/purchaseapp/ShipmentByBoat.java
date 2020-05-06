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


    @Override
    public double shipping(double totalWeight) {
        double price = (totalWeight + totalWeight* 0.15);
        return price;
    }
    
}
