/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import src.GamePanel;

/**
 *
 * @author w10
 */
public class Walker extends Entity{
    
    GamePanel gp;
    
    public Walker(GamePanel gp){
        
        this.gp = gp;
        
        solidArea_vertical = new Rectangle(0, 0, 42, 42);
        
        setDefaultValues();
        getWalkerImage();
    }
    
    public void setDefaultValues() {

        enemyX = 0;
        enemyY = 0;
        directionRight = false;
        speed = 0;
    }
    
    public void getWalkerImage(){
        
        try{
            // Imagenes movimiento derecha
            File file = new File("src/main/java/imgWalker/walker_right1.png");
            FileInputStream fis = new FileInputStream(file);
            this.walkerRight1 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgWalker/walker_right2.png");
            fis = new FileInputStream(file);
            this.walkerRight2 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgWalker/walker_right3.png");
            fis = new FileInputStream(file);
            this.walkerRight3 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgWalker/walker_right4.png");
            fis = new FileInputStream(file);
            this.walkerRight4 = ImageIO.read(fis);
            
            // Imagenes movimiento izquierda
            file = new File("src/main/java/imgWalker/walker_left1.png");
            fis = new FileInputStream(file);
            this.walkerLeft1 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgWalker/walker_left2.png");
            fis = new FileInputStream(file);
            this.walkerLeft2 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgWalker/walker_left3.png");
            fis = new FileInputStream(file);
            this.walkerLeft3 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgWalker/walker_left4.png");
            fis = new FileInputStream(file);
            this.walkerLeft4 = ImageIO.read(fis);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(int limiteIzq, int limiteDer){
        
        spriteCounterWalker++;

        if (spriteCounterWalker > 6) {

            // Animación para movimiento normal
            switch (spriteNumWalker) {

                case 1 ->
                    spriteNumWalker = 2;
                case 2 ->
                    spriteNumWalker = 3;
                case 3 ->
                    spriteNumWalker = 4;
                case 4 ->
                    spriteNumWalker = 1;
            }

            spriteCounterWalker = 0;
        }
        
        // ----------------------------- MOVIMIENTO --------------------------------- //
        if (!gp.player.muerte_individual(this)) {
            if ((enemyX + gp.player.worldX + solidArea_vertical.width) / 64 < limiteDer && directionRight) {
                speed -= 2;
            } else {
                directionRight = false;
            }

            if (!directionRight && (enemyX + gp.player.worldX - solidArea_vertical.width) / 64 > limiteIzq) {
                speed += 2;
            } else {
                directionRight = true;
            }
        }
        
    }
    
    public void draw(Graphics2D g2, int worldCol, int worldRow){
        
        BufferedImage image = null;
        
        // Sprites direccion derecha
        if (directionRight) {

            if (spriteNumWalker == 1) {
                image = walkerRight1;
            }
            if (spriteNumWalker == 2) {
                image = walkerRight2;
            }
            if (spriteNumWalker == 3) {
                image = walkerRight3;
            }
            if (spriteNumWalker == 4) {
                image = walkerRight4;
            }
        // Sprites direccion izquierda
        } else {

            if (spriteNumWalker == 1) {
                image = walkerLeft1;
            }
            if (spriteNumWalker == 2) {
                image = walkerLeft2;
            }
            if (spriteNumWalker == 3) {
                image = walkerLeft3;
            }
            if (spriteNumWalker == 4) {
                image = walkerLeft4;
            }
        }

        int worldX = worldCol * gp.tileSize;
        int worldY = worldRow * gp.tileSize;
        enemyX = worldX - gp.player.worldX + gp.player.screenX - speed;
        enemyY = worldY - gp.player.worldY + gp.player.screenY;

        g2.drawImage(image, enemyX, enemyY, gp.tileSize, gp.tileSize, null);
    }
}
