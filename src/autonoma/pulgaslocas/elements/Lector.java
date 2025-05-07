/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Modelo que permite representar un lector
 * @author Mariana
 * @since 20250507
 * @version 1.0
*/
public interface Lector {
    /**
     * Lee el archivo
     * @param localizacionArchivo
     * @return
     * @throws IOException 
    */
    public abstract String leer(String localizacionArchivo) throws IOException;
}
