/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

/**
 *
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class GiftWrap extends ShipmentsDecorator{
    
    private String additional = "Envoltura para regalo";
    private int price = 5;
    
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
        if(ship.getAdditionals() != null){
            ship.setAdditionals(ship.getAdditionals() + ", " + additional);
            ship.setIncrease(price);
        }else{
            ship.setAdditionals( additional);
            ship.setIncrease(price);
        }
        return ship;
    }
    
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
