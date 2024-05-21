package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import static main.SettingWindow.selectedMute;

public class Enemy extends Pane {

    private Image goombaimage = new Image("images/goomba.gif");
    private ImageView goombaimageview = new ImageView(goombaimage);
    private int dx = 1;  //chang in center of goomba image
    private int Xstart;  // X that will start motion from it to xend then return
    private int Xend;  //chang the direction when arrive Xend
    private Timeline goombamotionanimation;

    public Enemy(int startX, int Xend) {
        this.Xstart = startX;
        this.Xend = Xend;
        goombaimageview.setFitWidth(60);
        goombaimageview.setFitHeight(50);
        goombaimageview.setTranslateY(672);
        goombaimageview.setTranslateX(startX);

        getChildren().add(goombaimageview);

        goombamotionanimation = new Timeline(new KeyFrame(Duration.millis(30), e -> {
            goombamotion();
            checkMarioAndGoombaCollision();
        }));
        goombamotionanimation.setCycleCount(Timeline.INDEFINITE);
        goombamotionanimation.play();
    }

    // make goomba moves in specific area
    void goombamotion() {

        if (Xend > goombaimageview.getTranslateX() || goombaimageview.getTranslateX() > Xstart) {
            dx *= -1;
        }
        goombaimageview.setTranslateX(goombaimageview.getTranslateX() - dx);
        goombaimageview.setTranslateX(goombaimageview.getTranslateX() - dx);
    }

    public void checkMarioAndGoombaCollision() {
        // Get the bounds of Mario and the Goomba
        Bounds marioBounds = SuperMario.getMarioimageview().getBoundsInParent();
        Bounds goombaBounds = goombaimageview.getBoundsInParent();

        // Check if there's intersection between Mario and the Goomba, excluding the top area
        double marioRightX = marioBounds.getMaxX();
        double marioLeftX = marioBounds.getMinX();
        double marioBottomY = marioBounds.getMaxY();
        double goombaRightX = goombaBounds.getMaxX();
        double goombaLeftX = goombaBounds.getMinX();
        double goombaTopY = goombaBounds.getMinY();
        double goombaBottomY = goombaBounds.getMaxY();

        // Check if Mario collides with Goomba from any side (right or left)
        if ((marioRightX >= goombaLeftX && marioRightX <= goombaRightX) || (marioLeftX >= goombaLeftX && marioLeftX <= goombaRightX)) {
            if ((marioBottomY >= goombaTopY && marioBottomY <= goombaBottomY)) {

                GameSounds gameSounds = new GameSounds();
                if (selectedMute == "mute_off") {
                    gameSounds.playFallSound();
                }

                SuperMario.resetPalyWindow();
                SuperMario.resetPlayer();
                Hearts.decreaseHearts();

                if (Hearts.getHearts() == 0) {

                    MainPage.MainStage.setScene(GameOver.display());
                    System.out.println("mario died");
                }
            }

        }
        if ((marioBottomY > goombaTopY - 50) && (marioBottomY < goombaTopY) && (marioRightX < goombaRightX + 20) && (marioLeftX > goombaLeftX - 20)) {
            // Mario is above the Goomba, Goomba dies
            goombaimageview.setVisible(false);
            goombaimageview.setTranslateY(0);

            GameSounds gameSounds = new GameSounds();
            if (selectedMute == "mute_off") {
                gameSounds.playCoinSound();
            }

            System.out.println("goomba died");
            Coin.setScore(Coin.getScore() + Coin.getGOOMBA_KILL_SCORE());;
        }

    }

    public static void displayGoomba() {
        int[][] enemyCoordinates = {
            {1568, 1264}, {1928, 1712}, {2424, 2072}, {12592, 12296},
            {3896, 3648}, {3968, 3552}, {5256, 4944},
            {7464, 6440}, {8592, 8240}, {8952, 8736}, {11870, 10390},
            {11870, 10590}, {11800, 10390}, {11870, 11000}, {11800, 10890}
        };

        for (int[] coords : enemyCoordinates) {
            Enemy enemy = new Enemy(coords[0], coords[1]);
            SuperMario.root1.getChildren().add(enemy);
        }
    }

}
