/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 *
 * @author Camila
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
            this.montana.addPulgaMutante();
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                
            }
        }
    }
}
