package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static main.MainPage.MainStage;
import static main.SettingWindow.selectedMute;

public class GameWin {

    public static Scene WinScene;

    public static Scene display() {

        GameSounds gameSounds = new GameSounds();
        if (selectedMute == "mute_off") {
            gameSounds.stopAllSounds();
            gameSounds.playWinSound();
        }

        Image winImage = new Image("images/GmeWin/win_background.gif");
        ImageView winImageView = new ImageView(winImage);
        winImageView.setFitHeight(757);
        winImageView.setFitWidth(1352);

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

        });

        Pane winPane = new Pane();
        winPane.getChildren().addAll(winImageView, ExitImageImageView);
//        
        Scene WinScene = new Scene(winPane, 1352, 757);
        return WinScene;

    }

}
