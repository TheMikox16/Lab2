/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class Main {
    
    public static void main(String[] args){
        try{
            FigureFactory factory = new FigureFactory();
            Figure f1 = factory.createFigure(30, 20);
            System.out.println(f1.toString());
            
            Figure f2 = factory.createFigure(40, 20, 30);
            System.out.println(f2.toString());
            
            Figure f3 = factory.createFigure(f1, f2);
            System.out.println(f3.toString());
        }catch(PersonalizedException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
