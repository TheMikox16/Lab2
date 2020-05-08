/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 * Fabrica que detecta la figura a crear y llama al builder por medio del 
 * Scheduler
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class FigureFactory implements FactoryInterface{

    /**
     * Fabrica una figura determinando el tipo por medio de la cantidad  de
     * parametros enteros. Un int crear un criculo, dos un rectangulo. Este 
     * metodo y su llamado puede ser modificado a conveniencia para validar 
     * una nueva figura.
     * 
     * @param inden identacion usada para el espaciado
     * @param specs cantidad de enteros enviados. A partir de este argumento se 
     * determina
     * @return Figure figura creada proveniente de Scheduler y regresada al main
     * @throws PersonalizedException algun error relacionado con la creacion de
     * figuras
     */
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
        
    /**
     * Sobrecarga de metodo. Hace el mismo procedimiento que el anterior pero
     * a partir de figuras y ya teniendo definido que la figura a crear
     * es mixta sin importar el numero de argumentos.
     * 
     * @param inden identacion usada para el espaciado
     * @param figures cantidad de figuras enviadas.
     * @return Figure figura creada proveniente de Scheduler y regresada al main
     * @throws PersonalizedException algun error relacionado con la creacion de
     * figuras
     */
    @Override
    public Figure createFigure(Indentation inden, Figure... figures) throws PersonalizedException{
        Scheduler schedule = new Scheduler();
        return schedule.createFigure(inden, figures);
    }
    
}
