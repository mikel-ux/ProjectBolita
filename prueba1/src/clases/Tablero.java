/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

// import static clases.Bola.puntaje;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author ALUMNOS
 */
public class Tablero extends JPanel {

    static Bola bola = new Bola(100, 500);
    int dx = 0, dy = 0;

    public static Panel panelJuego = new Panel();

//    public Tablero(){
//        
//        setBackground(new Color(26,132,57));
//    }
    
    @Override
    public void paintComponent(Graphics g) {

        ImageIcon fondo = new ImageIcon(getClass().getResource("/imgs/algo.jpg"));
        g.drawImage(fondo.getImage(), dx, dy - 400,
               2500, 1000, null);
        setOpaque(false);
        
        if (EventoTeclado.d){
            
            dx--;
        }
        if (EventoTeclado.a){
            
            dx++;
        }
        if (EventoTeclado.space){
            
            dy--;
        }
        else{
            dy++;
        }
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.white);
        dibujarBola(g2);
        dibujarItems(g2);
        
        actualizar();
        
        super.paintComponent(g);
    }

    public void dibujarBola(Graphics2D g) {

        g.fill(bola.getBola());
    }

    public void actualizar() {

        bola.mover(getBounds());
    }

    private void dibujarItems(Graphics2D g) {

        Font fuentes = new Font("Arial", Font.BOLD, 30);
        g.setFont(fuentes);

        g.drawString("Pulse ESC para salir ", (float) getBounds().getMinX() + 10, 30);
        
        salir_resetearJuego();
    }

    public void salir_resetearJuego() {
        
        if (EventoTeclado.esc){
            
            panelJuego.dispose();
        }
    }
}
