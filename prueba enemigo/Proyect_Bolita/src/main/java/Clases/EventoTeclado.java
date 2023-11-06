/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Alumno
 */
public class EventoTeclado extends KeyAdapter{
  static boolean der,iz,up;
    
     public void keyPressed(KeyEvent e){
    
    int id=e.getKeyCode();
    
    if(id==KeyEvent.VK_LEFT){
    iz=true;

    }
    
    if(id==KeyEvent.VK_RIGHT){
    der=true;

    }
    
    if(id==KeyEvent.VK_UP){
    up=true;
    }
    
     }
 public void keyReleased(KeyEvent e){
    int id=e.getKeyCode();
    
    if(id==KeyEvent.VK_LEFT){
     iz=false;
    }
    
    if(id==KeyEvent.VK_RIGHT){
     der=false;
    }
    
 if(id==KeyEvent.VK_UP){
    up=false;
    }
 }
}
