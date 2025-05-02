/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author aleja
 */
public class PulgaMutante extends Pulga{
    
    public PulgaMutante(int indiceVida, int x, int y, int height, int width) {
        super(2,x, y, height, width);
        this.indiceVida = indiceVida;
        setColor(Color.RED);
    }

    @Override
    public void recibirImpacto() {
        this.indiceVida --;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public Pulga transformar(){
        if( this.indiceVida == 1){
            return new PulgaNormal(1,x, y,15,15);
        }
        return this;
    }
}
