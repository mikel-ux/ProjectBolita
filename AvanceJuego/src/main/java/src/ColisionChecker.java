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
    public int tileOn1, tileOn2, tileLeft1, tileLeft2, tileRight1, tileRight2, tileDown1, tileDown2;

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

        entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
        tileOn1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        tileOn2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];

        if (gp.tileM.tile[tileOn1].colision == true || gp.tileM.tile[tileOn2].colision == true) {
            entity.colisionDown = true;
        }

        //Toca desde arriba
        entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
        tileDown1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        tileDown2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];

        if (gp.tileM.tile[tileDown1].colision == true || gp.tileM.tile[tileDown2].colision == true) {
            entity.colisionOn = true;
        }

        //Toca desde la derecha
        entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
        tileLeft1 = gp.tileM.mapTileNum[entityLeftCol2][entityTopRow2];
        tileLeft2 = gp.tileM.mapTileNum[entityLeftCol2][entityBottomRow2];

        if (gp.tileM.tile[tileLeft1].colision == true || gp.tileM.tile[tileLeft2].colision == true) {
            entity.colisionRight = true;
        }

        //Toca desde la izquierda
        entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
        tileRight1 = gp.tileM.mapTileNum[entityRightCol2][entityTopRow2];
        tileRight2 = gp.tileM.mapTileNum[entityRightCol2][entityBottomRow2];

        if (gp.tileM.tile[tileRight1].colision == true || gp.tileM.tile[tileRight2].colision == true) {
            entity.colisionLeft = true;
        }

    }
}
