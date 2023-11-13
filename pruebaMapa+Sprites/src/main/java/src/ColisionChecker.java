/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import entity.Entity;

/**
 *
 * @author w10
 */
public class ColisionChecker {

    GamePanel gp;

    public ColisionChecker(GamePanel gp) {

        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        if (entity.direction == "up" || entity.direction == "up&right" || entity.direction == "up&left") {

            entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

            if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {

                entity.colisionOn = true;
            }
        }
        
        if (entity.direction == "down"){
            
            entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                
                if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true){
                    
                    entity.colisionOn = true;
                }
        }

        if (entity.direction == "left" || entity.direction == "up&left" || entity.direction == "down&left") {
            entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];

            if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {

                entity.colisionOn = true;
            }
        }

        if (entity.direction == "right" || entity.direction == "down&right" || entity.direction == "up&right") {

            entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

            if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {

                entity.colisionOn = true;
            }
        }
    }
}
