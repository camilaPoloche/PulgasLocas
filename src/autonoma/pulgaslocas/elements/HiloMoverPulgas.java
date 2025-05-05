/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.Sprite;

/**
 *
 * @author Camila
 */
public class HiloMoverPulgas implements Runnable{
    private Montana montana;
    private boolean running;
    private boolean paused;

    public HiloMoverPulgas(Montana montana) {
        this.montana = montana;
        running = false;
        paused = false;
    }
    
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
            
            for (Sprite sprite : this.montana.getSprites()) {
                if (sprite instanceof Pulga) {
                    ((Pulga) sprite).move();
                }
            }
        }
    }
    
     public boolean isRunning() {
        return running;
    }

    public void stop() {
        this.running = false;
    }

    public boolean isPaused() {
        return paused;
    }

    public void pause() {
        this.paused = true;
    }

    public void unpause() {
        this.paused = false;
    }
}
