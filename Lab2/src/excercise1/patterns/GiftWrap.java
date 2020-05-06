/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

/**
 *
 * @author Sean
 */
public class GiftWrap extends ShipmentsDecorator{
    
    private String additional = "Envoltura de regalo";
    private double price = 5.0;
    
    public GiftWrap(IShipments decoratorShips) {
        super(decoratorShips);
    }
    
    @Override
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object){
        this.decoratorShips.shipmentPlaneDecorator(object);
        addGiftWrapPlane(object);
        return object;
    }
    
    @Override
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object){
        this.decoratorShips.shipmentBoatDecorator(object);
        addGiftWrapBoat(object);
        return object;
    }
    
    public ShipmentByPlane addGiftWrapPlane(ShipmentByPlane ship){
        ship.setAdditionals(additional);
        ship.setPrice(price);
        return ship;
    }
    
    public ShipmentByBoat addGiftWrapBoat(ShipmentByBoat ship){
        ship.setAdditionals(additional);
        ship.setPrice(price);
        return ship;
    }
    
}
