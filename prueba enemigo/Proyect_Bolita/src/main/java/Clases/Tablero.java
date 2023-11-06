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
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Alumno
 */
public class Tablero extends JPanel {

    boolean crear = false;
    // Background
    Color Cielo = new Color(190, 231, 241);
    // Jugador
    Bolita pj = new Bolita(200, 530);
    // Enemigo
    Bolita enemigo = new Bolita(-200 - pj.alto, 1550);
    int cantcubos = 9;
    // Plataformas
    Cubos[] nivel = new Cubos[cantcubos];

    int cont = 0;

    public Tablero() {
        setBackground(Cielo);

    }

    @Override
    public void paintComponent(Graphics g) {
        
        // Reseteo
        if (crear == false || pj.caer() || contacto_muerte()) {
            setcubos();
            enemigo.x = 1550;
            enemigo.y = -200 - enemigo.alto;
            cont = 0;
            enemigo.cont = 0;
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
        g.setColor(BLUE);
        g.fill(enemigo.getBolita());
        g.setColor(BLACK);

        for (int i = 0; i < cantcubos; i++) {
            g.fill(nivel[i].getCubo());
        }
    }

    public void actualizar() {

        pj.mover(getBounds(), contacto_normal());
        enemigo.moverEnemigo(nivel[8].getCubo());
        scroll();

    }

    // Colisión con las plataformas
    private boolean colision(Rectangle2D r) {

        return pj.getBolita().intersects(r);
    }
    
    // Choque con el enemigo
    private boolean muerte(RoundRectangle2D r, Bolita enemigo) {

        return pj.getBolita().intersects(enemigo.x, enemigo.y, enemigo.alto, enemigo.ancho);
    }

    // Creación de obstáculos
    public void setcubos() {

        // Distancias entre obstáculos
        int distancia = 100; // eje x
        int distancia2 = 600; // eje y

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
            
            if (i == 8){
                
                nivel[i].ancho = 325;
                nivel[i].x = distancia - 150;
            }

            distancia += 200;
            distancia2 -= 100;
        }
    }

    public void moverCubos() {

        // Movimientos de las plataformas en eje X
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
            
            // Movimiento del resto de plataformas cuando el jugador se sube a la que va en eje X (incluyendo al enemigo)
        } else {

            for (int i = 0; i < cantcubos; i++) {

                if (i != 5) {

                    if (cont < 600) {

                        nivel[i].x--;
                        //enemigo.x = nivel[8].x;
                        //enemigo.cont = 0;
                    }

                    if (cont >= 600 && cont < 1200) {

                        nivel[i].x++;
                        //enemigo.x = nivel[8].x;
                        //enemigo.cont = 0;
                    }

                    if (cont == 1200) {

                        cont = 0;
                    }

                }
            }
            cont++;
        }
        
        // Movimiento de las plataformas en eje Y
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
            
            //  Movimiento del resto de plataformas cuando el jugador se sube a la que va en eje Y (incluyendo al enemigo)
        } else {

            for (int i = 0; i < cantcubos; i++) {

                if (i != 7) {

                    if (cont < 600) {

                        nivel[i].y--;
                        enemigo.y = nivel[8].y - enemigo.alto;
                    }

                    if (cont >= 600 && cont < 1200) {

                        nivel[i].y++;
                        enemigo.y = nivel[8].y - enemigo.alto;
                    }

                    if (cont == 1200) {

                        cont = 0;
                    }

                }
            }
            cont++;
        }
    }
    
    // Cuando choca con el enemigo
    public boolean contacto_muerte(){
        
        boolean choque = false;
        
        if (muerte(enemigo.getBolita(), enemigo)){
            
            choque = true;
        }
        
        return choque;
    }
    
    // Contacto con las plataformas estáticas
    public boolean contacto_normal() {
        boolean toca = false;

        for (int i = 0; i < cantcubos; i++) {
            if (colision(nivel[i].getCubo()) == true) {
                toca = true;
            }
        }

        return toca;
    }
    
    // Contacto con plataformas que se meuven horizontalmente
    public boolean contacto_movimiento_horizontal() {
        boolean toca = false;

        if (colision(nivel[5].getCubo()) == true) {
            toca = true;
        }

        return toca;
    }

    // Contacto con plataformas que se meuven verticalmente
    public boolean contacto_movimiento_vertical() {
        boolean toca = false;

        if (colision(nivel[7].getCubo()) == true) {
            toca = true;
        }

        return toca;
    }

    // Efecto de cámara
    public void scroll() {

        // Movimiento de todos los obstáculos
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
        
        // Movimiento del enemigo
        if (EventoTeclado.der == true && EventoTeclado.iz == false) {

                enemigo.x--;
            }

            if (EventoTeclado.der == false && EventoTeclado.iz == true) {

                enemigo.x++;
            }

            if (pj.y < 200) {

                enemigo.y++;
            }
            
            //            if (pj.y > 400) {
//
//                nivel[i].y--;
//            }
    }
}
