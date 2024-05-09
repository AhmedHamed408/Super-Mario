package main;



import java.awt.Desktop;
import java.net.URI;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AboutWindow {

    public static void display(Stage primaryStage, Scene previousScene) {
        // Create root pane for about window
        Pane aboutPane = new Pane();
 
        
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
        

        
        Image AboutBackGround_image = new Image("images/About/AboutBackGround.jpeg");
        ImageView AboutBackGround_imageview = new ImageView(AboutBackGround_image);
        // Create scene for about window
        int intial_x=-387;
        int intial_y=-205;
        int width = 1270;
        int hight = 770 ;
        
        
        
        /****************** Ahmed_Hamed *********************/
        ImageView Ahmed_HamedImgView = new ImageView(new Image("images/About/Ahmed_Hamed.png"));
        Ahmed_HamedImgView.setX(intial_x + 400);
        Ahmed_HamedImgView.setY(intial_y + 207);
        Ahmed_HamedImgView.setFitWidth(width +80);
        Ahmed_HamedImgView.setFitHeight(hight);
        
        
        Ahmed_HamedImgView.setOnMouseClicked(event -> {

            
            try {
                // Open Google in a web browser
                Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/madyhamed/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        
        
        /*********************Abdelaziz_omar*********************/
        ImageView Abdelaziz_omarImgView = new ImageView(new Image("images/About/Abdelaziz_omar.png"));
        
        Abdelaziz_omarImgView.setX(intial_x);
        Abdelaziz_omarImgView.setY(intial_y +  210);
        Abdelaziz_omarImgView.setFitWidth(width);
        Abdelaziz_omarImgView.setFitHeight(hight);
        
        Abdelaziz_omarImgView.setOnMouseClicked(event -> {

            
            try {
                // Open Google in a web browser
                Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/madyhamed/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

         /************************Ahmed_Abdelkader********************/
        
        ImageView Ahmed_AbdelkaderView = new ImageView(new Image("images/About/Ahmed_Abdelkader.png"));
         Ahmed_AbdelkaderView.setX(intial_x);
        Ahmed_AbdelkaderView.setY(intial_y);
        Ahmed_AbdelkaderView.setFitWidth(width);
        Ahmed_AbdelkaderView.setFitHeight(hight);
        
        
        Ahmed_AbdelkaderView.setOnMouseClicked(event -> {

            
            try {
                // Open Google in a web browser
                Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/madyhamed/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /***************************Ahmed_Maged*********************/
        
        
        ImageView Ahmed_MagedImgView = new ImageView(new Image("images/About/Ahmed_Maged.png"));
        Ahmed_MagedImgView.setX(intial_x);
        Ahmed_MagedImgView.setY(intial_y);
        Ahmed_MagedImgView.setFitWidth(width);
        Ahmed_MagedImgView.setFitHeight(hight);
        
        
        Ahmed_MagedImgView.setOnMouseClicked(event -> {

            
            try {
                // Open Google in a web browser
                Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/madyhamed/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        
        
        /**************************Mohamed_Hassan**********************/
        ImageView Mohamed_HassanView = new ImageView(new Image("images/About/Mohamed_Hassan.png"));
         Mohamed_HassanView.setX(intial_x+400);
        Mohamed_HassanView.setY(intial_y -7);
        Mohamed_HassanView.setFitWidth(width + 80);
        Mohamed_HassanView.setFitHeight(hight);
       
        
        Mohamed_HassanView.setOnMouseClicked(event -> {

            
            try {
                // Open Google in a web browser
                Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/madyhamed/"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        
         aboutPane.getChildren().addAll(AboutBackGround_imageview,Ahmed_HamedImgView,Mohamed_HassanView,Ahmed_MagedImgView,Ahmed_AbdelkaderView,Abdelaziz_omarImgView,Close_Button_imageview);
        
             
        
        
        Scene aboutScene = new Scene(aboutPane, 1352, 757); // Set width and height
        
        // Create stage for about window
       primaryStage.setScene(aboutScene);
    }
}
