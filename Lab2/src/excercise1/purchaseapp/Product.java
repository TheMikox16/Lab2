/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

/**
 * Objecto producto
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Product {
    
    private String code;
    private int quantity;
    private double weigth;

    public Product() {
    }

    public Product(String code, int quantity, double weigth) {
        this.code = code;
        this.quantity = quantity;
        this.weigth = weigth;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    @Override
    public String toString() {
        return "Producto: Codigo: " + code + ", Cantidad: " + quantity + ", Peso: " + weigth;
    }
    
    public double generalWeigth(){
        return this.weigth * this.quantity;
    }
    
}
