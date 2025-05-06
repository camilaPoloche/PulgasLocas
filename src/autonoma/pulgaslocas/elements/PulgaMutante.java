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
    
    public PulgaMutante(String path, int indiceVida, int x, int y, int height, int width) {
        super(path, 2, x, y, height, width);
        this.indiceVida = indiceVida;
    }

    @Override
    public void recibirImpacto() {
        this.indiceVida --;
    }
    
    @Override
    public void paint(Graphics g) {
        drawImage(g);
    }
    
    public Pulga transformar(){
        if( this.indiceVida == 1){
            PulgaNormal pulgaN = new PulgaNormal("/autonoma/pulgaslocas/images/pulgaBoba.png", 1, x, y, 15, 15);
            pulgaN.setGraphicContainer(gameContainer);
            return pulgaN;
        }
        return this;
    }
}
