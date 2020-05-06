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
public class ShipmentByBoat implements IStrategy{

    
    private String additionals;
    private double price;
    private int code;

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
        double totalPrice;
        if(additionals != null){
            System.out.println("Hay adicionales al envio: " + additionals);
            if(additionals.equalsIgnoreCase("Envoltura para regalo")){
                totalPrice = (totalWeight + (totalWeight* 0.15)) + price;
                System.out.println ("\nEl precio total del envio con los adicionales es: " + totalPrice);
            }else if(additionals.equalsIgnoreCase("Tarjeta de regalo")){
                totalPrice = (totalWeight + (totalWeight* 0.15)) - ((totalWeight + (totalWeight* 0.15)) * (price / 100));
                System.out.println ("\nEl precio total del envio con los adicionales es: " + totalPrice +
                        "\nY el codigo de tarjeta de descuento es: " + code);
            }else if(additionals.equalsIgnoreCase("Envoltura adicional por fragil")){
                totalPrice = (totalWeight + (totalWeight* 0.15)) + ((totalWeight + (totalWeight* 0.15)) * price /100);
                System.out.println ("\nEl precio total del envio con los adicionales es: " + totalPrice);
            }
        }else{
            totalPrice = (totalWeight + (totalWeight* 0.15));
            System.out.println("El precio del envio por avion es: " + totalPrice);
        }
        
    }
    
}
