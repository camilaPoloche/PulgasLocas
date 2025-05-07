/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.Sprite;

/**
 * Modelo que permite representar un hilo para mover pulgas
 * @author Mariana
 * @since 20250507
 * @version 1.0
*/
public class HiloMoverPulgas implements Runnable{
    
    /**
     * instancia de la clase Montana
    */
    private Montana montana;
    
    /** 
    * bandera que indica si el hilo se esta ejecutando
    */
    private boolean running;
    
    /** 
    * bandera que indica si el hilo esta temporalmente pausado
    */
    private boolean paused;

    /**
    * Inicializa los atributos de la clase HiloMoverPulgas
    * @param montana
    */
    public HiloMoverPulgas(Montana montana) {
        this.montana = montana;
        running = false;
        paused = false;
    }
    
    /**
    * Sobrescribe el metodo run() de la interfaz Runnable
    */
    @Override
    public void run() {
        running = true;
        
        while(isRunning())
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
            
            if(isPaused())
                continue;
            
            for (Sprite sprite : this.montana.getCopiaSprites()) {
                if (sprite instanceof Pulga) {
                    ((Pulga) sprite).move();
                }
            }
        }
    }
    
    /**
     * Retorna el estado de ejecucion
     * @return running
    */
     public boolean isRunning() {
        return running;
    }

    /**
    * detiene la ejecucion del hilo
    */
    public void stop() {
        this.running = false;
    }

    /**
     * retorna si el hilo esta en pausa
     * @return paused
     */
    public boolean isPaused() {
        return paused;
    }

    /**
    * Pausa la ejecucion del hilo
    */
    public void pause() {
        this.paused = true;
    }

     /**
     * Reanuda la ejecucion del hilo
     */
    public void unpause() {
        this.paused = false;
    }
}
