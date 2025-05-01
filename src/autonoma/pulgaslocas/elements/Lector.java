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
public interface Lector {
    
    public abstract ArrayList<String> leer(String localizacionArchivo) throws IOException;
}
