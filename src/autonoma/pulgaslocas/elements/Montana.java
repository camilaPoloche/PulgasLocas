/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.Sprite;
import autonoma.pulgasLocasBase.elements.SpriteContainer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author aleja
 */
public class Montana extends SpriteContainer {
    
    protected PulgaNormal pulga1;
    protected PulgaMutante pulga2;
    
    public Montana(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        pulga1 = new PulgaNormal(1,(width-PulgaNormal.INITIAL_WIDTH)/2, 
                          (height-PulgaNormal.INITIAL_HEIGHT)/2, 
                          PulgaNormal.INITIAL_WIDTH, PulgaNormal.INITIAL_HEIGHT);
        pulga1.setGraphicContainer(this);
        
        
        pulga2 = new PulgaMutante(2,(width-PulgaMutante.INITIAL_WIDTH)/2, 
                          (height-PulgaMutante.INITIAL_HEIGHT)/2, 
                          PulgaMutante.INITIAL_WIDTH, PulgaMutante.INITIAL_HEIGHT);
        pulga2.setGraphicContainer(this);
        
        this.setColor(Color.CYAN);
    }   
    
    private void addPulgaNormal(){
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        PulgaNormal pulga1 = new PulgaNormal(1,x, y, 25, 25);
        
        sprites.add(pulga1);
    }
    
    private void addPulgaMutante(){
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        
        PulgaMutante pulga2 = new PulgaMutante(2,x, y, 25, 25);
        
        sprites.add(pulga2);
    }
    
    public void handleKey(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_P:
                addPulgaNormal();
            break;
            
            case KeyEvent.VK_M:
                addPulgaMutante();
            break;
        }    
    }
    
    @Override
    public void paint(Graphics g) {     
        g.setColor(color);
        g.fillRect(x, y, width, height);

  
        for(Sprite sprite : sprites){
            sprite.paint(g);
        }
    }
    
    @Override
    public void refresh() {
        if(gameContainer != null)
            gameContainer.refresh();
    }

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }
}
