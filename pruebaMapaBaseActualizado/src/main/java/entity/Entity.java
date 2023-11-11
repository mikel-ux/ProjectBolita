/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author w10
 */
public class Entity {
    
    public int worldX, worldY;
    public int speed;
    
    public BufferedImage up, down, left, right; // Poner tantos up, down, left y right como sean necesarios para los sprites.
    public String direction;
    
//    public int spriteCounter = 0;
//    public int spriteNum = 1;
    
    public Rectangle solidArea;
    public boolean colisionOn = false;
}
