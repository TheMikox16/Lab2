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
public class BasicShipment implements IShipments{

    @Override
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object) {
        return object;
    }

    @Override
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object) {
        return object;
    }
    
}
