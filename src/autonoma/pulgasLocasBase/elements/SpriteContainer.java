/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgasLocasBase.elements;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Modelo que representa un SpriteContainer
 * @author Camila 
 * @since 20250501
 * @version 1.0
*/
public class SpriteContainer extends Sprite implements GraphicContainer{
    
    protected ArrayList<Sprite> sprites;   

    public SpriteContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        sprites = new ArrayList<Sprite>();
    }   
    
    public boolean add(Sprite sprite){
        return sprites.add(sprite);
    }
    
    public void remove(int index){
        sprites.remove(index);
    }

    public void remove(Sprite sprite){
        sprites.remove(sprite);
    }
    
    public int size(){
        return sprites.size();
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Rectangle getBoundaries() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
}
