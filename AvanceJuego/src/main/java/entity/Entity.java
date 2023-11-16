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
    
    // Sprites de jugador principal
    public BufferedImage right1, right2, right3, right4, right5, right6, right7, right8, right9;
    public BufferedImage left1, left2, left3, left4, left5, left6, left7, left8, left9; 
    public BufferedImage stand1, stand2, stand3, stand4, stand5, stand6;
    public BufferedImage stand_left1, stand_left2, stand_left3, stand_left4, stand_left5, stand_left6;
    public BufferedImage up_right4, up_right5, up_right6;
    public BufferedImage up_left4, up_left5, up_left6;
    public BufferedImage fall_right1, fall_left1;
    public BufferedImage death1, death2, death3, death4, death5, death6, death7, death8; 
    public BufferedImage death_left1, death_left2;
    
    // Sprites de dron aliado
    public BufferedImage dronImg1, dronImg2, dronImg3, dronImg4, dronImg5, dronImg6, dronImg7, dronImg8, dronImg9, dronImg10, dronImg11;
    
    // Orientación del PJ
    public String direction;
    public String reference;
    
    // Contador de sprites para PJ
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int spriteStand = 1;
    public int spriteJump = 1;
    public int spriteDeath = 1;
    public int spriteRespawn = 1;
    
    // Contador de sprites para dron
    public int spriteNumDron = 1;
    public int spriteCounterDron = 0;
    
    // PJ Hitboxes
    public Rectangle solidArea_vertical;
    public Rectangle solidArea_horizontal;
    
    //Colisiones:
    public boolean colisionOn = false;
    public boolean colisionDown = false;
    public boolean colisionLeft = false;
    public boolean colisionRight = false;

}
