/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que representa una pulga normal en el juego.
 * Hereda de la clase Pulga y define su comportamiento basico frente a impactos.
 * Esta pulga tiene un indice de vida inicial de 1.
 * @author Alejandro
 * @since 20250507
 * @version 1.0
 */
public class PulgaNormal extends Pulga {

    /**
     * Constructor que inicializa los atributos de una pulga normal
     * @param path ruta de la imagen de la pulga
     * @param indiceVida valor inicial de vida
     * @param x posición en X
     * @param y posición en Y
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public PulgaNormal(String path, int indiceVida, int x, int y, int height, int width) {
        super(path, 1, x, y, height, width);
        this.indiceVida = indiceVida;
    }

    /**
     * Dibuja graficamente la imagen de la pulga normal
     * @param g contexto gráfico
     */
    @Override
    public void paint(Graphics g) {
        drawImage(g);
    }

    /**
     * Implementacion del metodo recibirImpacto.
     * Reduce el indice de vida en 1 cuando la pulga es impactada.
     */
    @Override
    public void recibirImpacto() {
        this.indiceVida--;
    }
}
