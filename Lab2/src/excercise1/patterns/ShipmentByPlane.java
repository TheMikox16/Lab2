/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.patterns.IStrategy;
import excercise1.purchaseapp.Purchase;



/**
 *
 * @author Sean
 */
public class ShipmentByPlane implements IStrategy{

    private String additionals;
    private double price;
    private int code;
    private Purchase pur;
    private double totalPrice;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAdditionals() {
        return additionals;
    }

    public void setAdditionals(String additionals) {
        this.additionals = additionals;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public void shipping(double totalWeight) {
            totalPrice = (totalWeight * 30);
            System.out.println("El precio del envio por avion es: " + totalPrice);
        }
        
    
    public void print(){
        if(getAdditionals() != null){
            System.out.println("Hay adicionales al envio: " + getAdditionals());
            if(getAdditionals().equalsIgnoreCase("Envoltura para regalo")){
                totalPrice = (pur.totalWeigth() * 30) + getPrice();
                System.out.println ("\nEl precio total del envio con los adicionales es: " + totalPrice);
            }else if(getAdditionals().equalsIgnoreCase("Tarjeta de regalo")){
                totalPrice = (pur.totalWeigth() * 30) - ((pur.totalWeigth() * 30) * (getPrice() / 100));
                System.out.println ("\nEl precio total del envio con los adicionales es: " + totalPrice +
                        "\nY el codigo de tarjeta de descuento es: " + code);
            }else if(getAdditionals().equalsIgnoreCase("Envoltura adicional por fragil")){
                totalPrice = (pur.totalWeigth() * 30) + ((pur.totalWeigth() * 30) * getPrice() /100);
                System.out.println ("\nEl precio total del envio con los adicionales es: " + totalPrice);
            }else{
                System.out.println("El envio no tiene adicionales"); 
            }
        }
    }
    
}
