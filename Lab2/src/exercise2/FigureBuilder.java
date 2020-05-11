/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.Iterator;

/**
 * Clase que construye la figura que ya ha sido determinada por FigureFactory
 * ademas de validar los diferentes atributos de cada figura.
 * 
 * @author Miguel Angel Egoavil Mathison  Carne: B92695
 * @author Sean Stward Campos Siles       Carne: B91569
 */
public class FigureBuilder implements AbstractBuilder{

    protected Figure figure;
    
    /**
     * Valida la creacion de una figura de diferentes tipos dependiendo de lo
     * conseguido en el FigureFactory
     * 
     * @param inden identacion usada por el composite
     * @param n la opcion de la figura a armar que se ha seleccionado desde
     * el FigureFactory y que es pasado luego al Sheduler para luego llamar
     * este metodo
     */
    @Override
    public void buildFigure(Indentation inden, int n){
        switch(n){
            case 0:
                this.figure = new Circle(inden);
                break;
            case 1:
                this.figure = new Rectangle(inden);
                break;
            case 2:
                this.figure = new MixedFigure(inden);
        }
    }
    
    /**
     * Construye las coordenadas sin importar el tipo de figura
     * 
     * @param n dato de coordenada
     */
    @Override
    public void buildCoordenates(Point point) {
        if(point != null){
            this.figure.setCoordenates(point);
        }
    }

    /**
     * Construye el radio del circulo o altura del rectanguo segun la figura
     * que se ha creado
     * 
     * @param n dato de radio/alto
     */
    @Override
    public void buildSide(int n) {
        if(n > 0){
            if(this.figure instanceof Circle){
                ((Circle) this.figure).setRadius(n);
            }else if(this.figure instanceof Rectangle){
                ((Rectangle) this.figure).setHigh(n);
            }
        }
    }

    /**
     * Construye el alto de un rectangulo. Automaticamente el programa no
     * llama a este metodo si se trata de un circulo. Se pueden colocar mas
     * metodos de este tipo si se implementan mas figuras con mas atributos
     * a construir.
     * 
     * @param n dato de ancho
     */
    @Override
    public void buildSide2(int n) {
        if(n > 0){
            if(this.figure instanceof Rectangle){
                ((Rectangle) this.figure).setWidth(n);
            }
        }
    }
    
    /**
     * Llamado unicamente en caso de figura mixta. Se valida que las figuras
     * que conforman a la figura mixta. Cualquier figura diferente de nulo
     * enviada por parametros se agrega, caso contrario, se omite.
     * 
     * NOTA: no se valida las figuras dentro de la figura mixta debido a que
     * estas ya deberian ser creadas de antemano y/o primero pasan por el
     * proceso de construcion de una figura, por lo que por defecto ya
     * deberian estar validadas al momento de llamar a este metodo con la
     * excepcion de una figura que apunte a nulo
     * 
     * @param figures
     */
    @Override
    public void buildMixed(Figure... figures) {
        for (Figure figure1 : figures) {
            if (figure1 != null) {
                ((MixedFigure) this.figure).addAbs(figure1);
            }
        }
    }

    /**
     * Clase que regresa la figura creada y en donde se realizan las diferentes
     * validaciones de cada atributo que, en caso de que se cumpla una 
     * condicion, se tirara una excepcion personalizada con el error especifico
     * de la figura del caso.
     * @return Figure la figura que se retornara a Scheduler ya validada
     * @throws PersonalizedException una excepcion especificando el error
     * en cuestion de una determinada figura
     */
    @Override
    public Figure getFigure() throws PersonalizedException {
        if(!(this.figure instanceof MixedFigure) 
                && this.figure.getCoordenates() == null){
            throw new PersonalizedException("Coordenadas no validas");
        }
        if(this.figure instanceof Circle){
            if(((Circle) this.figure).getRadius() == 0){
                throw new PersonalizedException("Radio del circulo no valido");
            }else if((this.figure.getCoordenates().getX() + this.figure.getCoordenates().getX()
                    - ((Circle) this.figure).getRadius()) < 0){
                throw new PersonalizedException("Diferencia entre radio y"
                        + " coordenadas ha dado negativo");
            }
        }
        if(this.figure instanceof Rectangle){
            if(((Rectangle) this.figure).getHigh() == 0){
                throw new PersonalizedException("Altura del rectangulo no valido");
            }else if(((Rectangle) this.figure).getWidth() == 0){
                throw new PersonalizedException("Ancho del rectangulo no valido");
            }else if(((Rectangle) this.figure).getHigh() 
                    - ((Rectangle) this.figure).getWidth() < 0){
                throw new PersonalizedException("Error en la diferencia del alto y ancho del rectangulo");
            }else if(this.figure.getCoordenates().getY() 
                    - ((Rectangle) this.figure).getHigh() < 0){
                throw new PersonalizedException("Error en la diferencia entre el alto y coordenadas"
                        + " del rectangulo");
            }else if(this.figure.getCoordenates().getX()
                    -((Rectangle) this.figure).getWidth() < 0){
                throw new PersonalizedException("Error en la diferencia entre el ancho y las coordenadas"
                        + " del rectangulo");
            }
        }
        if(this.figure instanceof MixedFigure){
            int counter = 0;
            Iterator iterator = ((MixedFigure) this.figure).getAbsList().iterator();
            while(iterator.hasNext()){
                if(iterator.next() != null){
                    counter++;
                }
            }
            if(counter < 2){
                throw new PersonalizedException("Una figura mixta debe tener 2 figuras basicas");
            }
        }
        
        return this.figure;
    }

    
    
}
