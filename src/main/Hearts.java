package main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hearts {

    private static final int numHearts = 5;
    private static final int heartWidth = 30;
    private static final int heartHeight = 30;
    private static int hearts = 5;

    public Hearts() {
    }

    private static Image heartimage = new Image("images/heart.png");
    public static ImageView[] heartImgView = new ImageView[numHearts];

    public static void displayHearts() {
        for (int i = 0; i < numHearts; i++) {
            heartImgView[i] = new ImageView(heartimage);
            heartImgView[i].setFitWidth(heartWidth);
            heartImgView[i].setFitHeight(heartHeight);
            heartImgView[i].setTranslateX(150 + i * 32);
            heartImgView[i].setTranslateY(78);
            SuperMario.addToRoot2(heartImgView[i]);

        }
    }

    public static void decreaseHearts() {
        hearts--;

        switch (hearts) {

            case 4:
                heartImgView[4].setVisible(false);
                break;
            case 3:
                heartImgView[3].setVisible(false);
                break;
            case 2:
                heartImgView[2].setVisible(false);
                break;
            case 1:
                heartImgView[1].setVisible(false);
                break;
            case 0:
                heartImgView[0].setVisible(false);
                break;
        }

    }

    public static int getHearts() {
        return hearts;
    }

}
