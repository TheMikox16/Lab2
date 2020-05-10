/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import excercise1.patterns.BasicShipment;
import excercise1.patterns.Buyer;
import excercise1.patterns.FragilWrap;
import excercise1.patterns.GiftCard;
import excercise1.patterns.GiftWrap;
import excercise1.patterns.IShipments;
import excercise1.patterns.ShipmentByBoat;
import excercise1.patterns.ShipmentByPlane;
import excercise1.patterns.WarehouseStaff;
import excercise1.purchaseapp.DeliveredList;
import excercise1.purchaseapp.ProcessingList;
import excercise1.purchaseapp.Product;
import excercise1.purchaseapp.Purchase;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Main {
    
    public static DeliveredList delivered = DeliveredList.getInstance();
    public static ProcessingList processing = ProcessingList.getInstance();
    
    public static void main(String[] args){
        try{
         
        WarehouseStaff staff = new WarehouseStaff();    
        
        processing.addPurchaseObserver(staff);
        
        Purchase p1 = new Purchase();
        p1.addPurchaseObserver(new Buyer());
        p1.addPurchaseObserver(staff);
        
        p1.addProduct(new Product("123", 2, 2.6));
        p1.addProduct(new Product("123", 4, 3.6));
        p1.addProduct(new Product("321", 4, 9.0));
        p1.addProduct(new Product("213", 1, 5.7));
        p1.addProduct(new Product("111", 5, 0.7));
        
        p1.removeProduct("111");
        
        p1.setShipping(new ShipmentByPlane());
        ShipmentByPlane shipmentPlane = new ShipmentByPlane();
        IShipments ship = new BasicShipment();
        IShipments giftDecorator = new FragilWrap(ship);
        IShipments giftDecorator1 = new GiftCard(ship);
        giftDecorator.shipmentPlaneDecorator(shipmentPlane);
        giftDecorator1.shipmentPlaneDecorator(shipmentPlane);
                
        Purchase p2 = new Purchase();
        p2.addPurchaseObserver(new Buyer());
        p2.addPurchaseObserver(staff);
        
        p2.addProduct(new Product("456", 3, 4.6));
        p2.addProduct(new Product("432", 2, 7.6));
        p2.addProduct(new Product("456", 6, 10.1));
        p2.addProduct(new Product("654", 3, 1.2));
        
        p2.setShipping(new ShipmentByBoat());
        ShipmentByBoat shipmentBoat = new ShipmentByBoat();
        ship = new BasicShipment();
        giftDecorator = new GiftWrap(ship);
        giftDecorator1 = new GiftCard(ship);
        giftDecorator.shipmentBoatDecorator(shipmentBoat);
        giftDecorator1.shipmentBoatDecorator(shipmentBoat);
                
        Purchase p3 = new Purchase();
        p3.addPurchaseObserver(new Buyer());
        p3.addPurchaseObserver(staff);
        
        p3.addProduct(new Product("678", 2, 3.5));
        p3.addProduct(new Product("876", 9, 1.3));
        p3.addProduct(new Product("867", 7, 9.4));
        p3.addProduct(new Product("866", 2, 8.7));
        
        p3.setShipping(new ShipmentByBoat());
        shipmentBoat = new ShipmentByBoat();
        ship = new BasicShipment();
        giftDecorator = new GiftWrap(ship);
        giftDecorator1 = new FragilWrap(ship);
        giftDecorator.shipmentBoatDecorator(shipmentBoat);
        giftDecorator1.shipmentBoatDecorator(shipmentBoat);
        
        Purchase p4 = new Purchase();
        p4.addPurchaseObserver(new Buyer());
        p4.addPurchaseObserver(staff);
        
        p4.addProduct(new Product("456", 3, 4.6));
        p4.addProduct(new Product("876", 9, 1.3));
        p4.addProduct(new Product("321", 4, 9.0));
        p4.addProduct(new Product("123", 2, 2.6));
        
        p4.setShipping(new ShipmentByPlane());
        shipmentPlane = new ShipmentByPlane();
        ship = new BasicShipment();
        giftDecorator = new FragilWrap(ship);
        giftDecorator1 = new GiftCard(ship);
        IShipments giftDecorator2 = new GiftWrap(ship);
        giftDecorator.shipmentPlaneDecorator(shipmentPlane);
        giftDecorator1.shipmentPlaneDecorator(shipmentPlane);
        giftDecorator2.shipmentPlaneDecorator(shipmentPlane);
        
        processing.addPurchase(p2);
        Thread.sleep(200);
        processing.addPurchase(p1);
        Thread.sleep(200);
        processing.addPurchase(p4);
        Thread.sleep(200);
        processing.addPurchase(p3);
        
        System.out.println("Lista por codigo:\n" 
                + processing.purchasesByCode());
        
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(1);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(2);
        Thread.sleep(100);
        processing.updateStatus(3);
        Thread.sleep(100);
        processing.updateStatus(3);
        Thread.sleep(100);
        processing.updateStatus(4);
        Thread.sleep(100);
        
        System.out.println("Lista por estatus\n" 
                + processing.purchasesByStatus());
        
        System.out.println("Lista de entregados por status:\n\n" 
                + delivered.purchasesByStatusDate());
        
        System.out.println("Compra 1:\n");
        p1.printObservers();
        System.out.println("Compra 4:\n");
        p4.printObservers();
      
        processing.printObservers();  
        
        System.out.print("Detalles envio compra 1:\n");
        shipmentPlane.print(p1);
        p1.shipping();

        System.out.print("\n\nDetalles envio compra 2:\n");
        shipmentBoat.print(p2);
        p2.shipping();
        
        System.out.print("\n\nDetalles envio compra 3:\n");
        shipmentBoat.print(p3);
        p3.shipping();
        
        System.out.print("\n\nDetalles envio compra 4:\n");
        shipmentPlane.print(p4);
        p4.shipping();
        
        }catch (InterruptedException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
