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
public class FigureFactory implements FactoryInterface{

    @Override
    public Figure createFigure(int... specs) {
        if(specs.length == 2){
            //return new Cicle();
        }else if(specs.length == 3){
            //return new Rectangle();
        }else{
            //return new Abstract();
        }
        
    }
    
}
