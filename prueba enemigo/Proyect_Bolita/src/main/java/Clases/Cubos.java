/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author Alumno
 */
public class Cubos {

    public int x;
    public int y;
    int ancho, alto;

    public Cubos(int y, int x, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;

    }

    public Rectangle2D getCubo() {
        return new Rectangle2D.Double(x, y, ancho, alto);

    }

}
