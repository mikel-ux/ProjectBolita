/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Clases.Ventana;
import javax.swing.JFrame;

/**
 *
 * @author Alumno

*/ 
public class Principal {
    
    public static void main(String[] args) {
        
        Ventana ventana= new Ventana(); 
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
}