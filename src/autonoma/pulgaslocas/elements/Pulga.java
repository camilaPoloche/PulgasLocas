/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 *
 * @author Camila
 */
public abstract class Pulga {
    protected int indiceVida;

    public Pulga(int indiceVida) {
        this.indiceVida = indiceVida;
    }
  
    public abstract void saltar();

    public int getIndiceVida() {
        return indiceVida;
    }

    public void setIndiceVida(int indiceVida) {
        this.indiceVida = indiceVida;
    }
}

