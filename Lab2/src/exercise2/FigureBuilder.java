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
public class FigureBuilder implements AbstractBuilder{

    protected Figure figure;

    public FigureBuilder(Figure figure) {
        this.figure = figure;
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
    public Figure getFigure() throws PersonalizedException {
        if(this.figure.getCoordenates() == 0){
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
    }
    
}
