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
public class FragilWrap extends ShipmentsDecorator{
    
    private String additional = "Envoltura adicional por fragil";
    private double price = 1.0;
    
    public FragilWrap(IShipments decoratorShips) {
        super(decoratorShips);
    }
    
    @Override
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object){
        this.decoratorShips.shipmentPlaneDecorator(object);
        addFragilWrapPlane(object);
        return object;
    }
    
    @Override
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object){
        this.decoratorShips.shipmentBoatDecorator(object);
        addFragilWrapBoat(object);
        return object;
    }
    
    public ShipmentByPlane addFragilWrapPlane(ShipmentByPlane ship){
        ship.setAdditionals(additional);
        ship.setPrice(price);
        return ship;
    }
    
    public ShipmentByBoat addFragilWrapBoat(ShipmentByBoat ship){
        ship.setAdditionals(additional);
        ship.setPrice(price);
        return ship;
    }
    
}
