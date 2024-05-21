package main;

//
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin {

    private static final int NUM_COINS = 31;
    private static int Score = 0;

    private static final int GOOMBA_KILL_SCORE = 5;
    private static final int COIN_SCORE = 1;

    private static final int COIN_WIDTH = 64;
    private static final int COIN_HEIGHT = 48;

    public static Image coin = new Image("images/coins.gif");
    public static ImageView[] coinImgView = new ImageView[NUM_COINS];

    ////////////////Game Points//////////////
    public static int getGOOMBA_KILL_SCORE() {
        return GOOMBA_KILL_SCORE;
    }

    public static int getCOIN_SCORE() {
        return COIN_SCORE;
    }

    public static int Get_NUM_COINS() {
        return NUM_COINS;
    }

    public static int getScore() {
        return Score;
    }

    public static void setScore(int Score) {
        Coin.Score = Score;
    }

    //////////////*Image Views**//////////////
    public static void setImagesView() {
        for (int i = 0; i < NUM_COINS; i++) {
            coinImgView[i] = new ImageView(coin);
            coinImgView[i].setFitWidth(COIN_WIDTH);
            coinImgView[i].setFitHeight(COIN_HEIGHT);
        }
    }

    public static ImageView[] getCoinsView() {
        return coinImgView;
    }
}
