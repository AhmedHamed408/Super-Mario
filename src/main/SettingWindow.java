package main;



import java.awt.Desktop;
import java.net.URI;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingWindow {

    public static void display(Stage primaryStage, Scene previousScene) {
        // Create root pane for about window
        Pane settingPane = new Pane();
 
        
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
        });
        
        Close_Button_imageview.setOnMouseExited(event -> {

            Close_Button_imageview.setImage(Close_Button_image);
            Close_Button_imageview.setFitWidth(200);
            Close_Button_imageview.setFitHeight(200);
            Close_Button_imageview.setX(Close_x);
            Close_Button_imageview.setY(Close_y);

        });
        /********************************************************************************/
         Image im_Setting_BackGround = new Image("images/Setting_BackGround.jpg");
         ImageView imv_Setting_BackGround = new ImageView(im_Setting_BackGround);
         Pane Pane_Setting = new Pane();
         Pane_Setting.getChildren().addAll(imv_Setting_BackGround);
          Scene Setting_Scene = new Scene(Pane_Setting, 1352, 757);
        
        
        
         settingPane.getChildren().addAll(imv_Setting_BackGround , Close_Button_imageview);
        
             
        
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
         /**********************************************************************/
         
         
         
         
         
        Scene aboutScene = new Scene(settingPane, 1352, 757); 
        
       
       primaryStage.setScene(aboutScene);
    }
}
