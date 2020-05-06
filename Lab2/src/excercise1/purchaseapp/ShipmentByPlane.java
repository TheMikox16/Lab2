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


    @Override
    public double shipping(double totalWeight) {
        double price = totalWeight * 30;
        return price;
    }
    
    
}
