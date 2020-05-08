/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

/**
 * Clase abstracta que es el decorador e implementa los metodos de la intefaz
 * IShipments
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public abstract class ShipmentsDecorator implements IShipments{
    
    protected IShipments decoratorShips;

    public ShipmentsDecorator(IShipments decoratorShips) {
        this.decoratorShips = decoratorShips;
    }
    
    /**
    * Metodo de la interfaz grafica usador para implementar la decoracion de los
    * envios por avion.
    * 
    * @param object maneja el envio por avion
    */
    @Override
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object){
        this.decoratorShips.shipmentPlaneDecorator(object);
        return object;
    }
    
    /**
    * Metodo de la interfaz grafica usador para implementar la decoracion de los
    * envios por barco
    * 
    * @param object maneja el envio por Barco
    */
    @Override
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object){
        this.decoratorShips.shipmentBoatDecorator(object);
        return object;
    }
}
