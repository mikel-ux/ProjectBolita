/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import entity.Dron;
import entity.Hunter;
import entity.Jumper;
import entity.Player;
import entity.Runner;
import entity.Walker;
import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Font;
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
    public final int maxWorldCol = 140;
    public final int maxWorldRow = 40;
    public final int wolrdWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    public BufferedImage image;
    public int direccion_image = 0;

    public boolean respawn = false;

    // FPS
    int FPS = 60;

    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public ColisionChecker cChecker = new ColisionChecker(this);

    // Todas las entidades
    public Player player = new Player(this, keyH);
    public Dron dron = new Dron(this);
    public Dron dron2 = new Dron(this);
    public Dron dron3 = new Dron(this);
    public Walker walker = new Walker(this);
    public Walker walker2 = new Walker(this);
    public Walker walker3 = new Walker(this);
    public Jumper jumper = new Jumper(this);
    public Jumper jumper2 = new Jumper(this);
    public Jumper jumper3 = new Jumper(this);
    public Jumper jumper4 = new Jumper(this);
    public Runner runner = new Runner(this);
    public Runner runner2 = new Runner(this);
    public Hunter hunter = new Hunter(this);
    public Hunter hunter2 = new Hunter(this);
    public Hunter hunter3 = new Hunter(this);
    
    // Primera carga de nivel
    boolean firstload = false;
    // N° de nivel
    public int curlevel = 1;
    /* Esto es para quitar el último comentario del dron una vez que se completa el nivel. 
    Esto ya que el resto de comentarios son quitados una vez que el jugador excede determinado límite del mapa.*/
    boolean pase = false;
    //estado juego
    public int gameState;
    public final int menuState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int finalState = 3;

    // public Sound sound = new Sound();
    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameState = menuState;
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
            levelmanager();
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
        if (gameState == playState) {

            player.update();

            if (player.muerte_total()) {

                if (player.spriteDeath == 9) {
                    resetAll();
                }
            }
            if (player.victoria()) {
                if (player.spriteDeath == 1) {
                    resetAll();
                }
            }
            if (respawn && player.spriteRespawn == 9) {

                player.spriteRespawn = 1;
                respawn = false;
                player.bloqueo = false;
            }

            if (curlevel == 1) {

                dron.update(4, 10, 150, -500);
                if (dron.tope) {
                    dron.setDefaultValues();
                }
                dron2.update(33, 41, 200, -650);
                if (dron2.tope) {
                    dron2.setDefaultValues();
                }
                dron3.update(49, 56, 150, -700);
                walker.update(63, 71);
            }

            if (curlevel == 2) {

                walker.update(17, 24);
                walker2.update(25, 32);
                walker3.update(45, 52);
                jumper.update();
                dron.update(2, 6, 150, -700);
            }

            if (curlevel == 3) {

                jumper.update();
                jumper2.update();
                jumper3.update();
                jumper4.update();
                runner.update(46, 65, 21, 19);
                dron.update(2, 6, 150, -700);
            }

            if (curlevel == 4) {

                walker.update(39, 45);
                hunter.update(45, 60);
                runner.update(53, 71, 22, 21);
                hunter2.update(71, 84);
                runner2.update(82, 103, 22, 20);
                hunter3.update(109, 120);
                dron.update(2, 6, 150, -700);
            }
        }
    }

    public void info(Graphics g) {
        Font fuente = new Font("Arial", Font.BOLD, 20);
        g.setFont(fuente);
        g.setColor(WHITE);
        g.drawString("Nivel: " + curlevel, screenWidth / 2, 20);

    }

    //Se encarga de manejar que nivel carga el tilemanager si el jugador gana
    public void levelmanager() {

        //primera carga del nivel 1    
        if (firstload == false) {
            tileM.loadMap("src/main/java/maps/map01.txt");
            firstload = true;
        }

        //si el jugador gana
        if (player.victoria() == true && curlevel != 5) {
            
            //aumenta el nivel
            curlevel++;
            //reinicia pocicion del jugador
            player.setDefaultValues();
            
            //carga cada nivel segun el nivel actual
            switch (curlevel) {
                case 1 ->
                    tileM.loadMap("src/main/java/maps/map01.txt");
                case 2 ->{
                    tileM.loadMap("src/main/java/maps/map02.txt");
                    pase = true;
                }
                case 3 ->
                    tileM.loadMap("src/main/java/maps/map03.txt");
                case 4 ->
                    tileM.loadMap("src/main/java/maps/map04.txt");
                case 5 -> {
                    cChecker.tileRight1 = 17;
                    cChecker.tileRight2 = 17;
                    gameState = finalState;
                }
            }
        }
        }

        @Override
        public void paintComponent(Graphics g) {

        super.paintComponent(g);

            drawBackground(g, "src/main/java/imgFondo/backgroundSinArbolGrande.png");

            Graphics2D g2 = (Graphics2D) g;
            info(g2);

            tileM.draw(g2);
            drawComment(g2);
            player.draw(g2);

            if (gameState == pauseState) {

                drawBackground(g, "src/main/java/imgFondo/backgroundSinArbolGrandeOscurecido.png");
                drawPauseScreen(g2);
//            drawBackground(g, "src/main/java/imgFondo/PortadaFija (2).jpg"); 
                g2.dispose();
            }
            if (gameState == menuState) {
                drawMenu(g2);
                g2.dispose();
            }
            if (gameState == finalState) {
                drawBackground(g, "src/main/java/imgFondo/backgroundSinArbolGrandeOscurecido.png");
                drawFinalScreen(g2);
                g2.dispose();
            }
            if (gameState == playState) {

                if (curlevel == 1) {
                    dron.draw(g2, 6, 15, 0, 0);
                    dron2.draw(g2, 37, 10, 0, 0);
                    dron3.draw(g2, 52, 10, 73, 22);
                    walker.draw(g2, 56, 24);
                    //walker.draw(g2);
                }

                if (curlevel == 2) {
                    dron.draw(g2, 79, 23, 79, 23);
                    walker.draw(g2, 11, 24);
                    walker2.draw(g2, 31, 24);
                    walker3.draw(g2, 38, 21);
                    jumper.draw(g2, 68, 20);
                }

                if (curlevel == 3) {

                    jumper.draw(g2, 10, 24);
                    jumper2.draw(g2, 13, 24);
                    jumper3.draw(g2, 16, 24);
                    jumper4.draw(g2, 19, 24);
                    runner.draw(g2, 50, 21);
                    dron.draw(g2, 67, 21, 68, 21);
                }

                if (curlevel == 4) {

                    walker.draw(g2, 32, 20);
                    hunter.draw(g2, 39, 20);
                    runner.draw(g2, 59, 22);
                    hunter2.draw(g2, 64, 22);
                    runner2.draw(g2, 87, 22);
                    hunter3.draw(g2, 102, 21);
                    dron.draw(g2, 118, 19, 118, 19);
                }

                g2.dispose();
            }
        }

    

    public void drawPauseScreen(Graphics2D g2) {

        int x = screenWidth;
        int y = screenHeight;
        drawPicture(g2, "src/main/java/imgFondo/Pausa.png", x / 2 - (232 / 2), (y / 2) - (75 / 2), 232, 75);
        drawPicture(g2, "src/main/java/imgFondo/Salir.png", x / 2 - (162 / 2), (y / 4) * 3, 162, 45);
    }

    public void drawFinalScreen(Graphics2D g) {

        drawPicture(g, "src/main/java/imgFondo/pantallaFinal.png", screenWidth / 2 - 500, screenHeight / 2 - 290, 1000, 580);
    }

    public void drawPicture(Graphics g, String url, int X, int Y, int width, int height) {//dibuja una foto con su dirreccion e su largo e su 
        try {
            File file = new File(url);
            FileInputStream fis = new FileInputStream(file);
            this.image = ImageIO.read(fis);

            // Dibujar la imagen en las coordenadas (0, 0) con el ancho y alto especificados
            g.drawImage(this.image, X, Y, width, height, this);
            setOpaque(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawComment(Graphics2D g) {
        if (curlevel == 1) {
            if (!dron.limite && !dron.subida) {
                drawPicture(g, "src/main/java/imgFondo/comment1white.png", dron.dronX + 64, dron.dronY - 100, 200, 120);
            }
            if (!dron2.limite && dron.limite) {
                drawPicture(g, "src/main/java/imgFondo/comment2white.png", dron2.dronX + 64, dron2.dronY - 100, 200, 120);
            }
            if (!dron3.limite && dron.limite && dron2.limite) {
                drawPicture(g, "src/main/java/imgFondo/comment3white.png", dron3.dronX + 64, dron3.dronY - 100, 200, 120);
            }
            if (dron.limite && dron2.limite && dron3.limite && !pase) {
                drawPicture(g, "src/main/java/imgFondo/comment4white.png", dron3.dronX + 64, dron3.dronY - 100, 200, 120);
            }
        }
    }

    public void drawMenu(Graphics g) {

        drawPicture(g, "src/main/java/imgFondo/Portada.png", screenWidth / 2 - 550, screenHeight / 2 - 320, 1100, 640);
    }

    public void drawBackground(Graphics g, String url) {

        try {
            Dimension tamanio = getSize();

            File file = new File(url);
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

            g.drawImage(this.image, tamanio.width * 2 + direccion_image, 0,
                    tamanio.width, tamanio.height, this);
            setOpaque(false);

            if (keyH.right && !player.colisionLeft && !player.bloqueo && gameState == playState) {
                direccion_image--;

            } else if (keyH.left && !player.colisionRight && !player.bloqueo && gameState == playState) {
                direccion_image++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetAll() {

        player.setDefaultValues();
        hunter.setDefaultValues();
        hunter2.setDefaultValues();
        hunter3.setDefaultValues();
        walker.setDefaultValues();
        walker2.setDefaultValues();
        walker3.setDefaultValues();
        jumper.setDefaultValues();
        jumper2.setDefaultValues();
        jumper3.setDefaultValues();
        jumper4.setDefaultValues();
        dron.setDefaultValues();
        dron2.setDefaultValues();
        dron3.setDefaultValues();
        runner.setDefaultValues();
        runner2.setDefaultValues();

        player.spriteDeath = 1;
        respawn = true;
    }
}
