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
 *
 * @author aleja
 */
public class Montana extends SpriteContainer implements GraphicContainer {

    private PulgaNormal pulga1;
    private PulgaMutante pulga2;
    private EscritorArchivoTextoPlano escritor;
    private LectorArchivoTextoPlano lector;
    private int puntaje;

    public Montana(int x, int y, int height, int width) {
        super(x, y, height, width);

        pulga1 = new PulgaNormal(1, (this.width - PulgaNormal.INITIAL_WIDTH) / 2,
                (this.height - PulgaNormal.INITIAL_HEIGHT) / 2,
                PulgaNormal.INITIAL_WIDTH, PulgaNormal.INITIAL_HEIGHT);
        pulga1.setGraphicContainer(this);

        pulga2 = new PulgaMutante(2, (this.width - PulgaMutante.INITIAL_WIDTH) / 2,
                (this.height - PulgaMutante.INITIAL_HEIGHT) / 2,
                PulgaMutante.INITIAL_WIDTH, PulgaMutante.INITIAL_HEIGHT);
        pulga2.setGraphicContainer(this);

        this.puntaje = 0;

        this.setColor(Color.CYAN);
    }

    public void addPulgaNormal() {
        int w = 15;
        int h = 15;
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
        PulgaNormal pulga1 = new PulgaNormal(1, x, y, w, h);
        pulga1.setGraphicContainer(this);
        sprites.add(pulga1);

        refresh();
    }

    public void addPulgaMutante() {
        int w = 20;
        int h = 20;
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

        PulgaMutante pulga2 = new PulgaMutante(2, x, y, w, h);
        pulga2.setGraphicContainer(this);
        sprites.add(pulga2);

        refresh();
    }

    public void handleKey(KeyEvent e) throws IOException{
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

    public void saltarP(int width, int height) {

        for (Sprite p : sprites) {
            if (p instanceof Pulga) {
                ((Pulga) p).saltar(width, height);
            }
        }
        refresh();
    }

    public void asesinarPulgasPulguipium(int x, int y) throws IOException{
        ArmaPistolaPulguipium armaPulguipium = new ArmaPistolaPulguipium(this);
        armaPulguipium.destruirPulgas(x, y);
        refresh();
    }

    public void asesinarPulgasMisilPulgoson() throws IOException{
        ArmaMisilPulgoson armaPulgoson = new ArmaMisilPulgoson(this);
        armaPulgoson.destruirPulgas();
        refresh();
    }

    public void actualizarPuntaje(int nuevoPuntaje) throws IOException {
        this.puntaje = nuevoPuntaje;

        EscritorArchivoTextoPlano escritor = new EscritorArchivoTextoPlano("puntaje.txt");
        escritor.escribir(Integer.toString(nuevoPuntaje));
    }

    /**
     * Muestra la configuracion actual del vehiculo
     *
     * @throws IOException
     * @return String
     */
    public String mostrarPuntajeActual() throws IOException {
        lector = new LectorArchivoTextoPlano(); // Asegurarse de que esté instanciado
        return lector.leer("puntaje.txt");
    }

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

    @Override
    public void refresh() {
        if (gameContainer != null) {
            gameContainer.refresh();
        }
    }

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }

    public ArrayList<Sprite> getSprites() {
        return sprites;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) throws IOException {
        this.puntaje = puntaje;
        this.actualizarPuntaje(puntaje);
    }
}
