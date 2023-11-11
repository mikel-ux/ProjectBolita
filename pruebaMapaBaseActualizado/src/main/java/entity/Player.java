/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import src.GamePanel;
import src.KeyHandler;

/**
 *
 * @author w10
 */
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    
    public boolean aire = true;
    int saltosec;
    boolean maxalt;
    boolean finsalto = false;
    boolean colisionPiso;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 60;
        solidArea.height = 60;

        setDefaultValues();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 15;
        speed = 4;
    }

    public void update() {
        
        // Controls
        if (keyH.up == true) {
            direction = "up";
        }
        if (keyH.left == true) {
            direction = "left";
        }
        if (keyH.right == true) {
            direction = "right";
        }
        if (keyH.up && keyH.right){
            
            direction = "up&right";
        }
        if (keyH.up && keyH.left){
            
            direction = "up&left";
        }
        

        if (keyH.up == true || keyH.left == true || keyH.right == true) {

            // CHECK TILE COLISION
            colisionOn = false;
            gp.cChecker.checkTile(this);

            // IF COLISION IS FALSE, PLAYER CAN MOVE
            if (colisionOn == false) {
                
                switch (direction) {

                    case "up" ->
                        worldY -= speed;
                    case "left" ->
                        worldX -= speed;
                    case "right" ->
                        worldX += speed;
                    case "up&right" -> {
                        worldX += speed;
                        worldY -= speed;
                    }
                    case "up&left" -> {
                        worldX -= speed;
                        worldY -= speed;
                    }
                }
            }
        }
    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.white);

        g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
    }
}
