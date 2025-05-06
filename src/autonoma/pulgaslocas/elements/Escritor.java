/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aleja
 */
public interface Escritor {
    /**
     * Escribe el archivo de memoria interna por lineas
     * 
     * @param archivo
     * @throws java.io.IOException si el archivo no existe
    */
    public abstract void escribir(String archivo) throws IOException ;
    
}
