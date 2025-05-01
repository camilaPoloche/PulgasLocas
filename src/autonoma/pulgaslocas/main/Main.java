/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.main;

import autonoma.pulgaslocas.elements.Montana;
import autonoma.pulgaslocas.gui.GameWindow;

/**
 *
 * @author aleja
 */
public class Main {
    public static void main(String[] args){
        
        Montana montana = new Montana(0, 0, 500, 500);
        
        GameWindow window = new GameWindow(montana);
        window.setMontana(montana);
        montana.setGraphicContainer(window);
        window.setSize(500, 500);
        window.setTitle("Gnome Game");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    
}
