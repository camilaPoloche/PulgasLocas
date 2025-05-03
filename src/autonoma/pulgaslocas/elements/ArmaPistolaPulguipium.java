/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgasLocasBase.elements.Sprite;

/**
 *
 * @author aleja
 */
public class ArmaPistolaPulguipium extends Arma{
    
    private Montana montana;

    public ArmaPistolaPulguipium(Montana montana) {
        this.montana = montana;
    }
    
    @Override
    public void destruirPulgas(int x, int y) {
        int rango = 10;  

        for (int i = 0; i < this.montana.getSprites().size(); i++) {
            Sprite p = this.montana.getSprites().get(i);

            if (p instanceof Pulga) {
                int pulgaX = p.getX();
                int pulgaY = p.getY();

                if (Math.abs(pulgaX - x) < rango && Math.abs(pulgaY - y) < rango) {
                    ((Pulga) p).recibirImpacto();

                    if (p instanceof PulgaMutante) {
                        Pulga nueva = ((PulgaMutante) p).transformar();
                        this.montana.getSprites().set(i, nueva);
                    } else if (((Pulga) p).getIndiceVida() == 0) {
                        this.montana.remove(i);
                    }
                    break;  
                }
            }
        }
    }

    @Override
    public void destruirPulgas() {
        
    }
}
