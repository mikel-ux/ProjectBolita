/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Alumno
 */
public class Tablero extends JPanel {

    boolean crear = false;
    Color Cielo = new Color(190, 231, 241);
    Bolita pj = new Bolita(200, 530);
    int cantcubos = 8;
    Cubos[] nivel = new Cubos[cantcubos];

    int cont = 0;

    public Tablero() {
        setBackground(Cielo);

    }

    @Override
    public void paintComponent(Graphics g) {
        if (crear == false || pj.caer()) {
            setcubos();
            cont = 0;
            crear = true;
        }

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(WHITE);
        dibujar(g2);
        actualizar();
        moverCubos();

    }

    public void dibujar(Graphics2D g) {
        g.setColor(RED);
        g.fill(pj.getBolita());
        g.setColor(BLACK);

        for (int i = 0; i < cantcubos; i++) {
            g.fill(nivel[i].getCubo());
        }
    }

    public void actualizar() {

        pj.mover(getBounds(), contacto_normal());
        scroll();

    }

    private boolean colision(Rectangle2D r) {

        return pj.getBolita().intersects(r);
    }

    public void setcubos() {

        int distancia = 100;
        int distancia2 = 600;

        for (int i = 0; i < cantcubos; i++) {

            nivel[i] = new Cubos(distancia2, distancia, 100, 10);

            if (i == 5) {

                nivel[i].ancho = 200;
            }

            if (i == 6) {

                nivel[i].x = distancia + 400;
                nivel[i].y = distancia2 + 100;
            }

            if (i == 7) {

                nivel[i].ancho = 200;
                nivel[i].x = distancia + 500;
            }

            distancia += 200;
            distancia2 -= 100;
        }

    }

    public void moverCubos() {

        if (!contacto_movimiento_horizontal()) {

            if (cont < 600) {

                nivel[5].x++;
            }

            if (cont >= 600 && cont < 1200) {

                nivel[5].x--;
            }

            if (cont == 1200) {

                cont = 0;
            }

            cont++;
        } else {

            for (int i = 0; i < cantcubos; i++) {

                if (i != 5) {

                    if (cont < 600) {

                        nivel[i].x--;
                    }

                    if (cont >= 600 && cont < 1200) {

                        nivel[i].x++;
                    }

                    if (cont == 1200) {

                        cont = 0;
                    }

                }
            }
            cont++;
        }
        
        if (!contacto_movimiento_vertical()) {

            if (cont < 600) {

                nivel[7].y++;
            }

            if (cont >= 600 && cont < 1200) {

                nivel[7].y--;
            }

            if (cont == 1200) {

                cont = 0;
            }

            cont++;
        } else {

            for (int i = 0; i < cantcubos; i++) {

                if (i != 7) {

                    if (cont < 600) {

                        nivel[i].y--;
                    }

                    if (cont >= 600 && cont < 1200) {

                        nivel[i].y++;
                    }

                    if (cont == 1200) {

                        cont = 0;
                    }

                }
            }
            cont++;
        }
    }

    public boolean contacto_normal() {
        boolean toca = false;

        for (int i = 0; i < cantcubos; i++) {
            if (colision(nivel[i].getCubo()) == true) {
                toca = true;
            }
        }

        return toca;
    }

    public boolean contacto_movimiento_horizontal() {
        boolean toca = false;

        if (colision(nivel[5].getCubo()) == true) {
            toca = true;
        }

        return toca;
    }

    public boolean contacto_movimiento_vertical() {
        boolean toca = false;

        if (colision(nivel[7].getCubo()) == true) {
            toca = true;
        }

        return toca;
    }

    public void scroll() {

        for (int i = 0; i < cantcubos; i++) {

            if (EventoTeclado.der == true && EventoTeclado.iz == false) {

                nivel[i].x--;
            }

            if (EventoTeclado.der == false && EventoTeclado.iz == true) {

                nivel[i].x++;
            }

            if (pj.y < 200) {

                nivel[i].y++;
            }

//            if (pj.y > 400) {
//
//                nivel[i].y--;
//            }
        }
    }
}
