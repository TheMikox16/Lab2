/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Clase con el main que ejcuta el programa
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Main {
    
    public static void main(String[] args){
        Mural mural = new Mural();
        Indentation inden = new Indentation();
        FigureFactory factory = new FigureFactory();
        
        try{
            
            Figure f1 = factory.createFigure(inden, 30, 20);
            
            Figure f2 = factory.createFigure(inden,46, 23, 11);
            
            Figure f3 = factory.createFigure(inden, 60, 40);
            
            Figure f4 = factory.createFigure(inden,70, 38, 20);
            
            Figure f5 = factory.createFigure(inden,80, 40);
            
            Figure f6 = factory.createFigure(inden,75, 64, 45);
            
            Figure f7 = factory.createFigure(inden,f1, f2);
            
            Figure f8 = factory.createFigure(inden,f5, f6);
            
            Figure f9 = factory.createFigure(inden,f3, f4, f8, f7);
            
            Figure f10 = factory.createFigure(inden, f2, f3, f6, f9);
            
            
            mural.add(f1);
            mural.add(f2);
            mural.add(f3);
            mural.add(f4);
            mural.add(f5);
            mural.add(f6);
            mural.add(f7);
            mural.add(f8);
            mural.add(f9);
            mural.add(f10);
            System.out.println("Mural numero 1:\n" + mural.print());
            try{
            Figure clone = mural.clone(0);
            f1.setCoordenates(45);
            
            System.out.println("Figura clonada:\n" + clone.toString()
                + "Original con coordenadas cambiadas:\n" + f1.toString()
                + "\nHash code original: " + f1.hashCode() 
                + ", copia: " + clone.hashCode() + "\n");
            
            f2.setCoordenates(58);
            mural.add(clone);
            System.out.println("Mural numero 2:\n" + mural.print());
           
            System.out.println("Son iguales?"+ (f1 == clone));
            
            }catch(CloneNotSupportedException ex){
                System.out.println(ex.getMessage());
            }
          
        }catch(PersonalizedException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            Figure circleError = factory.createFigure(inden, 1, 100);
        }catch(PersonalizedException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            Figure rectangleError = factory.createFigure(inden, 1, 100, 200);
        }catch(PersonalizedException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            Figure f1 = factory.createFigure(inden, 10, 5);
            Figure mixedError = factory.createFigure(inden, f1);
        }catch(PersonalizedException ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            Figure selectionError = factory.createFigure(inden, 34);
        }catch(PersonalizedException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
