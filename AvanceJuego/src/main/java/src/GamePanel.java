/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import sound.Sound;
import entity.Dron;
import entity.Hunter;
import entity.Player;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import tiles.TileManager;

/**
 *
 * @author Alumno
 */
public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    public final int tileSize = 64;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 10;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // WOLRD SETTINGS
    public final int maxWorldCol = 80;
    public final int maxWorldRow = 36;
    public final int wolrdWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    public BufferedImage image;
    public int direccion_image = 0;

    public boolean respawn = false;

    // FPS
    int FPS = 60;

    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public ColisionChecker cChecker = new ColisionChecker(this);
    public Player player = new Player(this, keyH);
    public Dron dron = new Dron(this);
    public Hunter hunter = new Hunter(this, keyH);

    // public Sound sound = new Sound();

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {

                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {

        player.update();

        if (player.muerte(hunter)) {

            if (player.spriteDeath == 9) {
                dron.setDefaultValues();
                player.setDefaultValues();

                player.spriteDeath = 1;

                respawn = true;
            }
        }
        if (respawn && player.spriteRespawn == 9) {

            respawn = false;
            player.spriteRespawn = 1;
        }

        dron.update();

        hunter.update();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        drawBackground(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);
        player.draw(g2);
        dron.draw(g2);
        hunter.draw(g2);

        g2.dispose();
    }

    public void drawBackground(Graphics g) {

        try {
            Dimension tamanio = getSize();

            File file = new File("src/main/java/imgFondo/backgroundSinArbolGrande.png");
            FileInputStream fis = new FileInputStream(file);
            this.image = ImageIO.read(fis);

            g.drawImage(this.image, direccion_image, 0,
                    tamanio.width, tamanio.height, this);
            setOpaque(false);

            g.drawImage(this.image, tamanio.width + direccion_image, 0,
                    tamanio.width, tamanio.height, this);
            setOpaque(false);

            g.drawImage(this.image, -tamanio.width + direccion_image, 0,
                    tamanio.width, tamanio.height, this);
            setOpaque(false);

            if (keyH.right && !player.colisionLeft && !player.bloqueo) {
                direccion_image--;

            } else if (keyH.left && !player.colisionRight && !player.bloqueo) {
                direccion_image++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void playMusic(int i) { //sera para la musica de fondo
//        sound.setFile(i);
//        sound.play();
//        sound.loop();
//    }
//
//    public void stopMusic() {//este detiene cualquier musica
//        sound.stop();
//    }
//
//    public void playSE(int i) {//este de aca se usa para efectos de audio
//        sound.setFile(i);
//        sound.play();
//    }
}
