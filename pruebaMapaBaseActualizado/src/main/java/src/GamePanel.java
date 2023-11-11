/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tiles.TileManager;

/**
 *
 * @author Alumno
 */
public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTINGS
    public final int tileSize = 64;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 10;
    public  final int screenWidth = tileSize * maxScreenCol;
    public  final int screenHeight = tileSize * maxScreenRow;
    
    // WOLRD SETTINGS
    public final int maxWorldCol = 48;
    public final int maxWorldRow = 30;
    public final int wolrdWidth  = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    // FPS
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public ColisionChecker cChecker = new ColisionChecker(this);
    public Player player = new Player(this, keyH);
    
    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while (gameThread != null){
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            
            lastTime = currentTime;
            
            if (delta >= 1){
                
                update();
                repaint();
                delta--;
            }
        }
    }
    
    public void update(){
        
       player.update();
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        tileM.draw(g2);
        
        player.draw(g2);
        
        g2.dispose();
        
        
    }
}
