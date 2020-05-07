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
public class Scheduler {
    
    public Figure createFigure(Indentation inden, int n, int... specs) throws PersonalizedException{
        FigureBuilder builder = new FigureBuilder();
        builder.buildFigure(inden, n);
        if(specs.length == 2){
            builder.buildCoordenates(specs[0]);
            builder.buildSide(specs[1]);
            return builder.getFigure();
        }else if(specs.length == 3){
            builder.buildCoordenates(specs[0]);
            builder.buildSide(specs[1]);
            builder.buildSide2(specs[2]);
            return builder.getFigure();
        }
        return null;
    }
    
    public Figure createFigure(Indentation inden, Figure... figures) throws PersonalizedException{
        FigureBuilder builder = new FigureBuilder();
        builder.buildFigure(inden, 2);
        builder.buildMixed(figures);
        return builder.getFigure();
    }
    
}
