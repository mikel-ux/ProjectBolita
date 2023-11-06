/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author Alumno
 */
public class Bolita {

    public int x;
    public int y;
    public boolean aire = true;
    int dy = 1;
    int saltosec;
    boolean maxalt;
    boolean finsalto = false;
    int cont;
    boolean direccion = true;
    public final int ancho = 25, alto = 25;

    public Bolita(int y, int x) {
        
        this.x = x;
        this.y = y;
    }

    public RoundRectangle2D getBolita() {
        return new RoundRectangle2D.Double(x, y, ancho, alto, 50, 50);

    }

    public void mover(Rectangle limites, boolean colision) {

        if (aire == true) {
            y = y + dy;

        }

        //pisa el piso
        if (colision == true) {
            aire = false;
            saltosec = 0;
            maxalt = false;
            finsalto = false;
        }

        if (colision == false) {
            aire = true;
        }

        if (EventoTeclado.up == true && maxalt == false && finsalto == false) {
            y -= 2;
            saltosec++;
            aire = true;

            if (saltosec == 150) {
                maxalt = true;
            }

        }

        if (EventoTeclado.up == false) {
            finsalto = true;
        }

    }

    // Movimiento del enemigo
    public void moverEnemigo(Rectangle2D limites) {

        if (x >= limites.getBounds().getMinX() && x <= limites.getBounds().getMaxX() - ancho){
            
            if (x == limites.getBounds().getMaxX() - ancho){
                
                // Dirección del enemigo a la izquierda 
                direccion = false;
            }
            
            if (x == limites.getBounds().getMinX()){
                
                // A la derecha
                direccion = true;
            }
            
            if (direccion){
                
                x++;
            } else{
                
                x--;
            }
        }
    }

    // Cuando cae la bolita
    public boolean caer() {

        boolean cae = false;

        // Limite inferior
        if (y == 700) {
            x = 530;
            y = 200;
            cae = true;
        }

        return cae;
    }

}
