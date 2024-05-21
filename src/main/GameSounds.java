package main;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameSounds {
    private MediaPlayer jumpSound;
    private MediaPlayer coinSound;
    private MediaPlayer winSound;
    private MediaPlayer loseSound;
    private MediaPlayer levelUpSound;
    private MediaPlayer fallSound;
    private MediaPlayer playSound;
    private MediaPlayer menuSound;
    private Media playSound_media;
    private Media menuSound_media;
    private Media jumpSound_media; 
    private Media coinSound_media;  
    private Media winSound_media;
    private Media loseSound_media;
    private Media levelUpSound_media;
    private Media fallSound_media;       
    
    public GameSounds() {
       
        
        playSound_media = new Media("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/playsound.mp3");
        playSound = new MediaPlayer(playSound_media);
        playSound.setCycleCount(playSound.INDEFINITE);
        playSound.setVolume(0.1);
        
        menuSound_media = new Media("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/menusound.mp3");
        menuSound = new MediaPlayer(menuSound_media);
        menuSound.setCycleCount(menuSound.INDEFINITE);
        menuSound.setVolume(0.1);
       
        jumpSound_media = new Media("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/jumpsound.mp3");
        jumpSound = new MediaPlayer(jumpSound_media);
        jumpSound.setVolume(0.5);
        
        coinSound_media = new Media("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/coinsound.mp3");
        coinSound = new MediaPlayer(coinSound_media);
        coinSound.setVolume(0.5); 
           
        winSound_media = new Media("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/winsound.mp3");
        winSound = new MediaPlayer(winSound_media);
        winSound.setVolume(0.5);
       
        
        loseSound_media = new Media("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/losesound.mp3");
        loseSound = new MediaPlayer(loseSound_media);
        loseSound.setVolume(0.5);
       
        
        fallSound_media = new Media("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/fallsound.mp3");
        fallSound = new MediaPlayer(fallSound_media);  
        fallSound.setVolume(0.5);
        
       
       
    }
    
    
    public void playmenuSound() {
        menuSound.play();
    }

    public void stopmenuSound() {

        menuSound.stop();
    }


    public void playJumpSound() {
        jumpSound.stop();
        jumpSound.play();
    }


    public void playCoinSound() {
        coinSound.stop();
        coinSound.play();
    }
    // playplaySound()  playmenuSound    playJumpSound  playCoinSound    playWinSound  playLoseSound   playlevelUpSound   playFallSound   stopAllSounds

    public void playWinSound() {
        winSound.stop();
        winSound.play();
    }

    public void playLoseSound() {
        loseSound.stop();
        loseSound.play();
    }

    public void playFallSound() {
        fallSound.stop();
        fallSound.play();
    }


    public void stopAllSounds() {
        jumpSound.stop();
        coinSound.stop();
        winSound.stop();
        loseSound.stop();
        fallSound.stop();
        menuSound.stop();


    }
}