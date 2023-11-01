/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Alumno
 */
public class Bolita {
    
    public int x;
    public int y;
    public boolean aire=true;
    int dy=1;
    int saltosec;
    boolean maxalt;
    boolean finsalto=false;
    private final int ancho=15,alto=15;
  
    

    
    public Bolita(int y,int x){
    this.x=x;
    this.y=y;
    
     }
    
     public Rectangle2D getBolita(){
    return new Rectangle2D.Double(x,y,ancho,alto);
    
    }
     
    public void mover(Rectangle limites, boolean colision){
       
        if(y==700){
        x=300;
        y=0;
        }
        
      if(aire==true){
          y=y+dy;
         
      }  
      
      //pisa el piso
      if(colision==true){
      aire=false;
      saltosec=0;
      maxalt=false;
      finsalto=false;
      }
      
      if(colision==false){
      aire=true;
      }
      
   /* if(EventoTeclado.der==true && EventoTeclado.iz==false){
    x++;
    }
    
    if(EventoTeclado.der==false && EventoTeclado.iz==true){
    x--;
    }
    */
    if(EventoTeclado.up==true && maxalt==false && finsalto==false){
        y-=2;
        saltosec++;
        aire=true;
        
        if(saltosec==100){
        maxalt=true;
        }
     
    }
    
    if(EventoTeclado.up==false){
    finsalto=true;
    }
    
    
    
    } 


}