/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que representa una pulga mutante en el juego.
 * Hereda de la clase Pulga y redefine su comportamiento al recibir impactos.
 * Tambien puede transformarse en una pulga normal si su vida llega a un valor especifico.
 * 
 * 
 * @author Alejandro
 * @since 20250507
 * @version 1.0
 */
public class PulgaMutante extends Pulga {

    /**
     * Constructor que inicializa los atributos de una pulga mutante
     * @param path ruta de la imagen asociada
     * @param indiceVida valor inicial de vida
     * @param x posición en X
     * @param y posición en Y
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public PulgaMutante(String path, int indiceVida, int x, int y, int height, int width) {
        super(path, 2, x, y, height, width);
        this.indiceVida = indiceVida;
    }

    /**
     * Implementacion del metodo recibirImpacto.
     * Disminuye en 1 el índice de vida al ser impactada.
     */
    @Override
    public void recibirImpacto() {
        this.indiceVida--;
    }

    /**
     * Dibuja graficamente la imagen de la pulga mutante
     * @param g contexto gráfico
     */
    @Override
    public void paint(Graphics g) {
        drawImage(g);
    }

    /**
     * Metodo que transforma la pulga mutante en una pulga normal
     * si su indice de vida es igual a 1.
     * @return una nueva instancia de PulgaNormal si se transforma.
     */
    public Pulga transformar() {
        if (this.indiceVida == 1) {
            PulgaNormal pulgaN = new PulgaNormal("/autonoma/pulgaslocas/images/pulgaBoba.png", 1, x, y, 50, 50);
            pulgaN.setGraphicContainer(gameContainer);
            return pulgaN;
        }
        return this;
    }
}