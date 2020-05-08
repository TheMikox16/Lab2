/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

/**
 * Clase encargada de añadir el adicional de envoltura de regalo.
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class GiftWrap extends ShipmentsDecorator{
    
    private String additional = "Envoltura para regalo";
    private int price = 5;
    
    public GiftWrap(IShipments decoratorShips) {
        super(decoratorShips);
    }
    
    /**
    * Metodo de la interfaz grafica usador para implementar la decoracion de los
    * envios por avion. Tambien se encarga de inicializar el metodo encargado de
    * añadir los adicionales al envio.
    * 
    * @param Object maneja el envio por avion.
    */
    @Override
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object){
        this.decoratorShips.shipmentPlaneDecorator(object);
        addGiftWrapPlane(object);
        return object;
    }
    /**
    * Metodo de la interfaz grafica usador para implementar la decoracion de los
    * envios por barco. Tambien se encarga de inicializar el metodo encargado de
    * añadir los adicionales al envio.
    *
    * @param object maneja el envio por Barco
    */
    @Override
    
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object){
        this.decoratorShips.shipmentBoatDecorator(object);
        addGiftWrapBoat(object);
        return object;
    }
    
    /**
     * Metodo encargado de añadir el adicional al envio del avion
     * @param ship objeto de tipo envio por avion
     * @return objeto de tipo envio por avion con los adicionales.
     */
    public ShipmentByPlane addGiftWrapPlane(ShipmentByPlane ship){
        if(ship.getAdditionals() != null){
            ship.setAdditionals(ship.getAdditionals() + ", " + additional);
            ship.setIncrease(price);
        }else{
            ship.setAdditionals( additional);
            ship.setIncrease(price);
        }
        return ship;
    }
    /**
     * Metodo encargado de añadir el adicional al envio del avion
     * @param ship objeto de tipo envio por barco
     * @return objeto de tipo envio por barco con los adicionales.
     */
    public ShipmentByBoat addGiftWrapBoat(ShipmentByBoat ship){
        if(ship.getAdditionals() != null){
            ship.setAdditionals(ship.getAdditionals() + ", " + additional);
            ship.setIncrease(price);
        }else{
            ship.setAdditionals( additional);
            ship.setIncrease(price);
        }
        return ship;
    }
    
}
