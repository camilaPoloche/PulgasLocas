/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 * Modelo que permite representar un hilo de una pulga mutante
 * @author Mariana
 * @since 20250507
 * @version 1.0
*/
public class HiloAnadirPulgaMutante implements Runnable{
     /**
     * instancia de la clase Montana
    */
    private Montana montana;
    
     /**
     * bandera de control para determinar la ejecucion 
    */
    private boolean running = true;

     /**
    * Inicializa los atributos de la clase HiloAnadirPulgaMutante
    * @param montana
    */
    public HiloAnadirPulgaMutante(Montana montana) {
        this.montana = montana;
    }
    
    /**
    * Sobrescribe el metodo run() de la interfaz Runnable
    */
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
