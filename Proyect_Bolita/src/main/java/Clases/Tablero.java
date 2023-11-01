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
 
    boolean crear=false;
    Color Cielo = new Color(190, 231, 241); 
   Bolita pj=new Bolita(300,100);
    Cubos c1=new Cubos(400,200,400,30);
    int cantcubos=6;
    Cubos[] nivel=new Cubos[cantcubos];
    
    public Tablero(){ 
        setBackground(Cielo);
        
    }

 public void paintComponent(Graphics g){
     if(crear==false){
     setcubos();
     crear=true;
     }
     
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
        
        for(int i=0;i<cantcubos;i++){
        g.fill(nivel[i].getCubo());
        }
    }
    
    
    
    public void actualizar(){
        
        pj.mover(getBounds(),contacto());
         scroll();
   
    }
    
    
private boolean colision(Rectangle2D r){
   
  return pj.getBolita().intersects(r);
  }

public void setcubos(){

    nivel[0]=new Cubos(400,0,100,10);
    nivel[1]=new Cubos(400,200,100,10);
    nivel[2]=new Cubos(400,400,100,10);
    nivel[3]=new Cubos(400,600,100,10);
    nivel[4]=new Cubos(400,900,200,10);
    nivel[5]=new Cubos(400,1100,200,10);
}

public boolean contacto(){
    boolean toca=false;
    
for(int i=0;i<cantcubos;i++){
if(colision(nivel[i].getCubo())==true){
toca=true;
}
}

return toca;
}

public void scroll(){

 for(int i=0;i<cantcubos;i++){
    
     if(EventoTeclado.der==true && EventoTeclado.iz==false){
    nivel[i].x--;
    System.out.println("objeto "+i+" "+EventoTeclado.der);
    }
    
    if(EventoTeclado.der==false && EventoTeclado.iz==true){
     nivel[i].x++;
    }  
     
}

}

}
    

