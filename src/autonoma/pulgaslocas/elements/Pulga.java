/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Clase abstracta que representa una pulga dentro del juego.
 * @author Alejandro
 * @since 20250507
 * @version 1.0
 */
public abstract class Pulga extends Sprite {

    /**
     * Indice de vida de la pulga
     */
    protected int indiceVida;

    /**
     * Ancho inicial de la pulga
     */
    public static final int INITIAL_WIDTH = 50;

    /**
     * Alto inicial de la pulga
     */
    public static final int INITIAL_HEIGHT = 50;

    /**
     * Tamaño que crece la pulga en ciertos eventos
     */
    public static final int GROW_SIZE = 4;

    /**
     * Imagen asociada a la pulga
     */
    private BufferedImage image;

    /**
     * Paso que avanza
     */
    protected int step = 5;

    /**
     * Constructor que inicializa los atributos de la pulga
     * @param path ruta de la imagen de la pulga
     * @param indiceVida valor de vida de la pulga
     * @param x posición en X
     * @param y posición en Y
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public Pulga(String path, int indiceVida, int x, int y, int height, int width) {
        super(x, y, height, width);
        try {
            this.image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.indiceVida = indiceVida;
    }

    /**
     * Metodo que simula un salto aleatorio dentro de los limites dados
     * @param width ancho maximo permitido
     * @param height alto maximo permitido
     */
    public void saltar(int width, int height) {
        x = (int) (Math.random() * (width - 50));
        y = (int) (Math.random() * (height - 50));
    }

    /**
     * Metodo abstracto que define como recibe un impacto una pulga
     */
    public abstract void recibirImpacto();

    /**
     * Retorna el indice de vida actual
     * @return indice de vida
     */
    public int getIndiceVida() {
        return indiceVida;
    }

    /**
     * Establece un nuevo indice de vida
     * @param indiceVida nuevo valor de vida
     */
    public void setIndiceVida(int indiceVida) {
        this.indiceVida = indiceVida;
    }

    /**
     * Verifica si la pulga esta muerta (vida igual a 0)
     * @return true si esta muerta, false si sigue viva
     */
    public boolean estaMuerta() {
        return this.indiceVida == 0;
    }

    /**
     * Mueve la pulga en una dirección aleatoria si no sale del contenedor
     * @return true si se movio exitosamente, false si no pudo moverse
     */
    public boolean move() {
        int direction = (int) (Math.random() * 4);

        int nx = x;
        int ny = y;

        switch (direction) {
            case 0:
                ny -= step;
                break;
            case 1:
                ny += step;
                break;
            case 2:
                nx -= step;
                break;
            case 3:
                nx += step;
                break;
        }

        if (!isOutOfGraphicContainer(nx, ny, width, height)) {
            x = nx;
            y = ny;

            if (gameContainer != null)
                gameContainer.refresh();

            return true;
        }
        return false;
    }

    /**
     * Dibuja la imagen de la pulga sobre el contexto grafico
     * @param g contexto gráfico
     */
    public void drawImage(Graphics g) {
        if (image != null) {
            g.drawImage(image, x, y, width, height, null);
        } else {
            g.setColor(color != null ? color : Color.BLACK);
            g.fillRect(x, y, width, height);
        }
    }

    /**
     * Devuelve los limites de la imagen como un rectangulo
     * @return objeto Rectangle con los límites de la imagen
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
