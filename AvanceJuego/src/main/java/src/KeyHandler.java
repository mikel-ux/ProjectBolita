/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Alumno
 */
public class KeyHandler implements KeyListener{

    public boolean up, left, right, down;

    @Override
    public void keyPressed(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_UP){
            
            up = true;
        }
        if (code == KeyEvent.VK_LEFT){
            
            left = true;
        }
        if (code == KeyEvent.VK_RIGHT){
            
            right = true;
        }
        if (code == KeyEvent.VK_DOWN){
            
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode();
        
        if (code == KeyEvent.VK_UP){
             
            up = false;
        }
        if (code == KeyEvent.VK_LEFT){
            
            left = false;
        }
        if (code == KeyEvent.VK_RIGHT){
            
            right = false;
        }
        if (code == KeyEvent.VK_DOWN){
            
            down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
