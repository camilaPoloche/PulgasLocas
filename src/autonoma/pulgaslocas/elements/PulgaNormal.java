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
public class PulgaNormal extends Pulga{
    
    public PulgaNormal(String path, int indiceVida, int x, int y, int height, int width) {
        super(path, 1, x, y, height, width);
        this.indiceVida = indiceVida;
    }


    @Override
    public void paint(Graphics g) {
        drawImage(g);
    }

    @Override
    public void recibirImpacto() {
        this.indiceVida --;
    }
}
