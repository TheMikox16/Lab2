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
    public Figure createFigure(Indentation inden, int... specs) throws PersonalizedException{
        Scheduler schedule = new Scheduler();
        if(specs.length == 2){
            return schedule.createFigure(inden, 0, specs);
        }else if(specs.length == 3){
            return schedule.createFigure(inden, 1, specs);
        }
        return null;
    }
        
    @Override
    public Figure createFigure(Indentation inden, Figure... figures) throws PersonalizedException{
        Scheduler schedule = new Scheduler();
        return schedule.createFigure(inden, figures);
    }
    
}
