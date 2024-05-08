package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class MainPage extends Application {
    
    
     public void logout(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully logged out");
            stage.close();
        }
    }
    private static final String WELCOME_TEXT = "Welcome to Super Mario, hope you enjoy!";
    private static final String Second_TEXT = "Welcome to Super Mario, hope you enjoy!";
    private static final int CHAR_DELAY_MS = 60; // Delay between characters
    private int charIndex = 0;

    @Override
public void start(Stage stage) {
    HBox root = new HBox();
    
    // Set background image
    Image backgroundImage = new Image("images/Intial_BackGround.png");
    
    BackgroundImage backgroundImg = new BackgroundImage(
            backgroundImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            null,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background background = new Background(backgroundImg);
    root.setBackground(background);
    
    Text welcomeText = new Text();
    welcomeText.setFont(Font.loadFont("file:///C://Users//ah456//Downloads//SuperMario256.ttf", 48));
    Color color1 = Color.RED;
    Color color2 = Color.BLUE;

    // Create a linear gradient using the two colors
    LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
            new Stop(0, color1), new Stop(1, color2));

    // Set the gradient as the fill for the text
    welcomeText.setFill(gradient);
    root.setAlignment(Pos.CENTER);
    root.getChildren().add(welcomeText);

    // Create a Timeline to gradually reveal each character
    Timeline timeline = new Timeline();
    timeline.setCycleCount(WELCOME_TEXT.length());
    timeline.getKeyFrames().add(
            new KeyFrame(Duration.millis(CHAR_DELAY_MS), event -> {
                if (charIndex < WELCOME_TEXT.length()) {
                    welcomeText.setText(welcomeText.getText() + WELCOME_TEXT.charAt(charIndex));
                    charIndex++;
                }
            })
    );

    timeline.setOnFinished(event -> {
        // Animation finished, transition to the next scene
        thirdScene(stage);
    });

    timeline.play();

    Scene scene = new Scene(root, 1352, 757);
    stage.setTitle("Super Mario");
    stage.setScene(scene);
     stage.setResizable(false);
    stage.show();
}


    public void thirdScene(Stage Main_Stage) {

        Pane Main_Pane = new Pane();

        Image coin = new Image("images/coin.gif");
        ImageView coinview = new ImageView(coin);
        coinview.setFitWidth(135);
        coinview.setFitHeight(130);
        coinview.setX(500);
        coinview.setY(465);

        Image background_image = new Image("images/BackGround.jpg");
        ImageView background_imageview = new ImageView(background_image);

        /**
         * *****************Play_Button_imageview*********************
         */
        Image Play_Button_image = new Image("images/Buttons/Play.png");
        ImageView Play_Button_imageview = new ImageView(Play_Button_image);
        int Play_x = 820;
        int Play_y = 15;
        Play_Button_imageview.setFitWidth(270);
        Play_Button_imageview.setFitHeight(210);
        Play_Button_imageview.setX(Play_x);
        Play_Button_imageview.setY(Play_y);

        Play_Button_imageview.setOnMouseEntered(event -> {
            Play_Button_imageview.setImage(new Image("images/Buttons/Play_on.png"));
            Play_Button_imageview.setFitWidth(270 + 50);
            Play_Button_imageview.setFitHeight(210 + 50);
            Play_Button_imageview.setX(Play_x);
            Play_Button_imageview.setY(Play_y - 20);
        });

        Play_Button_imageview.setOnMouseExited(e -> {
            Play_Button_imageview.setImage(Play_Button_image);
            Play_Button_imageview.setFitWidth(270);
            Play_Button_imageview.setFitHeight(210);
            Play_Button_imageview.setX(Play_x);
            Play_Button_imageview.setY(Play_y);
        });

        Play_Button_imageview.setOnMouseClicked(event -> {

        });

        /**
         * *****************Setting_Button_image*********************
         */
        Image Setting_Button_image = new Image("images/Buttons/Setting.png");
        ImageView Setting_Button_imageview = new ImageView(Setting_Button_image);
        int Setting_x = 940;
        int Setting_y = 125;
        Setting_Button_imageview.setFitWidth(270);
        Setting_Button_imageview.setFitHeight(210);
        Setting_Button_imageview.setX(Setting_x);
        Setting_Button_imageview.setY(Setting_y);

        Setting_Button_imageview.setOnMouseEntered(event -> {
            Setting_Button_imageview.setImage(new Image("images/Buttons/Setting_on.png"));
            Setting_Button_imageview.setFitWidth(270 + 50);
            Setting_Button_imageview.setFitHeight(210 + 50);
            Setting_Button_imageview.setX(Setting_x);
            Setting_Button_imageview.setY(Setting_y - 20);
        });

        Setting_Button_imageview.setOnMouseExited(e -> {
            Setting_Button_imageview.setImage(Setting_Button_image);
            Setting_Button_imageview.setFitWidth(270);
            Setting_Button_imageview.setFitHeight(210);
            Setting_Button_imageview.setX(Setting_x);
            Setting_Button_imageview.setY(Setting_y);
        });

        Setting_Button_imageview.setOnMouseClicked(event -> {

        });

        /**
         * *****************About_Button_image*********************
         */
        Image About_Button_image = new Image("images/Buttons/About.png");
        ImageView About_Button_imageview = new ImageView(About_Button_image);
        int About_x = 820;
        int About_y = 235;
        About_Button_imageview.setFitWidth(270);
        About_Button_imageview.setFitHeight(210);
        About_Button_imageview.setX(About_x);
        About_Button_imageview.setY(About_y);

        About_Button_imageview.setOnMouseEntered(event -> {
            About_Button_imageview.setImage(new Image("images/Buttons/About_on.png"));
            About_Button_imageview.setFitWidth(270 + 50);
            About_Button_imageview.setFitHeight(210 + 50);
            About_Button_imageview.setX(About_x);
            About_Button_imageview.setY(About_y - 20);
        });

        About_Button_imageview.setOnMouseExited(e -> {
            About_Button_imageview.setImage(About_Button_image);
            About_Button_imageview.setFitWidth(270);
            About_Button_imageview.setFitHeight(210);
            About_Button_imageview.setX(About_x);
            About_Button_imageview.setY(About_y);
        });

        /**
         * *****************Exit_Button*********************
         */
        Image Exit_Button_image = new Image("images/Buttons/Exit.png");
        ImageView Exit_Button_imageview = new ImageView(Exit_Button_image);
        int Exit_x = 940;
        int Exit_y = 350;
        Exit_Button_imageview.setFitWidth(270);
        Exit_Button_imageview.setFitHeight(210);
        Exit_Button_imageview.setX(Exit_x);
        Exit_Button_imageview.setY(Exit_y);
        Exit_Button_imageview.setOnMouseClicked(e -> {

        });

        Exit_Button_imageview.setOnMouseEntered(event -> {
            Exit_Button_imageview.setImage(new Image("images/Buttons/Exit_on.png"));
            Exit_Button_imageview.setFitWidth(270 + 50);
            Exit_Button_imageview.setFitHeight(210 + 50);
            Exit_Button_imageview.setX(Exit_x);
            Exit_Button_imageview.setY(Exit_y - 20);
        });

        Exit_Button_imageview.setOnMouseExited(e -> {
            Exit_Button_imageview.setImage(Exit_Button_image);
            Exit_Button_imageview.setFitWidth(270);
            Exit_Button_imageview.setFitHeight(210);
            Exit_Button_imageview.setX(Exit_x);
            Exit_Button_imageview.setY(Exit_y);
        });

        Exit_Button_imageview.setOnMouseClicked(event -> {

            logout(Main_Stage);

        });

        Image MuteOff_Button_image = new Image("images/Buttons/MuteOff.png");
        ImageView MuteOff_Button_imageview = new ImageView(MuteOff_Button_image);
        int MuteOff_x = 1210;
        int MuteOff_y = -60;
        MuteOff_Button_imageview.setFitWidth(200);
        MuteOff_Button_imageview.setFitHeight(200);
        MuteOff_Button_imageview.setX(MuteOff_x);
        MuteOff_Button_imageview.setY(MuteOff_y);

        MuteOff_Button_imageview.setOnMouseEntered(e -> {
            // Change the image when mouse enters
            MuteOff_Button_imageview.setImage(new Image("images/Buttons/MuteOff_on.png"));

            MuteOff_Button_imageview.setFitWidth(200);
            MuteOff_Button_imageview.setFitHeight(200);
            MuteOff_Button_imageview.setX(MuteOff_x);
            MuteOff_Button_imageview.setY(MuteOff_y);
        });

        MuteOff_Button_imageview.setOnMouseClicked(event -> {

            MuteOff_Button_imageview.setImage(new Image("images/Buttons/Mute.png"));
            MuteOff_Button_imageview.setFitWidth(200);
            MuteOff_Button_imageview.setFitHeight(200);
            MuteOff_Button_imageview.setX(MuteOff_x);
            MuteOff_Button_imageview.setY(MuteOff_y);

        });

        Main_Pane.getChildren().addAll(background_imageview, coinview, Play_Button_imageview, Setting_Button_imageview, About_Button_imageview, Exit_Button_imageview, MuteOff_Button_imageview);

        Scene Main_Scene = new Scene(Main_Pane, 1352, 757);
        Image icon = new Image("images/icon.png");
        Main_Stage.getIcons().add(icon);
        Main_Stage.setTitle("Super Mario");
        Main_Stage.setScene(Main_Scene);
        Main_Stage.setResizable(false);
        Main_Stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
