/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 *
 * @author Camila
 */
public class HiloAnadirPulgaMutante implements Runnable{
    private Montana montana;
    private boolean running = true;

    public HiloAnadirPulgaMutante(Montana montana) {
        this.montana = montana;
    }
    
    @Override
    public void run() {
        while (running) {
            this.montana.addPulgaMutante();
            try {
                Thread.sleep(9999); 
            } catch (InterruptedException e) {
                
            }
        }
    }
}
