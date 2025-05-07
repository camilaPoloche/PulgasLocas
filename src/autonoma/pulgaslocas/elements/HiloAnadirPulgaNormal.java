/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 * Modelo que permite representar un hilo de una pulga normal
 * @author Mariana
 * @since 20250507
 * @version 1.0
*/
public class HiloAnadirPulgaNormal extends Thread{
    private Montana montana;
    private boolean running = true;

    public HiloAnadirPulgaNormal(Montana montana) {
        this.montana = montana;
    }
    
    @Override
    public void run() {
        while (running) {
            this.montana.addPulgaNormal();
            try {
                Thread.sleep(5000); 
            } catch (InterruptedException e) {
                
            }
        }
    }
}
