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
        Mural mural = new Mural();
 
        try{
            FigureFactory factory = new FigureFactory();
            Figure f1 = factory.createFigure(30, 20);
            System.out.println(f1.toString());
            
            Figure f2 = factory.createFigure(40, 20, 30);
            System.out.println(f2.toString());
            
            Figure f3 = factory.createFigure(f1, f2);
            System.out.println(f3.toString());
            
            mural.add(f1);
            mural.add(f2);
            mural.add(f3);
            System.out.println("Mural numero 1: " + "\nsu codigo hash:" + mural.hash()+
                    mural.print());
            try{
            Mural mural2 = (Mural) mural.clone();
            f1.setCoordenates(45);
            f2.setCoordenates(58);
            System.out.println("Mural numero 2: " + "\nsu codigo hash:" + mural.hash()+
                    mural.print());
           
            System.out.println("Son iguales?"+ (mural == mural2));
            }catch(CloneNotSupportedException ex){
                System.out.println(ex.getMessage());
            }
            
        }catch(PersonalizedException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
