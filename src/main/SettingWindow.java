package main;

import java.awt.Desktop;
import java.net.URI;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingWindow {

    public static final String SUPER_MARIO = "Super Mario";
    public static final String MARIO_LUIGI = "Mario Luigi";
    public static final String FIRE_MARIO_LUIGI = "Fire Mario Luigi";
    public static final String MUTE_ON = "mute_on";
    public static final String MUTE_OFF = "mute_off";
    public static String selectedCharacter = SUPER_MARIO;
    public static String selectedMute = MUTE_OFF;

    public static void display(Stage primaryStage, Scene previousScene) {
        // Create root pane for about window
        Pane settingPane = new Pane();

        GameSounds menuSound3 = new GameSounds();
        if (selectedMute == "mute_off") {
            menuSound3.stopmenuSound();
            menuSound3.playmenuSound();
        }
        //create Close_Button_image
        Image Close_Button_image = new Image("images/Buttons/Close.png");
        ImageView Close_Button_imageview = new ImageView(Close_Button_image);
        int Close_x = 1210;
        int Close_y = -60;
        Close_Button_imageview.setFitWidth(200);
        Close_Button_imageview.setFitHeight(200);
        Close_Button_imageview.setX(Close_x);
        Close_Button_imageview.setY(Close_y);

        Close_Button_imageview.setOnMouseEntered(e -> {
            // Change the image when mouse enters
            Close_Button_imageview.setImage(new Image("images/Buttons/Close_on.png"));

            Close_Button_imageview.setFitWidth(200);
            Close_Button_imageview.setFitHeight(200);
            Close_Button_imageview.setX(Close_x);
            Close_Button_imageview.setY(Close_y);

        });

        Close_Button_imageview.setOnMouseClicked(event -> {

            primaryStage.setScene(previousScene);

            if (selectedMute == "mute_off") {
                menuSound3.stopmenuSound();
                menuSound3.playmenuSound();
            }
        });

        Close_Button_imageview.setOnMouseExited(event -> {

            Close_Button_imageview.setImage(Close_Button_image);
            Close_Button_imageview.setFitWidth(200);
            Close_Button_imageview.setFitHeight(200);
            Close_Button_imageview.setX(Close_x);
            Close_Button_imageview.setY(Close_y);

        });
        //
        //create image of character
        Image im_superMario = new Image("images/Setting/Mario_on.png");
        ImageView imv_superMario = new ImageView(im_superMario);
        imv_superMario.setX(400);
        imv_superMario.setY(300);
        imv_superMario.setFitWidth(200);
        imv_superMario.setFitHeight(230);

        Image im_marioLuigi = new Image("images/Setting/Luigi.png");
        ImageView imv_marioLuigi = new ImageView(im_marioLuigi);
        imv_marioLuigi.setX(570);
        imv_marioLuigi.setY(300);
        imv_marioLuigi.setFitWidth(220);
        imv_marioLuigi.setFitHeight(230);

        Image im_fireMarioLuigi = new Image("images/Setting/F.Mario.png");
        ImageView imv_fireMarioLuigi = new ImageView(im_fireMarioLuigi);
        imv_fireMarioLuigi.setX(740);
        imv_fireMarioLuigi.setY(300);
        imv_fireMarioLuigi.setFitWidth(220);
        imv_fireMarioLuigi.setFitHeight(230);

        //create buttons of choose character
        Image im_superMarioBtn = new Image("images/Setting/Mario_btn.png");
        ImageView imv_superMarioBtn = new ImageView(im_superMarioBtn);
        imv_superMarioBtn.setOnMouseClicked(e -> {
            imv_marioLuigi.setImage(new Image("images/Setting/Luigi.png"));
            imv_fireMarioLuigi.setImage(new Image("images/Setting/F.Mario.png"));
            imv_superMario.setImage(new Image("images/Setting/Mario_on.png"));
            selectedCharacter = SUPER_MARIO;
            //System.out.println(selectedCharacter);
        });
        imv_superMarioBtn.setOnMouseEntered(e -> {
            imv_superMarioBtn.setImage(new Image("images/Setting/Mario_on_btn.png"));
        });
        imv_superMarioBtn.setOnMouseExited(e -> {
            imv_superMarioBtn.setImage(new Image("images/Setting/Mario_btn.png"));
        });
        imv_superMarioBtn.setX(400);
        imv_superMarioBtn.setY(480);
        imv_superMarioBtn.setFitWidth(200);
        imv_superMarioBtn.setFitHeight(160);

        Image im_marioLuigiBtn = new Image("images/Setting/Luigi_btn.png");
        ImageView imv_marioLuigiBtn = new ImageView(im_marioLuigiBtn);
        imv_marioLuigiBtn.setOnMouseClicked(e -> {
            imv_fireMarioLuigi.setImage(new Image("images/Setting/F.Mario.png"));
            imv_superMario.setImage(new Image("images/Setting/Mario.png"));
            imv_marioLuigi.setImage(new Image("images/Setting/Luigi_on.png"));
            selectedCharacter = MARIO_LUIGI;
            //System.out.println(selectedCharacter);
        });
        imv_marioLuigiBtn.setOnMouseEntered(e -> {
            imv_marioLuigiBtn.setImage(new Image("images/Setting/Luigi_on_btn.png"));
        });
        imv_marioLuigiBtn.setOnMouseExited(e -> {
            imv_marioLuigiBtn.setImage(new Image("images/Setting/Luigi_btn.png"));
        });
        imv_marioLuigiBtn.setX(575);
        imv_marioLuigiBtn.setY(480);
        imv_marioLuigiBtn.setFitWidth(200);
        imv_marioLuigiBtn.setFitHeight(160);

        Image im_fireMarioLuigiBtn = new Image("images/Setting/F.Mario_btn.png");
        ImageView imv_fireMarioLuigiBtn = new ImageView(im_fireMarioLuigiBtn);
        imv_fireMarioLuigiBtn.setOnMouseClicked(e -> {
            imv_marioLuigi.setImage(new Image("images/Setting/Luigi.png"));
            imv_superMario.setImage(new Image("images/Setting/Mario.png"));
            imv_fireMarioLuigi.setImage(new Image("images/Setting/F.Mario_on.png"));
            selectedCharacter = FIRE_MARIO_LUIGI;
            //System.out.println(selectedCharacter);
        });
        imv_fireMarioLuigiBtn.setOnMouseEntered(e -> {
            imv_fireMarioLuigiBtn.setImage(new Image("images/Setting/F.Mario_on_btn.png"));
        });
        imv_fireMarioLuigiBtn.setOnMouseExited(e -> {
            imv_fireMarioLuigiBtn.setImage(new Image("images/Setting/F.Mario_btn.png"));
        });
        imv_fireMarioLuigiBtn.setX(750);
        imv_fireMarioLuigiBtn.setY(480);
        imv_fireMarioLuigiBtn.setFitWidth(200);
        imv_fireMarioLuigiBtn.setFitHeight(160);

        //create label "character"
        Image im_charactertext = new Image("images/Setting/charactertext.png");
        ImageView imv_charactertext = new ImageView(im_charactertext);
        imv_charactertext.setX(520);
        imv_charactertext.setY(150);
        imv_charactertext.setFitWidth(360);
        imv_charactertext.setFitHeight(290);

        //////////////////////////////////////////////////////////////////////////////
        //create label "sound"
        Image im_soundtext = new Image("images/Setting/soundtext.png");
        ImageView imv_soundtext = new ImageView(im_soundtext);
        imv_soundtext.setX(550);
        imv_soundtext.setY(5);
        imv_soundtext.setFitWidth(280);
        imv_soundtext.setFitHeight(200);

        //create image of mute_on or mute_of
        Image im_mute_on = new Image("images/Setting/MuteOn.png");
        ImageView imv_mute_on = new ImageView(im_mute_on);
        imv_mute_on.setX(630);
        imv_mute_on.setY(70);
        imv_mute_on.setFitWidth(210);
        imv_mute_on.setFitHeight(210);

        Image im_mute_off = new Image("images/Setting/MuteOff_Clicked.png");
        ImageView imv_mute_off = new ImageView(im_mute_off);
        imv_mute_off.setX(540);
        imv_mute_off.setY(70);
        imv_mute_off.setFitWidth(210);
        imv_mute_off.setFitHeight(210);

        //
        //event handling of sound buttons
        imv_mute_on.setOnMouseClicked(e -> {
            imv_mute_off.setImage(new Image("images/Setting/MuteOff.png"));
            imv_mute_on.setImage(new Image("images/Setting/MuteOn_Clicked.png"));
            selectedMute = MUTE_ON;

            // GameSounds gamesound1 = new GameSounds();
            // gamesound1.stopAllSounds();
        });
        imv_mute_off.setOnMouseClicked(e -> {
            imv_mute_on.setImage(new Image("images/Setting/MuteOn.png"));
            imv_mute_off.setImage(new Image("images/Setting/MuteOff_Clicked.png"));
            selectedMute = "mute_off";
            ///+++sound
        });
        ///////////////////////////
        if (selectedCharacter == "Mario Luigi") {
            imv_fireMarioLuigi.setImage(new Image("images/Setting/F.Mario.png"));
            imv_superMario.setImage(new Image("images/Setting/Mario.png"));
            imv_marioLuigi.setImage(new Image("images/Setting/Luigi_on.png"));
        }
        if (selectedCharacter == "Super Mario") {
            imv_marioLuigi.setImage(new Image("images/Setting/Luigi.png"));
            imv_fireMarioLuigi.setImage(new Image("images/Setting/F.Mario.png"));
            imv_superMario.setImage(new Image("images/Setting/Mario_on.png"));

        }
        if (selectedCharacter == "Fire Mario Luigi") {
            imv_marioLuigi.setImage(new Image("images/Setting/Luigi.png"));
            imv_superMario.setImage(new Image("images/Setting/Mario.png"));
            imv_fireMarioLuigi.setImage(new Image("images/Setting/F.Mario_on.png"));
        }
        if (selectedMute == "mute_on") {
            imv_mute_off.setImage(new Image("images/Setting/MuteOff.png"));
            imv_mute_on.setImage(new Image("images/Setting/MuteOn_Clicked.png"));

        }
        if (selectedMute == "mute_off") {
            imv_mute_on.setImage(new Image("images/Setting/MuteOn.png"));
            imv_mute_off.setImage(new Image("images/Setting/MuteOff_Clicked.png"));

        }

        ///////////////////////////
        //
        //scene and pane and stage
        Image im_Setting_BackGround = new Image("images/Setting/Setting_BackGround.jpg");
        ImageView imv_Setting_BackGround = new ImageView(im_Setting_BackGround);
        Pane Pane_Setting = new Pane();
        Pane_Setting.getChildren().addAll(imv_Setting_BackGround);
        Scene Setting_Scene = new Scene(Pane_Setting, 1352, 757);

        settingPane.getChildren().addAll(imv_Setting_BackGround, Close_Button_imageview, imv_superMario,
                imv_marioLuigi, imv_fireMarioLuigi, imv_superMarioBtn, imv_marioLuigiBtn, imv_fireMarioLuigiBtn,
                 imv_charactertext, imv_soundtext, imv_mute_off, imv_mute_on);

        //
        Scene settingScene = new Scene(settingPane, 1352, 757);

        primaryStage.setScene(settingScene);
    }
}
