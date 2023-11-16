/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import src.GamePanel;
import src.KeyHandler;
import static java.awt.Color.*;

/**
 *
 * @author w10
 */
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    // Variables para gravedad
    int saltosec;
    boolean maxalt;
    boolean finsalto = false;
    
    // Bloqueo de teclas al morir
    public boolean bloqueo = false;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea_vertical = new Rectangle();
        solidArea_vertical.x = 16;
        solidArea_vertical.y = 0;
        solidArea_vertical.width = 24;
        solidArea_vertical.height = 60;

        solidArea_horizontal = new Rectangle();
        solidArea_horizontal.x = 0;
        solidArea_horizontal.y = 16;
        solidArea_horizontal.width = 60;
        solidArea_horizontal.height = 24;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 17;
        worldY = gp.tileSize * 15;
        gp.direccion_image = 0;
        speed = 4;
        direction = "stand";
        reference = "right";
    }

    private void getPlayerImage() {

        // Todos los sprites almacenados
        try {
            // Imagenes derecha
            File file = new File("src/main/java/imgPlayer/right1.png");
            FileInputStream fis = new FileInputStream(file);
            this.right1 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right2.png");
            fis = new FileInputStream(file);
            this.right2 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right3.png");
            fis = new FileInputStream(file);
            this.right3 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right4.png");
            fis = new FileInputStream(file);
            this.right4 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right5.png");
            fis = new FileInputStream(file);
            this.right5 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right6.png");
            fis = new FileInputStream(file);
            this.right6 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right7.png");
            fis = new FileInputStream(file);
            this.right7 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right8.png");
            fis = new FileInputStream(file);
            this.right8 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/right9.png");
            fis = new FileInputStream(file);
            this.right9 = ImageIO.read(fis);

            // Imagenes izquierda
            file = new File("src/main/java/imgPlayer/left1.png");
            fis = new FileInputStream(file);
            this.left1 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left2.png");
            fis = new FileInputStream(file);
            this.left2 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left3.png");
            fis = new FileInputStream(file);
            this.left3 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left4.png");
            fis = new FileInputStream(file);
            this.left4 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left5.png");
            fis = new FileInputStream(file);
            this.left5 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left6.png");
            fis = new FileInputStream(file);
            this.left6 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left7.png");
            fis = new FileInputStream(file);
            this.left7 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left8.png");
            fis = new FileInputStream(file);
            this.left8 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/left9.png");
            fis = new FileInputStream(file);
            this.left9 = ImageIO.read(fis);

            // Imagenes quieto derecha
            file = new File("src/main/java/imgPlayer/stand1.png");
            fis = new FileInputStream(file);
            this.stand1 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand2.png");
            fis = new FileInputStream(file);
            this.stand2 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand3.png");
            fis = new FileInputStream(file);
            this.stand3 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand4.png");
            fis = new FileInputStream(file);
            this.stand4 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand5.png");
            fis = new FileInputStream(file);
            this.stand5 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand6.png");
            fis = new FileInputStream(file);
            this.stand6 = ImageIO.read(fis);

            // Imagenes quieto izquierda
            file = new File("src/main/java/imgPlayer/stand_left1.png");
            fis = new FileInputStream(file);
            this.stand_left1 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand_left2.png");
            fis = new FileInputStream(file);
            this.stand_left2 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand_left3.png");
            fis = new FileInputStream(file);
            this.stand_left3 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand_left4.png");
            fis = new FileInputStream(file);
            this.stand_left4 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand_left5.png");
            fis = new FileInputStream(file);
            this.stand_left5 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/stand_left6.png");
            fis = new FileInputStream(file);
            this.stand_left6 = ImageIO.read(fis);

            // Imagenes salto derecha
            file = new File("src/main/java/imgPlayer/jump_right4.png");
            fis = new FileInputStream(file);
            this.up_right4 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/jump_right5.png");
            fis = new FileInputStream(file);
            this.up_right5 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/jump_right6.png");
            fis = new FileInputStream(file);
            this.up_right6 = ImageIO.read(fis);

            // Imagenes salto izquierda
            file = new File("src/main/java/imgPlayer/jump_left4.png");
            fis = new FileInputStream(file);
            this.up_left4 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/jump_left5.png");
            fis = new FileInputStream(file);
            this.up_left5 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/jump_left6.png");
            fis = new FileInputStream(file);
            this.up_left6 = ImageIO.read(fis);

            // Imagenes caída derecha
            file = new File("src/main/java/imgPlayer/fall_right1.png");
            fis = new FileInputStream(file);
            this.fall_right1 = ImageIO.read(fis);

            // Imagenes caída izquierda
            file = new File("src/main/java/imgPlayer/fall_left1.png");
            fis = new FileInputStream(file);
            this.fall_left1 = ImageIO.read(fis);

            // Imágenes regeneración y muerte derecha
            file = new File("src/main/java/imgPlayer/death1.png");
            fis = new FileInputStream(file);
            this.death1 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death2.png");
            fis = new FileInputStream(file);
            this.death2 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death3.png");
            fis = new FileInputStream(file);
            this.death3 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death4.png");
            fis = new FileInputStream(file);
            this.death4 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death5.png");
            fis = new FileInputStream(file);
            this.death5 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death6.png");
            fis = new FileInputStream(file);
            this.death6 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death7.png");
            fis = new FileInputStream(file);
            this.death7 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death8.png");
            fis = new FileInputStream(file);
            this.death8 = ImageIO.read(fis);

            // Imágenes regeneración y muerte izquierda
            file = new File("src/main/java/imgPlayer/death_left1.png");
            fis = new FileInputStream(file);
            this.death_left1 = ImageIO.read(fis);

            file = new File("src/main/java/imgPlayer/death_left2.png");
            fis = new FileInputStream(file);
            this.death_left2 = ImageIO.read(fis);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void update() {

        // Controles
        // Arriba
        if (keyH.up == true) {
            direction = "up";
        }
        // Izquierda
        if (keyH.left == true) {
            direction = "left";
            reference = direction;
        }
        // Derecha
        if (keyH.right == true) {
            direction = "right";
            reference = direction;
        }

        // Reseteo de sprites para salto
        if (keyH.right && !keyH.up || keyH.left && !keyH.up) {
            spriteJump = 1;
        }

        // Arriba derecha
        if (keyH.up && keyH.right) {
            direction = "up&right";
            reference = "right";
        }
        // Arriba izquierda
        if (keyH.up && keyH.left) {
            direction = "up&left";
            reference = "left";
        }
        // Quieto derecha
        if (!keyH.up && !keyH.down && !keyH.left && !keyH.right && ("right".equals(reference) || "up&right".equals(reference))) {
            direction = "stand";
            spriteNum = 1;
            spriteJump = 1;
        }
        // Quieto izquierda
        if (!keyH.up && !keyH.down && !keyH.left && !keyH.right && ("left".equals(reference) || "up&left".equals(reference))) {
            direction = "stand_left";
            spriteNum = 1;
            spriteJump = 1;
        }

        // ---------------------------------------- GRAVEDAD ---------------------------------------------------------- //
        //si el jugador no esta tocando el piso
        if (colisionOn == false && !bloqueo) {
            worldY += speed * 2;
        }

        //pisa el piso
        if (colisionOn == true) {
            saltosec = 0;
            maxalt = false;
            finsalto = false;
        }

        if (keyH.up == true && maxalt == false && finsalto == false && !bloqueo) {
            //worldY -= speed;

            if ("up".equals(direction) && !colisionDown) {
                worldY -= speed * 4;
            }

            if ("up&right".equals(direction) && !colisionDown) {
                worldY -= speed * 4;
            }

            if ("up&left".equals(direction) && !colisionDown) {
                worldY -= speed * 4;
            }

            saltosec++;

            if (saltosec == 30) {
                maxalt = true;
            }

        }

        if (keyH.up == false || colisionDown) {
            finsalto = true;
        }

        // -------------------------------------- COLISIONES Y DIRECCIONES-------------------------------------------- //
        colisionOn = false;
        colisionLeft = false;
        colisionDown = false;
        colisionRight = false;

        gp.cChecker.checkTile(this);

        //se ejecuta siempre
        switch (direction) {
            case "left":

                if (!colisionRight && !bloqueo) {
                    worldX -= speed;
                }
                break;

            case "right":

                if (!colisionLeft && !bloqueo) {

                    worldX += speed;
                }
                break;

            case "up&right":
                if (!colisionLeft && !bloqueo) {
                    worldX += speed;
                }
                break;

            case "up&left":
                if (!colisionRight && !bloqueo) {
                    worldX -= speed;
                }
                break;
        }

        // ------------------------------------- ANIMACIONES PJ PRINCIPAL ------------------------------------------ //
        spriteCounter++;

        if (spriteCounter > 6) {

            // Animación para movimiento normal
            switch (spriteNum) {

                case 1 ->
                    spriteNum = 2;
                case 2 ->
                    spriteNum = 3;
                case 3 ->
                    spriteNum = 4;
                case 4 ->
                    spriteNum = 5;
                case 5 ->
                    spriteNum = 6;
                case 6 ->
                    spriteNum = 7;
                case 7 ->
                    spriteNum = 8;
                case 8 ->
                    spriteNum = 9;
                case 9 ->
                    spriteNum = 1;
            }
            // Animación para cuando está quieto
            switch (spriteStand) {

                case 1 ->
                    spriteStand = 2;
                case 2 ->
                    spriteStand = 3;
                case 3 ->
                    spriteStand = 4;
                case 4 ->
                    spriteStand = 5;
                case 5 ->
                    spriteStand = 6;
                case 6 ->
                    spriteStand = 7;
                case 7 ->
                    spriteStand = 8;
                case 8 ->
                    spriteStand = 9;
                case 9 ->
                    spriteStand = 1;
            }
            // Animación para salto
            switch (spriteJump) {

                case 1 ->
                    spriteJump = 2;
                case 2 ->
                    spriteJump = 3;
                case 3 ->
                    spriteJump = 4;
                case 4 ->
                    spriteJump = 5;
                case 5 ->
                    spriteJump = 6;
                case 6 ->
                    spriteJump = 7;
                case 7 ->
                    spriteJump = 8;
                case 8 ->
                    spriteJump = 9;
                case 9 ->
                    spriteJump = 1;
            }

            if (muerte() || victoria()) {
                
                switch (spriteDeath) {

                    case 1 ->
                        spriteDeath = 2;
                    case 2 ->
                        spriteDeath = 3;
                    case 3 ->
                        spriteDeath = 4;
                    case 4 ->
                        spriteDeath = 5;
                    case 5 ->
                        spriteDeath = 6;
                    case 6 ->
                        spriteDeath = 7;
                    case 7 ->
                        spriteDeath = 8;
                    case 8 ->
                        spriteDeath = 9;
                    case 9 ->{
                        if (muerte() && !victoria()){
                            spriteDeath = 1;
                        }
                    }
                }
            }
            if (gp.respawn) {
                switch (spriteRespawn) {

                    case 1 ->
                        spriteRespawn = 2;
                    case 2 ->
                        spriteRespawn = 3;
                    case 3 ->
                        spriteRespawn = 4;
                    case 4 ->
                        spriteRespawn = 5;
                    case 5 ->
                        spriteRespawn = 6;
                    case 6 ->
                        spriteRespawn = 7;
                    case 7 ->
                        spriteRespawn = 8;
                    case 8 ->
                        spriteRespawn = 9;
                    case 9 ->
                        spriteRespawn = 1;
                }
            }

            spriteCounter = 0;
        }
    }

    // Dibujar PJ
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {

            // Sprites para movimiento derecha
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if (spriteNum == 4) {
                    image = right4;
                }
                if (spriteNum == 5) {
                    image = right5;
                }
                if (spriteNum == 6) {
                    image = right6;
                }
                if (spriteNum == 7) {
                    image = right7;
                }
                if (spriteNum == 8) {
                    image = right8;
                }
                if (spriteNum == 9) {
                    image = right9;
                }
                break;
            // Sprites cuando está quieto mirando a la derecha
            case "stand":

                if (spriteStand == 1) {
                    image = stand1;
                }
                if (spriteStand == 2) {
                    image = stand2;
                }
                if (spriteStand == 3) {
                    image = stand3;
                }
                if (spriteStand == 4) {
                    image = stand4;
                }
                if (spriteStand == 5) {
                    image = stand5;
                }
                if (spriteStand == 6) {
                    image = stand6;
                }
                if (spriteStand == 7) {
                    image = stand5;
                }
                if (spriteStand == 8) {
                    image = stand4;
                }
                if (spriteStand == 9) {
                    image = stand3;
                }
                break;

            // Sprites cuando está quieto mirando a la izquierda
            case "stand_left":

                if (spriteStand == 1) {
                    image = stand_left1;
                }
                if (spriteStand == 2) {
                    image = stand_left2;
                }
                if (spriteStand == 3) {
                    image = stand_left3;
                }
                if (spriteStand == 4) {
                    image = stand_left4;
                }
                if (spriteStand == 5) {
                    image = stand_left5;
                }
                if (spriteStand == 6) {
                    image = stand_left6;
                }
                if (spriteStand == 7) {
                    image = stand_left4;
                }
                if (spriteStand == 8) {
                    image = stand_left3;
                }
                if (spriteStand == 9) {
                    image = stand_left2;
                }
                break;
            // Sprites para movimiento izquierda
            case "left":

                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if (spriteNum == 4) {
                    image = left4;
                }
                if (spriteNum == 5) {
                    image = left5;
                }
                if (spriteNum == 6) {
                    image = left6;
                }
                if (spriteNum == 7) {
                    image = left7;
                }
                if (spriteNum == 8) {
                    image = left8;
                }
                if (spriteNum == 9) {
                    image = left9;
                }
                break;

            // Sprites para salto derecha
            case "up&right":

                if (spriteJump == 1) {
                    image = up_right4;
                }
                if (spriteJump == 2) {
                    image = up_right5;
                }
                if (spriteJump >= 3) {
                    image = up_right6;
                }
                break;

            // Sprites para salto izquierda
            case "up&left":
                if (spriteJump == 1) {
                    image = up_left4;
                }
                if (spriteJump == 2) {
                    image = up_left5;
                }
                if (spriteJump >= 3) {
                    image = up_left6;
                }
                break;

            // Sprites para salto recto
            case "up":
                if (reference.equals("right")) {
                    if (spriteJump == 1) {
                        image = up_right4;
                    }
                    if (spriteJump == 2) {
                        image = up_right5;
                    }
                    if (spriteJump >= 3) {
                        image = up_right6;
                    }
                } else if (reference.equals("left")) {

                    if (spriteJump == 1) {
                        image = up_left4;
                    }
                    if (spriteJump == 2) {
                        image = up_left5;
                    }
                    if (spriteJump >= 3) {
                        image = up_left6;
                    }
                }
                break;
        }

        // Sprites para caida
        if (finsalto && !colisionOn || maxalt) {

            if (reference.equals("right")) {

                image = fall_right1;

            } else if (reference.equals("left")) {

                image = fall_left1;
            }
        }

        // Sprites para muerte
        if (muerte() || victoria()) {

            if (reference.equals("right")) {
                if (spriteDeath == 1) {
                    image = death1;
                }
                if (spriteDeath == 2) {
                    image = death2;
                }
            } else if (reference.equals("left")) {

                if (spriteDeath == 1) {
                    image = death_left1;
                }
                if (spriteDeath == 2) {
                    image = death_left2;
                }
            }

            if (spriteDeath == 3) {
                image = death3;
            }
            if (spriteDeath == 4) {
                image = death4;
            }
            if (spriteDeath == 5) {
                image = death5;
            }
            if (spriteDeath == 6) {
                image = death6;
            }
            if (spriteDeath == 7) {
                image = death7;
            }
            if (spriteDeath == 8 || spriteDeath == 9) {
                image = death8;
            }
        }

        if (gp.respawn) {

            if (spriteRespawn == 1) {
                image = death8;
            }
            if (spriteRespawn == 2) {
                image = death7;
            }
            if (spriteRespawn == 3) {
                image = death6;
            }
            if (spriteRespawn == 4) {
                image = death5;
            }
            if (spriteRespawn == 5) {
                image = death5;
            }
            if (spriteRespawn == 6) {
                image = death3;
            }
            if (spriteRespawn == 7) {
                image = death2;
            }
            if (spriteRespawn == 8 || spriteRespawn == 9) {
                image = death1;
            }
        }

        Font fuente = new Font("Arial", Font.BOLD, 15);
        g2.setFont(fuente);
        g2.setColor(WHITE);
        g2.drawString("direccion " + direction + "---Derecha " + colisionRight + "---Izquierda " + colisionLeft + "----Abajo " + colisionDown, 0, 16);
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        g2.draw(solidArea_vertical);
        g2.draw(solidArea_horizontal);
        
        if (muerte()){
            bloqueo = true;
        } else bloqueo = victoria();
    }

    public boolean muerte() {

        boolean reset = false;

        if (gp.cChecker.tileDown1 == 9
                || gp.cChecker.tileDown2 == 9
                || gp.cChecker.tileDown1 == 13
                || gp.cChecker.tileDown2 == 13
                || gp.cChecker.tileRight1 == 15
                || gp.cChecker.tileRight2 == 15) {

            reset = true;
        }
        return reset;
    }
    
    public boolean victoria(){
        
        boolean victoria = false;
        
        if (gp.cChecker.tileRight1 == 16 || gp.cChecker.tileRight2 == 16){
            
            victoria = true;
        }
        
        return victoria;
    }
}
