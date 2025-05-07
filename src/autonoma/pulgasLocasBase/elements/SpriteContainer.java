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
 * @author Mariana
 * @since 20250507
 * @version 1.0
*/
public class SpriteContainer extends Sprite implements GraphicContainer{
    //Atributos
    /**
     * arreglo que contiene todos los sprites dentro del contenedor
     */
    protected ArrayList<Sprite> sprites;   

    /**
     * inicializa la clase de contenedor de sprite
     * 
     * @param x 
     * @param y 
     * @param height 
     * @param width 
     */

    public SpriteContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        sprites = new ArrayList<Sprite>();
    }   
    
    /**
     * metodo para agregar un sprite al arreglo
     * 
     * @param sprite 
     * @return true, si se agrego
     */
    public boolean add(Sprite sprite){
        return sprites.add(sprite);
    }
    
    /**
     * metodo para eliminar un sprite del arreglo por su posicion
     * @param index 
     */
    public void remove(int index){
        sprites.remove(index);
    }

    /**
     * metodo para eliminar un sprite especifico
     * @param sprite 
     */
    public void remove(Sprite sprite){
        sprites.remove(sprite);
    }
    
    /**
     * metodo que devuelve la cantidad de sprites 
     * @return 
     */
    public int size(){
        return sprites.size();
    }

    /**
     * metodo requerido por la interfaz
     */
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * metodo requerido por la interfaz
     * @return
     */
    @Override
    public Rectangle getBoundaries() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * metodo para pintar el contenedor como un rectangulo
     * @param g 
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

     /**
     *retorna el arreglo de esprites
     * @return sprites
     */
    public ArrayList<Sprite> getSprites() {
        return sprites;
    }
}
