/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.main;

import autonoma.pulgaslocas.elements.HiloAnadirPulgaMutante;
import autonoma.pulgaslocas.elements.HiloAnadirPulgaNormal;
import autonoma.pulgaslocas.elements.Montana;
import autonoma.pulgaslocas.gui.GameWindow;

/**
 *
 * @author aleja
 */
public class Main {
    public static void main(String[] args){
        
        Montana montana = new Montana(2, 2, 480, 480);
        
        Thread hilo1 = new Thread(new HiloAnadirPulgaNormal(montana));
        Thread hilo2 = new Thread(new HiloAnadirPulgaMutante(montana));
//        
        GameWindow window = new GameWindow(montana);
        window.setMontana(montana);
        montana.setGraphicContainer(window);
        window.setSize(480, 480);
        window.setTitle("Gnome Game");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        hilo1.start();
        hilo2.start();
    }
}
