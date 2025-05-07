/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Modelo que permite representar la lectura de un archivo
 * @author Mariana
 * @since 20250507
 * @version 1.0
*/
public class LectorArchivoTextoPlano implements Lector{
    /**
     * Archivo de la configuracion
    */
    private String archivo;
    /**
     * Charset en el cual se desea leer el archivo
    */
    private Charset charset = Charset.forName("UTF-8");

    /**
     * Inicializa las variables de la clase Taller
     */
    public LectorArchivoTextoPlano(){

    }
    
    /**
     * Lee el archivo de texto dónde tenemos el programa que deseamos interpretar
     *
     * @param localizacionArchivo ruta del archivo
     * @return arreglo con el archivo de texto
     * @throws IOException: si el archivo no existe
     */
    
    public String leer(String localizacionArchivo) throws IOException {
        File file = new File(localizacionArchivo);
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        StringBuilder contenido = new StringBuilder();
        String linea;
        while ((linea = buffer.readLine()) != null) {
            contenido.append(linea); 
        }

        buffer.close();
        reader.close();

        this.archivo = contenido.toString().trim();
        return this.archivo;
    }

    public String getConfiguracionVehiculo() {
        return archivo;
    }
}
