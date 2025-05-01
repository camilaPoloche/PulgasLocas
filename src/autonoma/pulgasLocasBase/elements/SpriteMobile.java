/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgasLocasBase.elements;

import java.awt.Graphics;

/**
 * Modelo que representa un SpriteMobile
 * @author Camila 
 * @since 20250501
 * @version 1.0
*/
public class SpriteMobile extends Sprite {
    //Atributos
    /**
    * Paso con el que avanza
    */
    protected int step;
    
    public SpriteMobile(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    public int getStep(){
        return step;
    }

    public void setStep(int step){
        this.step = step;
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
