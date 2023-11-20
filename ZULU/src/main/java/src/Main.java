/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class Main {

    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        GamePanel gp = new GamePanel();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("ZULU GAME");
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.startGameThread();
    }
}
