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

        int entityLeftWorldX = entity.worldX + entity.solidArea_vertical.x;
        int entityRightWorldX = entity.worldX + entity.solidArea_vertical.x + entity.solidArea_vertical.width;
        int entityTopWorldY = entity.worldY + entity.solidArea_vertical.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea_vertical.y + entity.solidArea_vertical.height;
        
        int entityLeftWorldX2 = entity.worldX + entity.solidArea_horizontal.x;
        int entityRightWorldX2 = entity.worldX + entity.solidArea_horizontal.x + entity.solidArea_horizontal.width;
        int entityTopWorldY2 = entity.worldY + entity.solidArea_horizontal.y;
        int entityBottomWorldY2 = entity.worldY + entity.solidArea_horizontal.y + entity.solidArea_horizontal.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;
        
        int entityLeftCol2 = entityLeftWorldX2 / gp.tileSize;
        int entityRightCol2 = entityRightWorldX2 / gp.tileSize;
        int entityTopRow2 = entityTopWorldY2 / gp.tileSize;
        int entityBottomRow2 = entityBottomWorldY2 / gp.tileSize;

        int tileNum1, tileNum2;
//        if (entity.direction == "up" || entity.direction == "up&right" || entity.direction == "up&left") {

       //Toca desde abajo
            entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

            if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {
                entity.colisionDown = true;
            }
       
       //        }
     
            //Toca desde arriba
            entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                
                if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true){
                    entity.colisionOn = true;
                }
        
//if (entity.direction == "left" || entity.direction == "up&left" || entity.direction == "down&left") {
            //Toca desde la derecha
            entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
             tileNum1 = gp.tileM.mapTileNum[entityLeftCol2][entityTopRow2];
            tileNum2 = gp.tileM.mapTileNum[entityLeftCol2][entityBottomRow2];

            if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {
                entity.colisionRight = true;
            }
//}

//if (entity.direction == "right" || entity.direction == "down&right" || entity.direction == "up&right") {

           //Toca desde la izquierda
            entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityRightCol2][entityTopRow2];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol2][entityBottomRow2];

            if (gp.tileM.tile[tileNum1].colision == true || gp.tileM.tile[tileNum2].colision == true) {
                entity.colisionLeft = true;
            }
//}
      
   }
}
