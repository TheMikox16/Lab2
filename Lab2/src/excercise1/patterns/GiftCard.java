/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

/**
 * Clase encargada de añadir el adicional de Tarjeta de regalo que puede
 * aplicar descuentos
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class GiftCard extends ShipmentsDecorator{
    
    private String additional = "Tarjeta de regalo";
    private double discount;
    private int code;
    
    public GiftCard(IShipments decoratorShips) {
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
        addGiftCardPlane(object);
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
        addGiftCardBoat(object);
        return object;
    }
    /**
     * Metodo encargado de añadir el adicional al envio del avion
     * @param ship objeto de tipo envio por avion
     * @return objeto de tipo envio por avion con los adicionales.
     */
    public ShipmentByPlane addGiftCardPlane(ShipmentByPlane ship){
        discount = (double) (Math.random()*100 + 1);
        code = (int) (Math.random()* 100000 + 1000);
        if(ship.getAdditionals() != null){
            ship.setAdditionals(ship.getAdditionals() + ", " + additional);
            ship.setCode(code);
            ship.setDiscount(discount);
        }else{
            ship.setAdditionals( additional);
            ship.setDiscount(discount);
            ship.setCode(code);
        }
        return ship;
    }
    /**
     * Metodo encargado de añadir el adicional al envio del avion
     * @param ship objeto de tipo envio por barco
     * @return objeto de tipo envio por barco con los adicionales.
     */
    public ShipmentByBoat addGiftCardBoat(ShipmentByBoat ship){
        discount = Math.random()*100 + 1;
        code = (int)Math.random()* 100000 + 1000;
        if(ship.getAdditionals() != null){
            ship.setAdditionals(ship.getAdditionals() + ", " + additional);
            ship.setCode(code);
            ship.setDiscount(discount);
        }else{
            ship.setAdditionals( additional);
            ship.setDiscount(discount);
            ship.setCode(code);
        }
        return ship;
    }
    
}
