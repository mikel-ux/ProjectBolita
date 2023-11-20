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
public class Jumper extends Entity {

    GamePanel gp;

    boolean charge = true, air = false, fall = false;

    public Jumper(GamePanel gp) {

        this.gp = gp;

        solidArea_vertical = new Rectangle(0, 0, 42, 42);

        setDefaultValues();
        getJumperImage();
    }

    public void setDefaultValues() {

        enemyX = 0;
        enemyY = 0;
        directionRight = false;
        speed = 0;
        charge = true;
        air = false;
        fall = false;
    }

    private void getJumperImage() {

        try {
            // Imagenes salto
            File file = new File("src/main/java/imgJumper/jumperAir1.png");
            FileInputStream fis = new FileInputStream(file);
            this.jumperAir1 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperAir2.png");
            fis = new FileInputStream(file);
            this.jumperAir2 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperAir3.png");
            fis = new FileInputStream(file);
            this.jumperAir3 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperAir4.png");
            fis = new FileInputStream(file);
            this.jumperAir4 = ImageIO.read(fis);

            // Imagenes caida
            file = new File("src/main/java/imgJumper/jumperFall1.png");
            fis = new FileInputStream(file);
            this.jumperFall1 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperFall2.png");
            fis = new FileInputStream(file);
            this.jumperFall2 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperFall3.png");
            fis = new FileInputStream(file);
            this.jumperFall3 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperFall4.png");
            fis = new FileInputStream(file);
            this.jumperFall4 = ImageIO.read(fis);

            // Imagenes de carga salto
            file = new File("src/main/java/imgJumper/jumperCharging1.png");
            fis = new FileInputStream(file);
            this.jumperCharging1 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperCharging2.png");
            fis = new FileInputStream(file);
            this.jumperCharging2 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperCharging3.png");
            fis = new FileInputStream(file);
            this.jumperCharging3 = ImageIO.read(fis);

            file = new File("src/main/java/imgJumper/jumperCharging4.png");
            fis = new FileInputStream(file);
            this.jumperCharging4 = ImageIO.read(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        spriteCounterJumper++;

        if (spriteCounterJumper > 6) {

            // Animación para movimiento normal
            switch (spriteAirJumper) {

                case 1 ->
                    spriteAirJumper = 2;
                case 2 ->
                    spriteAirJumper = 3;
                case 3 ->
                    spriteAirJumper = 4;
                case 4 ->
                    spriteAirJumper = 1;
            }
            switch (spriteChargingJumper) {

                case 1 ->
                    spriteChargingJumper = 2;
                case 2 ->
                    spriteChargingJumper = 3;
                case 3 ->
                    spriteChargingJumper = 4;
                case 4 ->
                    spriteChargingJumper = 1;
            }
            switch (spriteFallJumper) {

                case 1 ->
                    spriteFallJumper = 2;
                case 2 ->
                    spriteFallJumper = 3;
                case 3 ->
                    spriteFallJumper = 4;
                case 4 ->
                    spriteFallJumper = 1;
            }

            spriteCounterJumper = 0;
        }

        // -------------------------------- SALTO ------------------------------------ //
        if (!gp.player.muerte_individual(this)) {
            if (charge && spriteChargingJumper == 4) {
                charge = false;
                fall = false;
                air = true;
                spriteChargingJumper = 1;
                spriteAirJumper = 1;
                spriteFallJumper = 1;
            }
            if (air && spriteAirJumper < 4) {
                speed += 8;
            }
            if (air && spriteAirJumper == 4){
                air = false;
                fall = true;
                charge = false;
                spriteAirJumper = 1;
                spriteChargingJumper = 1;
                spriteFallJumper = 1;
            }
            if (fall && spriteFallJumper < 4) {
                speed -= 8;
            }
            if (fall && spriteFallJumper == 4){
                fall = false;
                air = false;
                charge = true;
                spriteAirJumper = 1;
                spriteChargingJumper = 1;
                spriteFallJumper = 1;
            }
        }
    }

    public void draw(Graphics2D g2, int worldCol, int worldRow) {

        BufferedImage image = null;

        if (air) {
            if (spriteAirJumper == 1) {
                image = jumperAir1;
            }
            if (spriteAirJumper == 2) {
                image = jumperAir2;
            }
            if (spriteAirJumper == 3) {
                image = jumperAir3;
            }
            if (spriteAirJumper == 4) {
                image = jumperAir4;
            }
        } 
        if (fall) {
            if (spriteFallJumper == 1) {
                image = jumperFall1;
            }
            if (spriteFallJumper == 2) {
                image = jumperFall2;
            }
            if (spriteFallJumper == 3) {
                image = jumperFall3;
            }
            if (spriteFallJumper == 4) {
                image = jumperFall4;
            }
        } 
        if (charge) {
            if (spriteChargingJumper == 1) {
                image = jumperCharging1;
            }
            if (spriteChargingJumper == 2) {
                image = jumperCharging2;
            }
            if (spriteChargingJumper == 3) {
                image = jumperCharging3;
            }
            if (spriteChargingJumper == 4) {
                image = jumperCharging4;
            }
        }

        int worldX = worldCol * gp.tileSize;
        int worldY = worldRow * gp.tileSize;
        enemyX = worldX - gp.player.worldX + gp.player.screenX;
        enemyY = worldY - gp.player.worldY + gp.player.screenY - speed;

        g2.drawImage(image, enemyX, enemyY, gp.tileSize, gp.tileSize, null);
    }
}
