/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.patterns.ShipmentByPlane;
import excercise1.patterns.ShipmentByBoat;
import excercise1.patterns.IShipments;

/**
 *
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public abstract class ShipmentsDecorator implements IShipments{
    
    protected IShipments decoratorShips;

    public ShipmentsDecorator(IShipments decoratorShips) {
        this.decoratorShips = decoratorShips;
    }
    
    @Override
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object){
        this.decoratorShips.shipmentPlaneDecorator(object);
        return object;
    }
    
    @Override
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object){
        this.decoratorShips.shipmentBoatDecorator(object);
        return object;
    }
}
