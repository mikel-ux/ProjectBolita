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
    public int enemyX, enemyY;
    public int speed, speedJump;
    public boolean directionRight;
    
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
    
    // Sprites de enemigo Hunter
    public BufferedImage walkHunterRight1, walkHunterRight2, walkHunterRight3, walkHunterRight4, walkHunterRight5, walkHunterRight6;
    public BufferedImage jumpHunterRight1, jumpHunterRight2, jumpHunterRight3, jumpHunterRight4;
    public BufferedImage walkHunterLeft1, walkHunterLeft2, walkHunterLeft3, walkHunterLeft4, walkHunterLeft5, walkHunterLeft6;
    public BufferedImage jumpHunterLeft1, jumpHunterLeft2, jumpHunterLeft3, jumpHunterLeft4;
    public BufferedImage fallHunterRight1, fallHunterRight2, fallHunterRight3;
    public BufferedImage fallHunterLeft1, fallHunterLeft2, fallHunterLeft3;
    
    // Sprites de enemigo Runner
    public BufferedImage standRunnerRight1, standRunnerRight2, standRunnerRight3, standRunnerRight4, standRunnerRight5;
    public BufferedImage standRunnerLeft1, standRunnerLeft2, standRunnerLeft3, standRunnerLeft4, standRunnerLeft5;
    public BufferedImage runRunnerRight1, runRunnerRight2, runRunnerRight3, runRunnerRight4, runRunnerRight5, runRunnerRight6, runRunnerRight7;
    public BufferedImage runRunnerLeft1, runRunnerLeft2, runRunnerLeft3, runRunnerLeft4, runRunnerLeft5, runRunnerLeft6, runRunnerLeft7;
    
    // Sprites de enemigo Walker
    public BufferedImage walkerRight1, walkerRight2, walkerRight3, walkerRight4;
    public BufferedImage walkerLeft1, walkerLeft2, walkerLeft3, walkerLeft4;
    
    // Sprites de enemigo Jumper
    public BufferedImage jumperAir1, jumperAir2, jumperAir3, jumperAir4;
    public BufferedImage jumperCharging1, jumperCharging2, jumperCharging3, jumperCharging4;
    public BufferedImage jumperFall1, jumperFall2, jumperFall3, jumperFall4; 
    
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
    
    // Contador de sprites para Hunter
    public int spriteNumHunter = 1;
    public int spriteJumpHunter = 1;
    public int spriteFallHunter = 1;
    public int spriteCounterHunter = 0;
    
    // Contador de sprites para Runner
    public int spriteNumRunner = 1;
    public int spriteRunRunner = 1;
    public int spriteCounterRunner = 0;
    
    // Contador de sprites para Walker
    public int spriteNumWalker = 1;
    public int spriteCounterWalker = 0;
    
    // COntador de sprites para Jumper
    public int spriteAirJumper = 1;
    public int spriteChargingJumper = 1;
    public int spriteFallJumper = 1;
    public int spriteCounterJumper = 0;
    
    // Hitboxes
    public Rectangle solidArea_vertical;
    public Rectangle solidArea_horizontal;
    
    //Colisiones:
    public boolean colisionOn = false;
    public boolean colisionDown = false;
    public boolean colisionLeft = false;
    public boolean colisionRight = false;

}
