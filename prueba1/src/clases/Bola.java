/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author Alumno
 */
public class Bola {

    private int x = 400;
    private int y;
    private final int ancho = 30, alto = 30;

    boolean fullSalto;
    boolean salto;

    double dy = 1;

    public Bola(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public RoundRectangle2D.Double getBola() {

        return new RoundRectangle2D.Double(x, y, ancho, alto, 100, 100);
    }

    public void mover(Rectangle limites) {
        
        // Salto
        if (EventoTeclado.space == true) {

            if (y > 350) {

                y -= dy;

                if (y == 350) {

                    fullSalto = true;
                }
            }
        }
        
        if (fullSalto) {

            if (y < 500) {

                y += dy;
                EventoTeclado.space = false;
            }
            if (y >= 500) {

                fullSalto = false;
            }
        }
    }

}
