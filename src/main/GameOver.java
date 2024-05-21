package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static main.MainPage.MainStage;
import static main.SettingWindow.selectedMute;

public class GameOver {

    public static Scene overScene;

    public static Scene display() {

        GameSounds gameSounds = new GameSounds();
        if (selectedMute == "mute_off") {
            gameSounds.stopAllSounds();
            gameSounds.playLoseSound();
        }

        Image gameoverImage = new Image("images/GameOver/background_gameover.gif");
        ImageView gameoverImageView = new ImageView(gameoverImage);
        gameoverImageView.setFitHeight(757);
        gameoverImageView.setFitWidth(1352);

        Image ExitImage = new Image("images/Buttons/Exit.png");
        ImageView ExitImageImageView = new ImageView(ExitImage);
        ExitImageImageView.setFitHeight(230);
        ExitImageImageView.setFitWidth(280);
        ExitImageImageView.setX(530);
        ExitImageImageView.setY(580);
        ExitImageImageView.setOnMouseEntered(e -> {
            ExitImageImageView.setImage(new Image("images/Buttons/Exit_on.png"));
        });
        ExitImageImageView.setOnMouseExited(e -> {
            ExitImageImageView.setImage(ExitImage);
        });
        ExitImageImageView.setOnMouseClicked(e -> {

            MainPage.logout(MainStage);

            //MainStage.setScene(MainPage.Main_Scene);
        });

        Pane overPane = new Pane();
        overPane.getChildren().addAll(gameoverImageView, ExitImageImageView);
        overScene = new Scene(overPane, 1352, 757); // Set width and height

        return overScene;

    }

}
