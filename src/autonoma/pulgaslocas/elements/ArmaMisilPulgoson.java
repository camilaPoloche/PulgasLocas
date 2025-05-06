/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;

/**
 *
 * @author aleja
 */
public class ArmaMisilPulgoson extends Arma{
    private Montana montana;

    public ArmaMisilPulgoson(Montana montana) {
        this.montana = montana;
    }
    
    @Override
    public void destruirPulgas() throws IOException{
        int destruir = this.montana.getSprites().size() / 2;
        for (int i = 0; i < destruir; i++) {
            this.montana.remove(0);
            int puntajeActual = this.montana.getPuntaje();
            puntajeActual += destruir;
            this.montana.setPuntaje(puntajeActual);
        }
    }

    @Override
    public void destruirPulgas(int x, int y) throws IOException{
        
    }
}
