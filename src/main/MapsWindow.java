package main;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MapsWindow {

    public static final String Crystal = "Crystal";
    public static final String coralreefs = "coralreefs";
    public static final String horror = "horror";
    public static String selectedbackground = Crystal;

    public static void display(Stage primaryStage, Scene previousScene) {
        // Create root pane for about window
        Pane mapsPane = new Pane();

        GameSounds gameSounds = new GameSounds();

        gameSounds.stopAllSounds();
        gameSounds.playmenuSound();

        Image MuteOff_Button_image = new Image("images/Buttons/Close.png");
        ImageView Close_Button_imageview = new ImageView(MuteOff_Button_image);
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
        });

        Close_Button_imageview.setOnMouseExited(event -> {

            Close_Button_imageview.setImage(MuteOff_Button_image);
            Close_Button_imageview.setFitWidth(200);
            Close_Button_imageview.setFitHeight(200);
            Close_Button_imageview.setX(Close_x);
            Close_Button_imageview.setY(Close_y);

        });

        Image im_Mapstext = new Image("images/Maps/Mapstext.png");
        ImageView imv_Mapstext = new ImageView(im_Mapstext);
        imv_Mapstext.setX(490);
        imv_Mapstext.setY(55);
        imv_Mapstext.setFitWidth(400);
        imv_Mapstext.setFitHeight(190);

        Image im_Crystal = new Image("images/Maps/Back1_on.png");
        ImageView imv_Crystal = new ImageView(im_Crystal);
        imv_Crystal.setX(440);
        imv_Crystal.setY(200);
        imv_Crystal.setFitWidth(200);
        imv_Crystal.setFitHeight(130);

        Image im_horror = new Image("images/Maps/Back2.png");
        ImageView imv_horror = new ImageView(im_horror);
        imv_horror.setX(440);
        imv_horror.setY(330);
        imv_horror.setFitWidth(200);
        imv_horror.setFitHeight(130);

        Image im_coralreefs = new Image("images/Maps/Back3.png");
        ImageView imv_coralreefs = new ImageView(im_coralreefs);
        imv_coralreefs.setX(440);
        imv_coralreefs.setY(460);
        imv_coralreefs.setFitWidth(200);
        imv_coralreefs.setFitHeight(130);

        //create buttons of choose character
        Image im_CrystalBtn = new Image("images/Maps/Crystal.png");
        ImageView imv_CrystalBtn = new ImageView(im_CrystalBtn);
        imv_CrystalBtn.setOnMouseClicked(e -> {
            imv_Crystal.setImage(new Image("images/Maps/Back1_on.png"));
            imv_horror.setImage(new Image("images/Maps/Back2.png"));
            imv_coralreefs.setImage(new Image("images/Maps/Back3.png"));
            selectedbackground = Crystal;
            //System.out.println(selectedbackground);
        });
        imv_CrystalBtn.setOnMouseEntered(e -> {
            imv_CrystalBtn.setImage(new Image("images/Maps/Crystal_on.png"));
        });
        imv_CrystalBtn.setOnMouseExited(e -> {
            imv_CrystalBtn.setImage(new Image("images/Maps/Crystal.png"));
        });
        imv_CrystalBtn.setX(710);
        imv_CrystalBtn.setY(155);
        imv_CrystalBtn.setFitWidth(260);
        imv_CrystalBtn.setFitHeight(200);

        Image im_horrorBtn = new Image("images/Maps/Horror.png");
        ImageView imv_horrorBtn = new ImageView(im_horrorBtn);
        imv_horrorBtn.setOnMouseClicked(e -> {
            imv_horror.setImage(new Image("images/Maps/Back2_on.png"));
            imv_Crystal.setImage(new Image("images/Maps/Back1.png"));
            imv_coralreefs.setImage(new Image("images/Maps/Back3.png"));
            selectedbackground = horror;
            //System.out.println(selectedbackground);
        });
        imv_horrorBtn.setOnMouseEntered(e -> {
            imv_horrorBtn.setImage(new Image("images/Maps/Horror_on.png"));
        });
        imv_horrorBtn.setOnMouseExited(e -> {
            imv_horrorBtn.setImage(new Image("images/Maps/Horror.png"));

        });
        imv_horrorBtn.setX(710);
        imv_horrorBtn.setY(290);
        imv_horrorBtn.setFitWidth(260);
        imv_horrorBtn.setFitHeight(200);

        Image im_coralreefsBtn = new Image("images/Maps/Coralreefs.png");
        ImageView imv_coralreefsBtn = new ImageView(im_coralreefsBtn);
        imv_coralreefsBtn.setOnMouseClicked(e -> {
            imv_coralreefs.setImage(new Image("images/Maps/Back3_on.png"));
            imv_Crystal.setImage(new Image("images/Maps/Back1.png"));
            imv_horror.setImage(new Image("images/Maps/Back2.png"));

            selectedbackground = coralreefs;
            //System.out.println(selectedbackground);
        });
        imv_coralreefsBtn.setOnMouseEntered(e -> {
            imv_coralreefsBtn.setImage(new Image("images/Maps/Coralreefs_on.png"));
        });
        imv_coralreefsBtn.setOnMouseExited(e -> {
            imv_coralreefsBtn.setImage(new Image("images/Maps/Coralreefs.png"));
        });
        imv_coralreefsBtn.setX(710);
        imv_coralreefsBtn.setY(425);
        imv_coralreefsBtn.setFitWidth(260);
        imv_coralreefsBtn.setFitHeight(200);

        if (selectedbackground == "Crystal") {
            imv_coralreefs.setImage(new Image("images/Maps/Back3.png"));
            imv_Crystal.setImage(new Image("images/Maps/Back1_on.png"));
            imv_horror.setImage(new Image("images/Maps/Back2.png"));
        }
        if (selectedbackground == "horror") {
            imv_coralreefs.setImage(new Image("images/Maps/Back3.png"));
            imv_Crystal.setImage(new Image("images/Maps/Back1.png"));
            imv_horror.setImage(new Image("images/Maps/Back2_on.png"));

        }
        if (selectedbackground == "coralreefs") {
            imv_coralreefs.setImage(new Image("images/Maps/Back3_on.png"));
            imv_Crystal.setImage(new Image("images/Maps/Back1.png"));
            imv_horror.setImage(new Image("images/Maps/Back2.png"));
        }

        Image im_Maps_BackGround = new Image("images/Maps/MapsBackGround.jpg");
        ImageView imv_Maps_BackGround = new ImageView(im_Maps_BackGround);

        mapsPane.getChildren().addAll(imv_Maps_BackGround, imv_Mapstext, Close_Button_imageview, imv_Crystal, imv_coralreefs, imv_horror, imv_CrystalBtn, imv_horrorBtn, imv_coralreefsBtn);

        Scene MapsScene = new Scene(mapsPane, 1352, 757); // Set width and height

        // Create stage for about window
        primaryStage.setScene(MapsScene);
    }
}
