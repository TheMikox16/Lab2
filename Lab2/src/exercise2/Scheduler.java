/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Clase que se enrcarga de llamar a los builder de cada atributo o figura
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class Scheduler {
    
    /**
     * Creacion de figuras por medio de las llamadas al builder de figuras ya 
     * identificadas por el FigureFactory
     * 
     * @param inden identacion
     * @param n opcion de figura a construir, identificado en el factory
     * @param specs los datos de atributos
     * @return figura que proviene del builder y se regresa al factory
     * @throws PersonalizedException excepcion de alguna validacion que se ha
     * incumplido en el builder
     */
    public Figure createFigure(Indentation inden, Point point, int n, int... specs) throws PersonalizedException{
        FigureBuilder builder = new FigureBuilder();
        builder.buildFigure(inden, n);
        if(specs.length == 1){
            builder.buildCoordenates(point);
            builder.buildSide(specs[0]);
            return builder.getFigure();
        }else if(specs.length == 2){
            builder.buildCoordenates(point);
            builder.buildSide(specs[0]);
            builder.buildSide2(specs[1]);
            return builder.getFigure();
        }
        return null;
    }
    
    /**
     * Sobrecarga. Creacion de figuras mixtas por medio de las llamadas al 
     * builder de figuras ya identificadas por el FigureFactory
     * 
     * @param inden identacion
     * @return figura que proviene del builder y se regresa al factory
     * @throws PersonalizedException excepcion de alguna validacion que se ha
     * incumplido en el builder
     */
    public Figure createFigure(Indentation inden, Figure... figures) throws PersonalizedException{
        FigureBuilder builder = new FigureBuilder();
        builder.buildFigure(inden, 2);
        builder.buildMixed(figures);
        return builder.getFigure();
    }
    
}
