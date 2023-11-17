/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import src.GamePanel;

/**
 *
 * @author Alumno
 */
public class TileManager {
    
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        
        this.gp = gp;
        
        tile = new Tile[20];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTileImage();
        loadMap("src/main/java/maps/map01.txt");
    }
    
    private void getTileImage(){
        
        try{
            
            File file = new File("src/main/java/imgTiles/IzquierdoPastoBloque.png");
            FileInputStream fis = new FileInputStream(file);
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(fis);
            
            file = new File("src/main/java/imgTiles/IzquierdoPastoBloque.png");
            fis = new FileInputStream(file);
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(fis);
            tile[1].colision = true;

            file = new File("src/main/java/imgTiles/PastoBloque.png");
            fis = new FileInputStream(file);
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(fis);
            tile[2].colision = true;
            
            file = new File("src/main/java/imgTiles/DerechaPastoBloque.png");
            fis = new FileInputStream(file);
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(fis);
            tile[3].colision = true;

            file = new File("src/main/java/imgTiles/PlataformaPastoBloque.png");
            fis = new FileInputStream(file);
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(fis);
            tile[4].colision = true;
            
            file = new File("src/main/java/imgTiles/LimiteInferiorBloque.png");
            fis = new FileInputStream(file);
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(fis);
            tile[5].colision = true;
            
            file = new File("src/main/java/imgTiles/SoloLimiteInferiorBloque.png");
            fis = new FileInputStream(file);
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(fis);
            tile[6].colision = true;
            
            file = new File("src/main/java/imgTiles/SoloPastoBloque.png");
            fis = new FileInputStream(file);
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(fis);
            tile[7].colision = true;
            
            file = new File("src/main/java/imgTiles/TierraMedioBloque.png");
            fis = new FileInputStream(file);
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(fis);
            tile[8].colision = true;
            
            file = new File("src/main/java/imgTiles/muerte.png");
            fis = new FileInputStream(file);
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(fis);
            tile[9].colision = true;
            
            file = new File("src/main/java/imgTiles/BloqueSemiOscuro.png");
            fis = new FileInputStream(file);
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(fis);
            
            file = new File("src/main/java/imgTiles/BloqueMetalico.png");
            fis = new FileInputStream(file);
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(fis);
            tile[11].colision = true;
            
            file = new File("src/main/java/imgTiles/piedra.png");
            fis = new FileInputStream(file);
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(fis);
            
            file = new File("src/main/java/imgTiles/pincho.png");
            fis = new FileInputStream(file);
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(fis);
            tile[13].colision = true;
            
            file = new File("src/main/java/imgTiles/tronco.png");
            fis = new FileInputStream(file);
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(fis);
            
            file = new File("src/main/java/imgTiles/pincho_lateral.png");
            fis = new FileInputStream(file);
            tile[15] = new Tile();
            tile[15].image = ImageIO.read(fis);
            tile[15].colision = true;
            
            file = new File("src/main/java/imgTiles/invisible.png");
            fis = new FileInputStream(file);
            tile[16] = new Tile();
            tile[16].image = ImageIO.read(fis);
            tile[16].colision = true;
            
        }catch(IOException e){
            
            e.printStackTrace();
        }
    }
    
    public void loadMap(String filePath){
        
        try{
            
            File is = new File(filePath);
            FileInputStream fis = new FileInputStream(is);
            
            BufferedReader br = new BufferedReader(new FileReader(is));
            
            int col = 0, row = 0;
            
            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                
                String line = br.readLine();
                
                while (col < gp.maxWorldCol){
                    
                    String numbers[] = line.split(" ");
                    
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                
                if (col == gp.maxWorldCol){
                    
                    col = 0;
                    row++;
                }
            }
            
            br.close();
            
        }catch (Exception e){
            
            
        }
    }
    
    public void draw(Graphics2D g2){
        
        int worldCol = 0, worldRow = 0;
        
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            
            int tileNum = mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                
                if (tileNum != 0){
                    g2.drawImage( tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            }
            
            worldCol++;
            
            if (worldCol == gp.maxWorldCol){
                
                worldCol = 0;
                worldRow++;
            }
        }
        
    }
}
