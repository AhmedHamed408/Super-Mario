package main;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
public class PlayWindow {

    Image backgroundImg = new Image("images/gamebackground.png");
    public static final int BLOCK_SIZE = 45;
    public static Pane appRoot = new Pane();

    public Scene initContent() {
        // making the background of the game
        ImageView backgroundIV = new ImageView(backgroundImg);
        backgroundIV.setFitHeight(17 * BLOCK_SIZE);
        backgroundIV.setFitWidth(212 * BLOCK_SIZE);
        appRoot.getChildren().addAll(backgroundIV);
        return new Scene(appRoot,1352,757);


        
        
        
        
        
        
        
    }


}