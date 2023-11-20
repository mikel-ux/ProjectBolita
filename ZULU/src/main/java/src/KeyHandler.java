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
    
    GamePanel gp;
    
    public boolean up, left, right, down;
    
    public KeyHandler (GamePanel gp){
    this.gp = gp;
    }
    
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
        if (code == KeyEvent.VK_P){
           if(gp.gameState == gp.playState){
           gp.gameState = gp.pauseState;
           }
           else if( gp.gameState == gp.pauseState ){
            gp.gameState = gp.playState;   
           }
        }
        // Reinicio
        if (code == KeyEvent.VK_R && gp.gameState == gp.playState){
            
            gp.resetAll();
        }
        // Jugar
        if (code == KeyEvent.VK_J && gp.gameState == gp.menuState){
            
            gp.gameState = gp.playState;
            gp.resetAll();
            gp.curlevel = 1;
            gp.firstload = false;
        }
        // Salir de pausa o pantalla final
        if (code == KeyEvent.VK_S && (gp.gameState == gp.pauseState || gp.gameState == gp.finalState)){
            
            gp.gameState = gp.menuState;
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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
