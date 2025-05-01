/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgasLocasBase.elements;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Camila
 */
public class SpriteContainer extends Sprite implements GraphicContainer{
    
    protected ArrayList<Sprite> sprites;   
    
//    public SpriteContainer(int x, int y, int height, int width) {
//        super(x, y, height, width);
//        
//        sprites = new ArrayList<Sprite>();
//    }   

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Rectangle getBoundaries() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
