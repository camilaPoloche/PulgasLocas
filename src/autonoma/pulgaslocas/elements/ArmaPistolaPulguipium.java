/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.Sprite;
import java.io.IOException;

/**
 * Modelo que permite representar un ArmaPistolaPulguipium
 * @author Camila
 * @since 20250506
 * @version 1.0
*/
public class ArmaPistolaPulguipium extends Arma{
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
     * Inicializa los atributos de la clase ArmaPistolaPulguipium
     * @param montana
    */
    public ArmaPistolaPulguipium(Montana montana) {
        this.montana = montana;
        this.sonido = new Sonido();
    }
    
    /**
     * Metodo destruirPulgas
     * @param x
     * @param y
     * @throws IOException
    */
    @Override
    public void destruirPulgas(int x, int y) throws IOException{
        int rango = 33;  

        for (int i = 0; i < this.montana.getSprites().size(); i++) {
            Sprite p = this.montana.getSprites().get(i);

            if (p instanceof Pulga) {
                int pulgaX = p.getX();
                int pulgaY = p.getY();

                if (Math.abs(pulgaX - x) < rango && Math.abs(pulgaY - y) < rango) {
                    ((Pulga) p).recibirImpacto();
                    this.sonido.reproducir("disparo.wav");
                    
                    if (p instanceof PulgaNormal){
                        int puntajeActual = this.montana.getPuntaje();
                        int puntajeNuevo = puntajeActual += 1;
                        this.montana.setPuntaje(puntajeNuevo);
                    }

                    if (p instanceof PulgaMutante) {
                        Pulga nueva = ((PulgaMutante) p).transformar();
                        this.montana.getSprites().set(i, nueva);
                    } else if (((Pulga) p).getIndiceVida() == 0) {
                        this.montana.remove(i);
                    }
                    break;  
                }
            }
        }
        
        if(this.montana.getSprites().size() == 0){
            this.montana.setAcabado(true);
        }
    }

    /**
     * Metodo destruirPulgas
     * @throws IOException
    */
    @Override
    public void destruirPulgas() throws IOException{
        
    }
}
