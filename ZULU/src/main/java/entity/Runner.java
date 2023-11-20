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
public class Runner extends Entity {

    GamePanel gp;

    // Estado de alerta para sprites
    boolean warning = false;
    // Tiempo de vision por cada lado
    int timerLook = 0;

    public Runner(GamePanel gp) {

        this.gp = gp;

        solidArea_vertical = new Rectangle(enemyX, enemyY, 42, 42);

        getRunnerImage();
        setDefaultValues();
    }

    public void setDefaultValues() {

        enemyX = 0;
        enemyY = 0;
        directionRight = true;
        warning = false;
        speed = 0;
    }

    private void getRunnerImage() {

        try {
            // Imagenes mirando hacia derecha
            File file = new File("src/main/java/imgRunner/standRunnerRight1.png");
            FileInputStream fis = new FileInputStream(file);
            this.standRunnerRight1 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerRight2.png");
            fis = new FileInputStream(file);
            this.standRunnerRight2 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerRight3.png");
            fis = new FileInputStream(file);
            this.standRunnerRight3 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerRight4.png");
            fis = new FileInputStream(file);
            this.standRunnerRight4 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerRight5.png");
            fis = new FileInputStream(file);
            this.standRunnerRight5 = ImageIO.read(fis);

            // Imagenes mirando hacia izquierda
            file = new File("src/main/java/imgRunner/standRunnerLeft1.png");
            fis = new FileInputStream(file);
            this.standRunnerLeft1 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerLeft2.png");
            fis = new FileInputStream(file);
            this.standRunnerLeft2 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerLeft3.png");
            fis = new FileInputStream(file);
            this.standRunnerLeft3 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerLeft4.png");
            fis = new FileInputStream(file);
            this.standRunnerLeft4 = ImageIO.read(fis);

            file = new File("src/main/java/imgRunner/standRunnerLeft5.png");
            fis = new FileInputStream(file);
            this.standRunnerLeft5 = ImageIO.read(fis);
            
            // Imagenes para movimiento derecha
            file = new File("src/main/java/imgRunner/rightRunner1.png");
            fis = new FileInputStream(file);
            this.runRunnerRight1 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/rightRunner2.png");
            fis = new FileInputStream(file);
            this.runRunnerRight2 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/rightRunner3.png");
            fis = new FileInputStream(file);
            this.runRunnerRight3 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/rightRunner4.png");
            fis = new FileInputStream(file);
            this.runRunnerRight4 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/rightRunner5.png");
            fis = new FileInputStream(file);
            this.runRunnerRight5 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/rightRunner6.png");
            fis = new FileInputStream(file);
            this.runRunnerRight6 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/rightRunner7.png");
            fis = new FileInputStream(file);
            this.runRunnerRight7 = ImageIO.read(fis);
            
            // Imagenes para movimiento izquierda
            file = new File("src/main/java/imgRunner/leftRunner1.png");
            fis = new FileInputStream(file);
            this.runRunnerLeft1 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/leftRunner2.png");
            fis = new FileInputStream(file);
            this.runRunnerLeft2 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/leftRunner3.png");
            fis = new FileInputStream(file);
            this.runRunnerLeft3 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/leftRunner4.png");
            fis = new FileInputStream(file);
            this.runRunnerLeft4 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/leftRunner5.png");
            fis = new FileInputStream(file);
            this.runRunnerLeft5 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/leftRunner6.png");
            fis = new FileInputStream(file);
            this.runRunnerLeft6 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgRunner/leftRunner7.png");
            fis = new FileInputStream(file);
            this.runRunnerLeft7 = ImageIO.read(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int limiteIzq, int limiteDer, int limiteAb, int limiteArr) {

        spriteCounterRunner++;

        if (spriteCounterRunner > 6) {

            // Animación para movimiento normal
            switch (spriteNumRunner) {

                case 1 ->
                    spriteNumRunner = 2;
                case 2 ->
                    spriteNumRunner = 3;
                case 3 ->
                    spriteNumRunner = 4;
                case 4 ->
                    spriteNumRunner = 5;
                case 5 ->
                    spriteNumRunner = 1;
            }

            switch (spriteRunRunner) {

                case 1 ->
                    spriteRunRunner = 2;
                case 2 ->
                    spriteRunRunner = 3;
                case 3 ->
                    spriteRunRunner = 4;
                case 4 ->
                    spriteRunRunner = 5;
                case 5 ->
                    spriteRunRunner = 6;
                case 6 ->
                    spriteRunRunner = 7;
                case 7 ->
                    spriteRunRunner = 1;
            }

            spriteCounterRunner = 0;
        }

        // --------------------------------------- DIRECCION MIRADA ----------------------------------------- //
        if (!gp.player.muerte_individual(this)) {
            timerLook++;

            if (timerLook < 100) {
                directionRight = true;
            } else if (timerLook < 200) {
                directionRight = false;
            } else {
                timerLook = 0;
            }

            // ---------------------------------------- MOVIMIENTO ---------------------------------------------- //
            if (gp.player.worldX / 64 <= limiteDer - 8 && gp.player.worldX / 64 >= limiteIzq
                    && gp.player.worldY / 64 <= limiteAb && gp.player.worldY / 64 >= limiteArr) {

                if (((enemyX + gp.player.worldX + solidArea_vertical.width) / 64) <= limiteDer && directionRight) {
                    if (gp.player.screenX > enemyX) {
                        timerLook = 0;
                        speed -= 8;
                        warning = true;
                    } else {
                        warning = false;
                    }
                } else {
                    directionRight = false;
                }

                if (!directionRight && ((enemyX + gp.player.worldX - solidArea_vertical.width) / 64) >= limiteIzq) {
                    if (gp.player.screenX < enemyX) {
                        timerLook = 100;
                        speed += 8;
                        warning = true;
                    } else {
                        warning = false;
                    }
                } else {
                    directionRight = true;
                }
            } else{
                warning = false;
            }
        }
    }

    public void draw(Graphics2D g2, int worldCol, int worldRow) {

        BufferedImage image = null;

        if (!warning) {
            // Sprites para stand direccion derecha
            if (directionRight) {

                if (spriteNumRunner == 1) {
                    image = standRunnerRight1;
                }
                if (spriteNumRunner == 2) {
                    image = standRunnerRight2;
                }
                if (spriteNumRunner == 3) {
                    image = standRunnerRight3;
                }
                if (spriteNumRunner == 4) {
                    image = standRunnerRight4;
                }
                if (spriteNumRunner == 5) {
                    image = standRunnerRight5;
                }
            // Sprites para stand direccion izquierda
            } else {

                if (spriteNumRunner == 1) {
                    image = standRunnerLeft1;
                }
                if (spriteNumRunner == 2) {
                    image = standRunnerLeft2;
                }
                if (spriteNumRunner == 3) {
                    image = standRunnerLeft3;
                }
                if (spriteNumRunner == 4) {
                    image = standRunnerLeft4;
                }
                if (spriteNumRunner == 5) {
                    image = standRunnerLeft5;
                }
            }
        } else{
            // Sprites para movimiento direccion derecha
            if (directionRight) {

                if (spriteRunRunner == 1) {
                    image = runRunnerRight1;
                }
                if (spriteRunRunner == 2) {
                    image = runRunnerRight2;
                }
                if (spriteRunRunner == 3) {
                    image = runRunnerRight3;
                }
                if (spriteRunRunner == 4) {
                    image = runRunnerRight4;
                }
                if (spriteRunRunner == 5) {
                    image = runRunnerRight5;
                }
                if (spriteRunRunner == 6) {
                    image = runRunnerRight6;
                }
                if (spriteRunRunner == 7) {
                    image = runRunnerRight7;
                }
            // Sprites para movimiento direccion izquierda
            } else {

                if (spriteRunRunner == 1) {
                    image = runRunnerLeft1;
                }
                if (spriteRunRunner == 2) {
                    image = runRunnerLeft2;
                }
                if (spriteRunRunner == 3) {
                    image = runRunnerLeft3;
                }
                if (spriteRunRunner == 4) {
                    image = runRunnerLeft4;
                }
                if (spriteRunRunner == 5) {
                    image = runRunnerLeft5;
                }
                if (spriteRunRunner == 6) {
                    image = runRunnerLeft6;
                }
                if (spriteRunRunner == 7) {
                    image = runRunnerLeft7;
                }
            }
        }

        int worldX = worldCol * gp.tileSize;
        int worldY = worldRow * gp.tileSize;
        enemyX = worldX - gp.player.worldX + gp.player.screenX - speed;
        enemyY = worldY - gp.player.worldY + gp.player.screenY;

        g2.drawImage(image, enemyX, enemyY, gp.tileSize, gp.tileSize, null);
    }
}
