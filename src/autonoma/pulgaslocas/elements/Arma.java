/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;

/**
 * Modelo que permite representar un Arma como clase abstracta
 * @author Camila
 * @since 20250506
 * @version 1.0
*/
public abstract class Arma {
    /**
     * Metodo abstracto destruirPulgas
     * @param  x
     * @param y
     * @throws IOException
    */
    public abstract void destruirPulgas(int x, int y) throws IOException;
    
    /**
     * Metodo abstracto destruirPulgas
     * @throws IOException
    */
    public abstract void destruirPulgas() throws IOException;
}
