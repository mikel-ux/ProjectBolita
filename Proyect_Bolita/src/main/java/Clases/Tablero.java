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
public class Tablero extends JPanel{

    Color Cielo = new Color(190, 231, 241); 
   Bolita pj=new Bolita(100,100);
    Cubos c1=new Cubos(400,0,400,30);
    
    public Tablero(){ 
        setBackground(Cielo);
        
    }

 public void paintComponent(Graphics g){
        
    super.paintComponent(g);
    Graphics2D g2= (Graphics2D) g;
    g2.setColor(WHITE);
    dibujar(g2);
    actualizar();
    
    }
    
    public void dibujar(Graphics2D g){
        g.setColor(RED);
        g.fill(pj.getBolita());
        g.setColor(BLACK);
        g.fill(c1.getCubo());
    
    }
    
    
    
    public void actualizar(){
        pj.mover(getBounds(),colision(c1.getCubo()));

   
    }
    
    
private boolean colision(Rectangle2D r){
   
  return pj.getBolita().intersects(r);
  }

}
    

