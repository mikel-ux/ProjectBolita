/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class Ventana extends JFrame{
   private Tablero lamina;
   private Hilo hilo;
   
    public Ventana(){ 
    setTitle("Pool");
    setSize(800,800);
    setLocationRelativeTo(null);
    setResizable(false);
    addKeyListener(new EventoTeclado());
    
   lamina= new Tablero();
   add(lamina);
  hilo = new Hilo(lamina);
   hilo.start();


    }
    
}

