/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgasLocasBase.elements;

import java.awt.Graphics;

/**
 * Modelo que representa un SpriteMobile
 * @author Mariana 
 * @since 20250507
 * @version 1.0
*/
public class SpriteMobile extends Sprite {
    //Atributos
    /**
    * Paso con el que avanza
    */
    protected int step;
    
    /**
     * inicializa las coordenadas de la clase SpriteMobile
     * @param x
     * @param y
     * @param height
     * @param width 
     */
    public SpriteMobile(int x, int y, int height, int width) {
        super(x, y, height, width);
    }
    
    /**
     * retorna lo pasos con los que avanza
     * @return step
     */

    public int getStep(){
        return step;
    }

    /**
     * modifica los pasos con los que avanza
     * @param step 
     */
    public void setStep(int step){
        this.step = step;
    }

    /**
     * metodo que pinta el sprite movil como un rectangulo
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
