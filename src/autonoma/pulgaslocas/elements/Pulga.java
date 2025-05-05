/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.Sprite;
import java.awt.Color;
/**
 *
 * @author Camila
 */

public abstract class Pulga  extends Sprite{
    
    protected int indiceVida;
    public static final int INITIAL_WIDTH = 50;
    public static final int INITIAL_HEIGHT = 50;
    public static final int GROW_SIZE = 4;
    
    protected int step = 5;     

    public Pulga(int indiceVida, int x, int y, int height, int width) {
        super(x, y, height, width);
        this.indiceVida = indiceVida;
        setColor(Color.BLUE);
    }
  
    public void saltar(int width,int height){
        x = (int)(Math.random()*(width - 50));
        y = (int)(Math.random()*(height - 50));
    }
    
    public abstract void recibirImpacto () ;
    
    public int getIndiceVida() {
        return indiceVida;
    }

    public void setIndiceVida(int indiceVida) {
        this.indiceVida = indiceVida;
    }
    
    public boolean estaMuerta() {
        if (this.indiceVida == 0){
            return true;
        }
        return false;
    }
    
    public boolean move(){
        int direction = (int)(Math.random() * 4);
        
        int nx = x;
        int ny = y;
        
        switch(direction){
            case 0: 
                ny -= step;
            break;

            case 1:     
                ny += step;
            break;

            case 2:     
                nx -= step;
            break;

            case 3:   
                nx += step;
            break;
        }
        
        if(!isOutOfGraphicContainer(nx, ny, width, height)){
            x = nx;
            y = ny;

            if(gameContainer != null)
                gameContainer.refresh();
            
            return true;
        }
        return false;
    }
}

