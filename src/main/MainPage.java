/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pkgclass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ah456
 */
public class MainPage extends Application {
    
    @Override
    public void start(Stage Main_Stage) {
        
        
        Pane Main_Pane = new Pane();
        
       Image background_image = new Image("images/background.png");
        ImageView background_imageview = new ImageView(background_image);
      
         Image Play_Button_image = new Image("images/Buttons/Play.png");
        ImageView Play_Button_imageview = new ImageView(Play_Button_image);
        int Play_x=920 ;
        int Play_y=25 ;
        Play_Button_imageview.setFitWidth(270);
        Play_Button_imageview.setFitHeight(210);
        Play_Button_imageview.setX(Play_x);
        Play_Button_imageview.setY(Play_y);
        Play_Button_imageview.setOnMouseClicked(e->{
           

        });
        
        
         Play_Button_imageview.setOnMouseEntered(e -> {
    // Change the image when mouse enters
    Play_Button_imageview.setImage(new Image("images/Buttons/Play.png"));
});
Play_Button_imageview.setOnMousePressed(event -> {
    Main_Pane.getChildren().removeAll();
            ImageView Play_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/Play_on.png"));
            Play_Button_Clicked_imageview.setFitWidth(270);
            Play_Button_Clicked_imageview.setFitHeight(210);
            Play_Button_Clicked_imageview.setX(Play_x);
            Play_Button_Clicked_imageview.setY(Play_y);
            Main_Pane.getChildren().add(Play_Button_Clicked_imageview);
});

Play_Button_imageview.setOnMouseReleased(event -> {
  Main_Pane.getChildren().removeAll();
            ImageView Play_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/Play.png"));
            Play_Button_Clicked_imageview.setFitWidth(270);
            Play_Button_Clicked_imageview.setFitHeight(210);
            Play_Button_Clicked_imageview.setX(Play_x);
            Play_Button_Clicked_imageview.setY(Play_y);
            Main_Pane.getChildren().add(Play_Button_Clicked_imageview);
});

Play_Button_imageview.setOnMouseExited(e -> {
    // Change the image back when mouse exits
    Play_Button_imageview.setImage(Play_Button_image);
});
        
                 Image Setting_Button_image = new Image("images/Buttons/Setting.png");
        ImageView Setting_Button_imageview = new ImageView(Setting_Button_image);
        int Setting_x=800 ;
        int Setting_y=140 ;
        Setting_Button_imageview.setFitWidth(270);
        Setting_Button_imageview.setFitHeight(210);
        Setting_Button_imageview.setX(Setting_x);
        Setting_Button_imageview.setY(Setting_y);
        Setting_Button_imageview.setOnMouseClicked(e->{
           

        });
        
        
         Setting_Button_imageview.setOnMouseEntered(e -> {
    // Change the image when mouse enters
    Setting_Button_imageview.setImage(new Image("images/Buttons/Setting.png"));
});
Setting_Button_imageview.setOnMousePressed(event -> {
    Main_Pane.getChildren().removeAll();
            ImageView Setting_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/Setting_on.png"));
            Setting_Button_Clicked_imageview.setFitWidth(270);
            Setting_Button_Clicked_imageview.setFitHeight(210);
            Setting_Button_Clicked_imageview.setX(Setting_x);
            Setting_Button_Clicked_imageview.setY(Setting_y);
            Main_Pane.getChildren().add(Setting_Button_Clicked_imageview);
});

Setting_Button_imageview.setOnMouseReleased(event -> {
  Main_Pane.getChildren().removeAll();
            ImageView Setting_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/Setting.png"));
            Setting_Button_Clicked_imageview.setFitWidth(270);
            Setting_Button_Clicked_imageview.setFitHeight(210);
            Setting_Button_Clicked_imageview.setX(Setting_x);
            Setting_Button_Clicked_imageview.setY(Setting_y);
            Main_Pane.getChildren().add(Setting_Button_Clicked_imageview);
});

Setting_Button_imageview.setOnMouseExited(e -> {
    // Change the image back when mouse exits
    Setting_Button_imageview.setImage(Setting_Button_image);
});
        
        Image About_Button_image = new Image("images/Buttons/About.png");
        ImageView About_Button_imageview = new ImageView(About_Button_image);
        int About_x=700 ;
        int About_y=255 ;
        About_Button_imageview.setFitWidth(270);
        About_Button_imageview.setFitHeight(210);
        About_Button_imageview.setX(About_x);
        About_Button_imageview.setY(About_y);
        About_Button_imageview.setOnMouseClicked(e->{
           

        });
        
        
         About_Button_imageview.setOnMouseEntered(e -> {
    // Change the image when mouse enters
    About_Button_imageview.setImage(new Image("images/Buttons/About.png"));
});
About_Button_imageview.setOnMousePressed(event -> {
    Main_Pane.getChildren().removeAll();
            ImageView About_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/About_on.png"));
            About_Button_Clicked_imageview.setFitWidth(270);
            About_Button_Clicked_imageview.setFitHeight(210);
            About_Button_Clicked_imageview.setX(About_x);
            About_Button_Clicked_imageview.setY(About_y);
            Main_Pane.getChildren().add(About_Button_Clicked_imageview);
});

About_Button_imageview.setOnMouseReleased(event -> {
  Main_Pane.getChildren().removeAll();
            ImageView About_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/About.png"));
            About_Button_Clicked_imageview.setFitWidth(270);
            About_Button_Clicked_imageview.setFitHeight(210);
            About_Button_Clicked_imageview.setX(About_x);
            About_Button_Clicked_imageview.setY(About_y);
            Main_Pane.getChildren().add(About_Button_Clicked_imageview);
});

About_Button_imageview.setOnMouseExited(e -> {
    // Change the image back when mouse exits
    About_Button_imageview.setImage(About_Button_image);
});
        
        Image Exit_Button_image = new Image("images/Buttons/Exit.png");
        ImageView Exit_Button_imageview = new ImageView(Exit_Button_image);
        int Exit_x=580 ;
        int Exit_y=370 ;
        Exit_Button_imageview.setFitWidth(270);
        Exit_Button_imageview.setFitHeight(210);
        Exit_Button_imageview.setX(Exit_x);
        Exit_Button_imageview.setY(Exit_y);
        Exit_Button_imageview.setOnMouseClicked(e->{
           

        });
        
        
         Exit_Button_imageview.setOnMouseEntered(e -> {
    // Change the image when mouse enters
    Exit_Button_imageview.setImage(new Image("images/Buttons/Exit.png"));
});
Exit_Button_imageview.setOnMousePressed(event -> {
    Main_Pane.getChildren().removeAll();
            ImageView Exit_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/Exit_on.png"));
            Exit_Button_Clicked_imageview.setFitWidth(270);
            Exit_Button_Clicked_imageview.setFitHeight(210);
            Exit_Button_Clicked_imageview.setX(Exit_x);
            Exit_Button_Clicked_imageview.setY(Exit_y);
            Main_Pane.getChildren().add(Exit_Button_Clicked_imageview);
});

Exit_Button_imageview.setOnMouseReleased(event -> {
  Main_Pane.getChildren().removeAll();
            ImageView Exit_Button_Clicked_imageview = new ImageView(new Image("images/Buttons/Exit.png"));
            Exit_Button_Clicked_imageview.setFitWidth(270);
            Exit_Button_Clicked_imageview.setFitHeight(210);
            Exit_Button_Clicked_imageview.setX(Exit_x);
            Exit_Button_Clicked_imageview.setY(Exit_y);
            Main_Pane.getChildren().add(Exit_Button_Clicked_imageview);
            Main_Stage.close();
});

Exit_Button_imageview.setOnMouseExited(e -> {
    // Change the image back when mouse exits
    Exit_Button_imageview.setImage(Exit_Button_image);
});
        
     
        
        Main_Pane.getChildren().addAll(background_imageview,Play_Button_imageview,Setting_Button_imageview,About_Button_imageview,Exit_Button_imageview);
        
        Scene Main_Scene = new Scene(Main_Pane, 1352, 757);
     
        Main_Stage.setTitle("Super Mario");
        Main_Stage.setScene(Main_Scene);
        Main_Stage.setResizable(false);
        Main_Stage.show();
    }

  
    public static void main(String[] args) {
        launch(args);
    }
    
}
