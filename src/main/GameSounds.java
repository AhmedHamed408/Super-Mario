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
        File playSound_File = new File("sounds/playsound.mp3");
        playSound_media = new Media(playSound_File.toURI().toString());
        playSound = new MediaPlayer(playSound_media);
        
        File menuSound_File = new File("file:///D:/CSE/My%20C%20Projects/Super-Mario/src/sounds/menusound.mp3");
        menuSound_media = new Media(menuSound_File.toURI().toString());
        menuSound = new MediaPlayer(menuSound_media);
        
        File jumpSound_File = new File("sounds/jumpsound.mp3");        
        jumpSound_media = new Media(jumpSound_File.toURI().toString());
        jumpSound = new MediaPlayer(jumpSound_media);
        
        File coinSound_File = new File("sounds/coinsound.mp3");
        coinSound_media = new Media(coinSound_File.toURI().toString());
        coinSound = new MediaPlayer(coinSound_media);

        File winSound_File = new File("sounds/winsound.mp3");        
        winSound_media = new Media(winSound_File.toURI().toString());
        winSound = new MediaPlayer(winSound_media);
        
       
        File loseSound_File = new File("sounds/losesound.mp3");
        loseSound_media = new Media(loseSound_File.toURI().toString());
        loseSound = new MediaPlayer(loseSound_media);
        
        File levelUpSound_File = new File("sounds/levelsound.mp3");        
        levelUpSound_media = new Media(levelUpSound_File.toURI().toString());
        levelUpSound = new MediaPlayer(levelUpSound_media);

        File fallSound_File = new File("sounds/fallsound.mp3");        
        fallSound_media = new Media(fallSound_File.toURI().toString());
        fallSound = new MediaPlayer(fallSound_media);

        
       
       
    }
    
    public void playplaySound() {
        playSound.stop();
        playSound.play();
    } 
    
    
    public void playmenuSound() {
        menuSound.stop();
        menuSound.play();
    }
    
    
    public void playJumpSound() {
        jumpSound.stop();
        jumpSound.play();
    }
    
    
    public void playCoinSound() {
        coinSound.stop();
        coinSound.play();
    }
    
    
    public void playWinSound() {
        winSound.stop();
        winSound.play();
    }
    
    public void playLoseSound() {
        loseSound.stop();
        loseSound.play();
    }
    
    
    public void playlevelUpSound() {
        levelUpSound.stop();
        levelUpSound.play();
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
        levelUpSound.stop();
        fallSound.stop();
        menuSound.stop();
        playSound.stop();
        
    }
}