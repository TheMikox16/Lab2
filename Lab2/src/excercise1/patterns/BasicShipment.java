/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

/**
 *  Clase de envio basico que implementa la interfaz IShipment para ser decorado.
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
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
