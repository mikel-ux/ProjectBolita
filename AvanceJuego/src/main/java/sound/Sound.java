/* Esta es la clase de musica se debe de crear en src 

    *Se deben usar archivos en formato wav si o si

    *Estos audios deben de estar en 16 Bits

 */
package sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;


public class Sound {

    Clip clip;//se declara el clip que reproducira los ruidos
    URL[] soundURL = new URL[100];//una lista con los ruidos presente en el juego

    public Sound(){//aca se construye y se agregan los audios
        
        soundURL[0] = getClass().getResource("src/main/java/sound/click-124467.wav");
       
        //si se desea mas archivos se debe de crear mas cambiando el numero
        /* Ejemplos
        soundURL[1] = getClass().getResource("../../sfx/sfx_superjumprelease.wav");
         */
        // Inicializar otros URLs si los utilizas
    }

    public void setFile(int i) {//se debe de usar esto para cargar el audio en si
        
        if (soundURL[i] != null) {//si contiene algo el archivo
            try {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);//con esto le pasamos la direccion del URL
                clip = AudioSystem.getClip();//obtiene audio el audio
                clip.open(ais);//lo abre
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("URL de audio en la posición " + i + " es nula.");//en caso de error
        }
    }

    public void play() {
        if (clip != null) {//ejecuta el archivo solo si este tiene algo de informaciona adentro,solo usa este si deseas un fx(efecto sonido)
            clip.start();
        } else {
            System.out.println("El clip de audio no está inicializado.");
        }
    }

    public void loop() {//se usa esta funcion solo si desea usar para la musica de fondo
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } else {
            System.out.println("El clip de audio no está inicializado.");
        }
    }

    public void stop() { //fuerza a detener la musica actual 
        if (clip != null) {
            clip.stop();
        } else {
            System.out.println("El clip de audio no está inicializado.");
        }
    }

}

//Cambios que debes de realizar en el GamePanel 
/* 
    Sound sound = new Sound(); //debes de crear una instancia de clase en gamepanel

  public void playMusic(int i){ //sera para la musica de fondo
    sound.setFile(i);
    sound.play();
    sound.loop();
    }
    
    public void stopMusic(){//este detiene cualquier musica
    sound.stop();
    }
    
    public void playSE(int i){//este de aca se usa para efectos de audio
    sound.setFile(i);
    sound.play();
    }

 */

 /*
Ejemplos de uso:
si estoy en la clase player puedo hacer esto 

    gp.playSE(0);//si usas esto estaras reproduciendo el archivo indicandole que use el que sea el numero 1 en la lista por lo que reproduce el superjumprelease

 */
