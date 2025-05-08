/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;

/**
 * Modelo que permite representar un ArmaMisilPulgoson
 * @author Camila
 * @since 20250506
 * @version 1.0
*/
public class ArmaMisilPulgoson extends Arma{
    //Atributos
    /**
    * Instancia de Montana
    */
    private Montana montana;
    /**
    * Instancia de Sonido
    */
    private Sonido sonido;

    /**
     * Inicializa los atributos de la clase ArmaMisilPulgoson
     * @param montana
    */
    public ArmaMisilPulgoson(Montana montana) {
        this.montana = montana;
        this.sonido = new Sonido();
    }
    
    /**
     * Metodo destruirPulgas
     * @throws IOException
    */
    @Override
    public void destruirPulgas() throws IOException{
        this.sonido.reproducir("misil.wav");
        int destruir = this.montana.getSprites().size() / 2;
        for (int i = 0; i < destruir; i++) {
            this.montana.remove(i);
            int puntajeActual = this.montana.getPuntaje();
            puntajeActual += destruir;
            this.montana.setPuntaje(puntajeActual);
        }
        
        if(this.montana.getSprites().size() == 0){
            this.montana.setAcabado(true);
        }
    }

    /**
     * Metodo destruirPulgas
     * @param  x
     * @param y
     * @throws IOException
    */
    @Override
    public void destruirPulgas(int x, int y) throws IOException{
        
    }
}
