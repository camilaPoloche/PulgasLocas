/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.main;

import autonoma.pulgaslocas.elements.HiloAnadirPulgaMutante;
import autonoma.pulgaslocas.elements.HiloAnadirPulgaNormal;
import autonoma.pulgaslocas.elements.HiloMoverPulgas;
import autonoma.pulgaslocas.elements.Montana;
import autonoma.pulgaslocas.gui.GameWindow;

/**
 * Clase principal inicializa los elementos principales del juego: 
 * la montaña, las ventanas gráficas y los hilos que controlan el comportamiento de las pulgas.
 * 
 * @author Alejandro
 * @since 20250507
 * @version 1.0
 */

public class Main {
    public static void main(String[] args){
        // Se crea una instancia de la montaña 
        Montana montana = new Montana(2, 2, 480, 480);
        
        // Se crean los hilos que agregan y mueven las pulgas
        Thread hilo1 = new Thread(new HiloAnadirPulgaNormal(montana));
        Thread hilo2 = new Thread(new HiloAnadirPulgaMutante(montana));
        Thread hilo3 = new Thread(new HiloMoverPulgas(montana));
        
        // Se crea la ventana grafica del juego
        GameWindow window = new GameWindow(montana);
        window.setMontana(montana);
        montana.setGraphicContainer(window);
        window.setSize(480, 480);
        window.setTitle("Pulgas locas");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
