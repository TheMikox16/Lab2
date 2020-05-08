/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

/**
 * Interfaz implementada por un envio basico para ser decorados por diferentes
 * adicionales.
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public interface IShipments {
   
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object);
    
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object);
}
