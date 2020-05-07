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
public class GiftCard extends ShipmentsDecorator{
    
    private String additional = "Tarjeta de regalo";
    private double discount;
    private int code;
    
    public GiftCard(IShipments decoratorShips) {
        super(decoratorShips);
    }
    
    @Override
    public ShipmentByPlane shipmentPlaneDecorator(ShipmentByPlane object){
        this.decoratorShips.shipmentPlaneDecorator(object);
        addGiftCardPlane(object);
        return object;
    }
    
    @Override
    public ShipmentByBoat shipmentBoatDecorator(ShipmentByBoat object){
        this.decoratorShips.shipmentBoatDecorator(object);
        addGiftCardBoat(object);
        return object;
    }
    
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
