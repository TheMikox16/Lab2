/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.patterns;

import excercise1.purchaseapp.Purchase;

/**
 *
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class ShipmentByBoat implements IStrategy{

    
    private String additionals;
    private double price;
    private int code;
    private double totalPrice;
    private double discount;
    private int increase;
    private int tax;

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getIncrease() {
        return increase;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double dicount) {
        this.discount = dicount;
    }
    
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
            totalPrice = (totalWeight + (totalWeight* 0.15));
            System.out.println("El precio del envio por avion es: " + totalPrice); 
    }
    
    public void print(Purchase pur){
        if(getAdditionals() != null){
            System.out.println("Hay adicionales al envio: " +  getAdditionals() );
            if(increase == 5){
                price = getPrice();
                price = (pur.totalWeigth() * 30) + getIncrease();
                System.out.println ("El precio total del envio con envoltura de regalo es " + (int)price);
                setPrice(price);
            } 
            if(tax == 1){
                price = getPrice();
                price = (pur.totalWeigth() * 30) + ((pur.totalWeigth() * 30) * getTax() /100);
                System.out.println ("El precio total del envio con envoltura para fragil es : " + (int)price);
                setPrice(price);
            }
            
            if(getDiscount() != 0){
                price = getPrice();
                price = (pur.totalWeigth() * 30) - ((pur.totalWeigth() * 30) * (getDiscount() / 100));
                System.out.println ("El precio total con el descuento de tarjeta de regalo es: " + (int)price +
                        "\nEl codigo de tarjeta de descuento es: " + code +
                        "\nEl porcentaje de descuento es: " +(int) getDiscount());
                setPrice(price);
            }
        } 
    }
}
