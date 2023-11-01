/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.event.*;

/**
 *
 * @author Alumno
 */
public class EventoTeclado extends KeyAdapter{
    
    static boolean d, a, w;
    static boolean space, esc;
    
    @Override
    public void keyPressed(KeyEvent e){
        
        int id = e.getKeyCode();

        if (id == KeyEvent.VK_A){
            a = true;
        }
        if (id == KeyEvent.VK_D){
            d = true;
        }
        if (id == KeyEvent.VK_SPACE){
            space = true;
        }
        if (id == KeyEvent.VK_ESCAPE){
            esc = true;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
        int id = e.getKeyCode();

        if (id == KeyEvent.VK_A){
            a = false;
        }
        if (id == KeyEvent.VK_D){
            d = false;
        }
        if (id == KeyEvent.VK_SPACE){
            space = false;
        }
        if (id == KeyEvent.VK_ESCAPE){
            esc = false;
        }
    }
}
