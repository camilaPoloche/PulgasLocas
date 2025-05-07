/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.GraphicContainer;
import autonoma.pulgasLocasBase.elements.Sprite;
import autonoma.pulgasLocasBase.elements.SpriteContainer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Modelo que representa el escenario principal donde se desarrollan las interacciones 
 * entre las pulgas y las armas del juego.
 * @author Alejandro
 * @since 20250507
 * @version 1.0
 */
public class Montana extends SpriteContainer implements GraphicContainer {

    /**
     * Instancia de la clase PulgaNormal
     */
    private PulgaNormal pulga1;

    /**
     * Instancia de la clase PulgaMutante
     */
    private PulgaMutante pulga2;

    /**
     * Instancia para escribir archivos de texto plano
     */
    private EscritorArchivoTextoPlano escritor;

    /**
     * Instancia para leer archivos de texto plano
     */
    private LectorArchivoTextoPlano lector;

    /**
     * Puntaje actual del jugador
     */
    private int puntaje;

    /**
     * Constructor que inicializa los atributos y configura las pulgas iniciales en la montaña
     * @param x posición en X del contenedor
     * @param y posición en Y del contenedor
     * @param height altura del contenedor
     * @param width ancho del contenedor
     */
    public Montana(int x, int y, int height, int width) {
        super(x, y, height, width);

        pulga1 = new PulgaNormal("/autonoma/pulgaslocas/images/pulgaBoba.png", 1, (this.width - PulgaNormal.INITIAL_WIDTH) / 2,
                (this.height - PulgaNormal.INITIAL_HEIGHT) / 2,
                PulgaNormal.INITIAL_WIDTH, PulgaNormal.INITIAL_HEIGHT);
        pulga1.setGraphicContainer(this);

        pulga2 = new PulgaMutante("/autonoma/pulgaslocas/images/pulgaAvispada.png", 2, (this.width - PulgaMutante.INITIAL_WIDTH) / 2,
                (this.height - PulgaMutante.INITIAL_HEIGHT) / 2,
                PulgaMutante.INITIAL_WIDTH, PulgaMutante.INITIAL_HEIGHT);
        pulga2.setGraphicContainer(this);

        this.puntaje = 0;

        this.setColor(new Color(95, 175, 49));
    }

    /**
     * Agrega una nueva pulga normal en una posición aleatoria sin colisionar con otras
     */
    public void addPulgaNormal() {
        int w = 50;
        int h = 50;
        int x, y;

        boolean chocadas;
        do {
            x = (int) (Math.random() * (this.width - 15));
            y = (int) (Math.random() * (this.height - 15));
            chocadas = false;

            for (Sprite sprite : sprites) {
                Pulga pulgaExistente = (Pulga) sprite;
                int distanciaX = Math.abs(x - pulgaExistente.getX());
                int distanciaY = Math.abs(y - pulgaExistente.getY());

                if (distanciaX < w && distanciaY < h) {
                    chocadas = true;
                    break;
                }
            }
        } while (chocadas);
        PulgaNormal pulga1 = new PulgaNormal("/autonoma/pulgaslocas/images/pulgaBoba.png", 1, x, y, w, h);
        pulga1.setGraphicContainer(this);
        sprites.add(pulga1);

        refresh();
    }

    /**
     * Agrega una nueva pulga mutante en una posición aleatoria sin colisionar con otras
     */
    public void addPulgaMutante() {
        int w = 60;
        int h = 60;
        int x, y;

        boolean chocadas;
        do {
            x = (int) (Math.random() * (this.width - 20));
            y = (int) (Math.random() * (this.height - 20));
            chocadas = false;

            for (Sprite sprite : sprites) {
                Pulga pulgaExistente = (Pulga) sprite;
                int distanciaX = Math.abs(x - pulgaExistente.getX());
                int distanciaY = Math.abs(y - pulgaExistente.getY());

                if (distanciaX < w && distanciaY < h) {
                    chocadas = true;
                    break;
                }
            }
        } while (chocadas);

        PulgaMutante pulga2 = new PulgaMutante("/autonoma/pulgaslocas/images/pulgaAvispada.png", 2, x, y, w, h);
        pulga2.setGraphicContainer(this);
        sprites.add(pulga2);

        refresh();
    }

    /**
     * Maneja eventos del teclado para ejecutar acciones en el juego
     * @param e evento de teclado
     * @throws IOException
     */
    public void handleKey(KeyEvent e) throws IOException {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_P:
                addPulgaNormal();
                break;

            case KeyEvent.VK_M:
                addPulgaMutante();
                break;

            case KeyEvent.VK_S:
                saltarP(this.width, this.height);
                break;

            case KeyEvent.VK_SPACE:
                asesinarPulgasMisilPulgoson();
                break;
        }
    }

    /**
     * Hace saltar a todas las pulgas dentro del area de juego
     * @param width ancho del contenedor
     * @param height alto del contenedor
     */
    public void saltarP(int width, int height) {
        for (Sprite p : sprites) {
            if (p instanceof Pulga) {
                ((Pulga) p).saltar(width, height);
            }
        }
        refresh();
    }

    /**
     * Elimina pulgas cercanas a una coordenada con el arma Pulguipium
     * @param x posición X del disparo
     * @param y posición Y del disparo
     * @throws IOException
     */
    public void asesinarPulgasPulguipium(int x, int y) throws IOException {
        ArmaPistolaPulguipium armaPulguipium = new ArmaPistolaPulguipium(this);
        armaPulguipium.destruirPulgas(x, y);
        refresh();
    }

    /**
     * Elimina todas las pulgas con el arma Misil Pulgoson
     * @throws IOException
     */
    public void asesinarPulgasMisilPulgoson() throws IOException {
        ArmaMisilPulgoson armaPulgoson = new ArmaMisilPulgoson(this);
        armaPulgoson.destruirPulgas();
        refresh();
    }

    /**
     * Actualiza el puntaje y lo guarda en un archivo
     * @param nuevoPuntaje nuevo valor del puntaje
     * @throws IOException
     */
    public void actualizarPuntaje(int nuevoPuntaje) throws IOException {
        this.puntaje = nuevoPuntaje;

        EscritorArchivoTextoPlano escritor = new EscritorArchivoTextoPlano("puntaje.txt");
        escritor.escribir(Integer.toString(nuevoPuntaje));
    }

    /**
     * Muestra el puntaje actual almacenado en el archivo
     * @return puntaje leído
     * @throws IOException
     */
    public String mostrarPuntajeActual() throws IOException {
        lector = new LectorArchivoTextoPlano(); 
        return lector.leer("puntaje.txt");
    }

    /**
     * Dibuja los elementos graficos del juego sobre el panel
     * @param g contexto gráfico
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawString(this.puntaje+"", 10, 50);

        ArrayList<Sprite> copiaSprites = new ArrayList<>(sprites);

        for (Sprite sprite : copiaSprites) {
            sprite.paint(g);
        }
    }

    /**
     * Refresca la vista del contenedor grafico
     */
    @Override
    public void refresh() {
        if (gameContainer != null) {
            gameContainer.refresh();
        }
    }

    /**
     * Devuelve los limites del area del juego
     * @return limites como objeto Rectangle
     */
    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Retorna la lista de sprites actuales
     * @return lista de sprites
     */
    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    /**
     * Retorna el puntaje actual
     * @return puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Establece el puntaje y lo actualiza en el archivo
     * @param puntaje nuevo puntaje
     * @throws IOException
     */
    public void setPuntaje(int puntaje) throws IOException {
        this.puntaje = puntaje;
        this.actualizarPuntaje(puntaje);
    }
<<<<<<< HEAD

    /**
     * Devuelve una copia sincronizada de los sprites para evitar concurrencia
     * @return copia de la lista de sprites
     */
    public synchronized ArrayList<Sprite> getCopiaSprites() {
=======
    
    public ArrayList<Sprite> getCopiaSprites() {
>>>>>>> 2c8730f0b981e2b62e85c5fb3a5b207e13b1864c
        return new ArrayList<>(sprites); 
    }
}
