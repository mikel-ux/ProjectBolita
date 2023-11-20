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
import src.KeyHandler;

/**
 *
 * @author w10
 */
public class Hunter extends Entity {

    GamePanel gp;
    
    boolean jump = false;
    boolean fall = false;
    int timerJump = 0;

    public Hunter(GamePanel gp) {

        this.gp = gp;

        solidArea_vertical = new Rectangle(enemyX, enemyY, 42, 42);

        getHunterImage();
        setDefaultValues();
    }

    public void setDefaultValues() {

        enemyX = 0;
        enemyY = 0;
        directionRight = true;
        speed = 0;
    }

    public void getHunterImage() {

        try {
            // Imagenes para movimiento derecha
            File file = new File("src/main/java/imgHunter/EnemyHunterWalkRight1.png");
            FileInputStream fis = new FileInputStream(file);
            this.walkHunterRight1 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkRight2.png");
            fis = new FileInputStream(file);
            this.walkHunterRight2 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkRight3.png");
            fis = new FileInputStream(file);
            this.walkHunterRight3 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkRight4.png");
            fis = new FileInputStream(file);
            this.walkHunterRight4 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkRight5.png");
            fis = new FileInputStream(file);
            this.walkHunterRight5 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkRight6.png");
            fis = new FileInputStream(file);
            this.walkHunterRight6 = ImageIO.read(fis);

            // Imagenes para movimiento izquierda
            file = new File("src/main/java/imgHunter/EnemyHunterWalkLeft1.png");
            fis = new FileInputStream(file);
            this.walkHunterLeft1 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkLeft2.png");
            fis = new FileInputStream(file);
            this.walkHunterLeft2 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkLeft3.png");
            fis = new FileInputStream(file);
            this.walkHunterLeft3 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkLeft4.png");
            fis = new FileInputStream(file);
            this.walkHunterLeft4 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkLeft5.png");
            fis = new FileInputStream(file);
            this.walkHunterLeft5 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterWalkLeft6.png");
            fis = new FileInputStream(file);
            this.walkHunterLeft6 = ImageIO.read(fis);

            // Imagenes para salto izquierda
            file = new File("src/main/java/imgHunter/EnemyHunterJumpLeft1.png");
            fis = new FileInputStream(file);
            this.jumpHunterLeft1 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterJumpLeft2.png");
            fis = new FileInputStream(file);
            this.jumpHunterLeft2 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterJumpLeft3.png");
            fis = new FileInputStream(file);
            this.jumpHunterLeft3 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterJumpLeft4.png");
            fis = new FileInputStream(file);
            this.jumpHunterLeft4 = ImageIO.read(fis);

            // Imagenes para salto derecha
            file = new File("src/main/java/imgHunter/EnemyHunterJumpRight1.png");
            fis = new FileInputStream(file);
            this.jumpHunterRight1 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterJumpRight2.png");
            fis = new FileInputStream(file);
            this.jumpHunterRight2 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterJumpRight3.png");
            fis = new FileInputStream(file);
            this.jumpHunterRight3 = ImageIO.read(fis);

            file = new File("src/main/java/imgHunter/EnemyHunterJumpRight4.png");
            fis = new FileInputStream(file);
            this.jumpHunterRight4 = ImageIO.read(fis);
            
            // Imagenes para caida derecha
            file = new File("src/main/java/imgHunter/EnemyHunterFallRight1.png");
            fis = new FileInputStream(file);
            this.fallHunterRight1 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgHunter/EnemyHunterFallRight2.png");
            fis = new FileInputStream(file);
            this.fallHunterRight2 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgHunter/EnemyHunterFallRight3.png");
            fis = new FileInputStream(file);
            this.fallHunterRight3 = ImageIO.read(fis);
            
            // Imagenes para caida izquierda
            file = new File("src/main/java/imgHunter/EnemyHunterFallLeft1.png");
            fis = new FileInputStream(file);
            this.fallHunterLeft1 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgHunter/EnemyHunterFallLeft2.png");
            fis = new FileInputStream(file);
            this.fallHunterLeft2 = ImageIO.read(fis);
            
            file = new File("src/main/java/imgHunter/EnemyHunterFallLeft3.png");
            fis = new FileInputStream(file);
            this.fallHunterLeft3 = ImageIO.read(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void update(int limiteIzq, int limiteDer) {

        spriteCounterHunter++;

        if (spriteCounterHunter > 6) {

            // Animación para movimiento normal
            switch (spriteNumHunter) {

                case 1 ->
                    spriteNumHunter = 2;
                case 2 ->
                    spriteNumHunter = 3;
                case 3 ->
                    spriteNumHunter = 4;
                case 4 ->
                    spriteNumHunter = 5;
                case 5 ->
                    spriteNumHunter = 6;
                case 6 ->
                    spriteNumHunter = 1;
            }

            switch (spriteJumpHunter) {

                case 1 ->
                    spriteJumpHunter = 2;
                case 2 ->
                    spriteJumpHunter = 3;
                case 3 ->
                    spriteJumpHunter = 4;
                case 4 ->
                    spriteJumpHunter = 1;
            }
            
            switch (spriteFallHunter) {

                case 1 ->
                    spriteFallHunter = 2;
                case 2 ->
                    spriteFallHunter = 3;
                case 3 ->
                    spriteFallHunter = 3;
            }

            spriteCounterHunter = 0;
        }

        // ------------------------------- MOVIMIENTO IZQ - DER ----------------------------------- //
        if (!gp.player.muerte_individual(this)) {
            if ((enemyX + gp.player.worldX + solidArea_vertical.width) / 64 < limiteDer && directionRight) {
                speed -= 5;
            } else {
                directionRight = false;
            }

            if (!directionRight && (enemyX + gp.player.worldX - solidArea_vertical.width) / 64 > limiteIzq) {
                speed += 5;
            } else {
                directionRight = true;
            }
        }

        // ------------------------------ SALTO IZQ - DER -------------------------------------- //
        timerJump++;

        if (!gp.player.muerte_individual(this)) {
            if (timerJump >= 70 && timerJump < 110) {
                jump = true;
                speedJump += 4;
            }
            if (timerJump >= 110 && timerJump < 150) {
                fall = true;
                jump = false;
                speedJump -= 4;
            }
            if (timerJump >= 150) {
                jump = false;
                fall = false;
                speedJump = 0;
                spriteNumHunter = 1;
                timerJump = 0;
            }
        }
    }

    public void draw(Graphics2D g2, int worldCol, int worldRow) {

        BufferedImage image = null;

        // Sprites direccion derecha
        if (directionRight) {
            // Caminata normal
            if (!jump) {
                if (spriteNumHunter == 1) {
                    image = walkHunterRight1;
                }
                if (spriteNumHunter == 2) {
                    image = walkHunterRight2;
                }
                if (spriteNumHunter == 3) {
                    image = walkHunterRight3;
                }
                if (spriteNumHunter == 4) {
                    image = walkHunterRight4;
                }
                if (spriteNumHunter == 5) {
                    image = walkHunterRight5;
                }
                if (spriteNumHunter == 6) {
                    image = walkHunterRight6;
                }
                // Salto
            }
            if (jump) {
                image = jumpHunterRight2;
            }
            if (fall) {
                if (spriteFallHunter == 1) {
                    image = fallHunterRight1;
                }
                if (spriteFallHunter == 2) {
                    image = fallHunterRight2;
                }
                if (spriteFallHunter == 3) {
                    image = fallHunterRight3;
                }
            }
            // Sprites dirección izquierda
        } else {
            // Caminata normal
            if (!jump) {
                if (spriteNumHunter == 1) {
                    image = walkHunterLeft1;
                }
                if (spriteNumHunter == 2) {
                    image = walkHunterLeft2;
                }
                if (spriteNumHunter == 3) {
                    image = walkHunterLeft3;
                }
                if (spriteNumHunter == 4) {
                    image = walkHunterLeft4;
                }
                if (spriteNumHunter == 5) {
                    image = walkHunterLeft5;
                }
                if (spriteNumHunter == 6) {
                    image = walkHunterLeft6;
                }
            }
            // Salto
            if (jump) {

                image = jumpHunterLeft2;
            }
            if (fall) {
                if (spriteFallHunter == 1) {
                    image = fallHunterLeft1;
                }
                if (spriteFallHunter == 2) {
                    image = fallHunterLeft2;
                }
                if (spriteFallHunter == 3) {
                    image = fallHunterLeft3;
                }
            }
        }

        int worldX = worldCol * gp.tileSize;
        int worldY = worldRow * gp.tileSize;
        enemyX = worldX - gp.player.worldX + gp.player.screenX - speed;
        enemyY = worldY - gp.player.worldY + gp.player.screenY - speedJump;

        g2.drawImage(image, enemyX, enemyY, gp.tileSize, gp.tileSize, null);
    }
}
