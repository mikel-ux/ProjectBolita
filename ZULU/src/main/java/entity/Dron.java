/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Graphics2D;
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
public class Dron extends Entity {

    GamePanel gp;

    public int dronX;
    public int dronY;
    
    public boolean subida = false;
    public boolean tope = false;
    public boolean limite = false;

    public Dron(GamePanel gp) {

        this.gp = gp;
        
        dronY = 0;
        dronX = 0;
        
        tope = false;

        getDronImage();
        setDefaultValues();
    }
    
    public void setDefaultValues(){
        
        dronX = 0;
        dronY = 0;
        subida = false;
        tope = false;
        speed = 0;
    }

    private void getDronImage() {

        try {
            File file = new File("src/main/java/imgDron/standDrone1.png");
            FileInputStream fis = new FileInputStream(file);
            this.dronImg1 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone2.png");
            fis = new FileInputStream(file);
            this.dronImg2 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone3.png");
            fis = new FileInputStream(file);
            this.dronImg3 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone4.png");
            fis = new FileInputStream(file);
            this.dronImg4 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone5.png");
            fis = new FileInputStream(file);
            this.dronImg5 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone6.png");
            fis = new FileInputStream(file);
            this.dronImg6 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone7.png");
            fis = new FileInputStream(file);
            this.dronImg7 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone8.png");
            fis = new FileInputStream(file);
            this.dronImg8 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone9.png");
            fis = new FileInputStream(file);
            this.dronImg9 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone10.png");
            fis = new FileInputStream(file);
            this.dronImg10 = ImageIO.read(fis);

            file = new File("src/main/java/imgDron/standDrone11.png");
            fis = new FileInputStream(file);
            this.dronImg11 = ImageIO.read(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void update(int limiteIzq, int limiteDer, int limiteAb, int limiteArr) {

        spriteCounterDron++;

        if (spriteCounterDron > 6) {

            // Animación para movimiento normal
            switch (spriteNumDron) {

                case 1 ->
                    spriteNumDron = 2;
                case 2 ->
                    spriteNumDron = 3;
                case 3 ->
                    spriteNumDron = 4;
                case 4 ->
                    spriteNumDron = 5;
                case 5 ->
                    spriteNumDron = 6;
                case 6 ->
                    spriteNumDron = 7;
                case 7 ->
                    spriteNumDron = 8;
                case 8 ->
                    spriteNumDron = 9;
                case 9 ->
                    spriteNumDron = 1;
            }

            spriteCounterDron = 0;
        }
        
        if (gp.player.worldX / 64 >= limiteIzq && gp.player.worldX / 64 <= limiteDer && dronY < limiteAb && !subida && !limite){
            speed -= 10;
        }
        else if (gp.player.worldX / 64 > limiteDer && dronY > limiteArr || (subida && (gp.player.worldX / 64 >= limiteIzq && gp.player.worldX / 64 <= limiteDer))){
            speed += 10;
            subida = true;
            limite = true;
        }
        if (dronY <= limiteArr){
            tope = true;
        }
        
        
    }

    public void draw(Graphics2D g2, int worldCol, int worldRow, int finalCol, int finalRow) {

        BufferedImage image = null;

        if (spriteNumDron == 1) {
            image = dronImg2;
        }
        if (spriteNumDron == 2) {
            image = dronImg3;
        }
        if (spriteNumDron == 3) {
            image = dronImg4;
        }
        if (spriteNumDron == 4) {
            image = dronImg5;
        }
        if (spriteNumDron == 5) {
            image = dronImg6;
        }
        if (spriteNumDron == 6) {
            image = dronImg7;
        }
        if (spriteNumDron == 7) {
            image = dronImg8;
        }
        if (spriteNumDron == 8) {
            image = dronImg9;
        }
        if (spriteNumDron == 9) {
            image = dronImg10;
        }
        if (spriteNumDron == 10) {
            image = dronImg11;
        }
        if (spriteNumDron == 11) {
            image = dronImg1;
        }
        
        if (tope){
            
            worldCol = finalCol; 
            worldRow = finalRow;
        }

        int worldX = worldCol * gp.tileSize;
        int worldY = worldRow * gp.tileSize;
        dronX = worldX - gp.player.worldX + gp.player.screenX;
        
        if (!tope){
            dronY = worldY - gp.player.worldY + gp.player.screenY - speed;
        } else{
             dronY = worldY - gp.player.worldY + gp.player.screenY;
        }
       
        
        g2.drawImage(image, dronX, dronY, gp.tileSize, gp.tileSize, null);
    }
}
