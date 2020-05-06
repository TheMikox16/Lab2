/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.Iterator;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class FigureBuilder implements AbstractBuilder{

    protected Figure figure;
    
    @Override
    public void buildFigure(int n){
        switch(n){
            case 0:
                this.figure = new Circle();
                break;
            case 1:
                this.figure = new Rectangle();
                break;
            case 2:
                this.figure = new MixedFigure();
        }
    }
    
    @Override
    public void buildCoordenates(int n) {
        if(n > 0){
            this.figure.setCoordenates(n);
        }
    }

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

    @Override
    public void buildSide2(int n) {
        if(n > 0){
            if(this.figure instanceof Rectangle){
                ((Rectangle) this.figure).setWidth(n);
            }
        }
    }
    
    @Override
    public void buildMixed(Figure... figures) {
        for(int i = 0; i < figures.length; i++){
            if(figures[i] != null){
                ((MixedFigure) this.figure).addAbs(figures[i]);
            }
        }
    }

    @Override
    public Figure getFigure() throws PersonalizedException {
        if(!(this.figure instanceof MixedFigure) 
                && this.figure.getCoordenates() == 0){
            throw new PersonalizedException("Coordenadas no validas");
        }
        if(this.figure instanceof Circle){
            if(((Circle) this.figure).getRadius() == 0){
                throw new PersonalizedException("Radio del circulo no valido");
            }else if((this.figure.getCoordenates() 
                    - ((Circle) this.figure).getRadius()) < 0){
                throw new PersonalizedException("Diferencia entre radio y"
                        + "coordenadas ha dado negativo");
            }
        }
        if(this.figure instanceof Rectangle){
            if(((Rectangle) this.figure).getHigh() == 0){
                throw new PersonalizedException("Altura del rectangulo no valido");
            }else if(((Rectangle) this.figure).getWidth() == 0){
                throw new PersonalizedException("Ancho del rectangulo no valido");
            }else if(((Rectangle) this.figure).getHigh() - ((Rectangle) this.figure).getWidth() > 0
                    && ((Rectangle) this.figure).getHigh() - this.figure.getCoordenates() > 0
                    && ((Rectangle) this.figure).getWidth() - this.figure.getCoordenates() > 0){
                throw new PersonalizedException("");
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
