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
  
    public abstract void saltar();

    public int getIndiceVida() {
        return indiceVida;
    }

    public void setIndiceVida(int indiceVida) {
        this.indiceVida = indiceVida;
    }
}

