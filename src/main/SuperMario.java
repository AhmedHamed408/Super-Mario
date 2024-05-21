package main;

import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import static main.MapsWindow.selectedbackground;
import static main.SettingWindow.selectedCharacter;
import static main.SettingWindow.selectedMute;

public class SuperMario {

    private static final int MARIO_WIDTH = 32;
    private static final int MARIO_HEIGHT = 64;
    private static final int MARIO_START_X = 40;
    private static final int MARIO_START_Y = 625;
    private final int LEVEL_GROUND = 721;
    private final int GRAVITY = 1;
    private int JUMP_VELOCITY = -20;
    private final int MOVE_SPEED = 6;
    private static double marioX = MARIO_START_X;
    private static double marioY = MARIO_START_Y;
    private double marioVelocityY = 0;
    private boolean isJumping = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;

    private static final int BLOCK_SIZE = 45;
    int levelNumber = 0;

    Text textScore = new Text();

    private Image marioStandingImage = new Image("images/Player/mariostand.png");
    private Image[] marioRunningImages = {
        new Image("images/Player/mariorun1.png"),
        new Image("images/Player/mariorun2.png"),
        new Image("images/Player/mariorun3.png")
    };
    private Image[] marioJumpingImages = {
        new Image("images/Player/mariojump1.png"),
        new Image("images/Player/mariojump2.png"),
        new Image("images/Player/mariojump3.png")
    };
    private Image marioSleepingImage = new Image("images/Player/mariosleep.png");

    private Image fireMarioStandingImage = new Image("images/Player/firemariostand.png");
    private Image[] fireMarioRunningImages = {
        new Image("images/Player/firemariorun1.png"),
        new Image("images/Player/firemariorun2.png"),
        new Image("images/Player/firemariorun3.png")
    };
    private Image[] fireMarioJumpingImages = {
        new Image("images/Player/firemariojump1.png"),
        new Image("images/Player/firemariojump2.png"),
        new Image("images/Player/firemariojump3.png")
    };
    private Image fireMarioSleepingImage = new Image("images/Player/firemariosleep.png");

    private Image luigiStandingImage = new Image("images/Player/luigistand.png");
    private Image[] luigiRunningImages = {
        new Image("images/Player/luigirun1.png"),
        new Image("images/Player/luigirun2.png"),
        new Image("images/Player/luigirun3.png")
    };
    private Image[] luigiJumpingImages = {
        new Image("images/Player/luigijump1.png"),
        new Image("images/Player/luigijump2.png"),
        new Image("images/Player/luigijump3.png")
    };
    private Image luigiSleepingImage = new Image("images/Player/luigisleep.png");

    private Image currentStandingImage;
    private Image[] currentRunningImages;
    private Image[] currentJumpingImages;
    private Image currentSleepingImage;

    private int currentFrame = 0;
    private int frameCounter = 0;
    private static final int FRAME_DELAY = 5;
    private long lastMoveTime = System.nanoTime();
    private static final long SLEEP_TIMEOUT = 15_000_000_000L; // 15 seconds
    public Coin coins[] = new Coin[Coin.Get_NUM_COINS()];

    public static ArrayList<Block> obstacles = new ArrayList<>();

    public static Pane root1 = new Pane();
    private static Pane root2 = new Pane();
    public static Scene PlayWindowScene = new Scene(root2, 1352, 757);
    private static ImageView marioImageView = new ImageView();
    private static Image backgroundCrystal = new Image("images/CrystalBackground.png");
    private static Image backgroundhorror = new Image("images/horrorBackground.png");
    private static Image backgroundcoralreefs = new Image("images/coralreefsBackground.png");

    private static ImageView backgroundImageView = new ImageView(backgroundCrystal);

    public Image ScoreImage = new Image("images/Score.png");
    public Image HealthImage = new Image("images/Score.png");
    public ImageView ScoreImageView = new ImageView(ScoreImage);
    public ImageView HealthImageView = new ImageView(HealthImage);

    Text HealthText = new Text();

    private Timeline animation;

    /*  *****************/
    public static ImageView getMarioimageview() {
        return marioImageView;
    }

    public static void setx(int x) {
        marioX = x;
    }

    public static void setY(int x) {
        marioY = x;
    }

    public static int MARIO_START_X() {
        return MARIO_START_X;
    }

    public static int MARIO_START_Y() {
        return MARIO_START_Y;
    }

    public static void setbackgroundImageView(int x) {
        backgroundImageView.setLayoutX(x);
    }

    public static double getx() {
        return marioImageView.getX();
    }

    public static double gety() {
        return marioImageView.getY();
    }

    public static void setVisiblemario(boolean state) {
        marioImageView.setVisible(state);
    }
    public static double getBlockSize() {
        return BLOCK_SIZE;
    }

    public static double getMarioWidth() {
        return MARIO_WIDTH;
    }

    public static double getMarioHeight() {
        return MARIO_HEIGHT;
    }

    public static void resetPlayer() {
        SuperMario.setx(100);

    }

    public static void resetPalyWindow() {
        SuperMario.root1.setLayoutX(10.02);
        SuperMario.setbackgroundImageView(0);
        SuperMario.setx(SuperMario.MARIO_START_X());
        SuperMario.setY(SuperMario.MARIO_START_Y());
    }

    public static void addToRoot2(ImageView heart) {
        root2.getChildren().addAll(heart);
    }

    public void DisplayPlayMode(Stage primaryStage) {

        GameSounds gameSound = new GameSounds();
        gameSound.stopmenuSound();

        root2.getChildren().addAll(backgroundImageView, root1, ScoreImageView, textScore, HealthImageView, HealthText);
        root1.getChildren().addAll(marioImageView);

        costumizeBackground();
        selectBackground();
        selectCharacter();
        Coin.setImagesView();
        putCoins();
        putBlocks();
        PutHealthText();
        putBird();
        Enemy.displayGoomba();
        Hearts.displayHearts();

        setupGame();
        setupAnimation();
        primaryStage.setScene(PlayWindowScene);
        primaryStage.setTitle("Super Mario");
        primaryStage.show();
    }

    public void setupGame() {
        PlayWindowScene.setOnKeyPressed(event -> {
            handleKeyPress(event);
        });

        PlayWindowScene.setOnKeyReleased(event -> {
            handleKeyRelease(event);
        });

    }

    public void setupAnimation() {
        animation = new Timeline(new KeyFrame(Duration.millis(1000 / 60), e -> {
            update();
            draw();
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }

    public void update() {
        handleMovement();
        handleJumping();
        handleAnimation();
        handleSleeping();
        moveBackground();
        checkCoinsCollision();
        CoinsScorePrint();
        setHoles();
        CheckWin();

    }

    public void draw() {
        marioImageView.setFitWidth(MARIO_WIDTH);
        marioImageView.setFitHeight(MARIO_HEIGHT);
        marioImageView.setX(marioX);
        marioImageView.setY(marioY);

    }

    public void handleKeyPress(KeyEvent event) {
        KeyCode code = event.getCode();
        if (code == KeyCode.LEFT) {
            isMovingLeft = true;
            marioImageView.setScaleX(-1);

        } else if (code == KeyCode.RIGHT) {
            isMovingRight = true;

            marioImageView.setScaleX(1);

        } else if (code == KeyCode.UP && !isJumping) {
            isJumping = true;
            marioVelocityY = JUMP_VELOCITY;
            GameSounds gameSounds = new GameSounds();
            if (selectedMute == "mute_off") {
                gameSounds.playJumpSound();
            }
        }
    }

    public void moveBackground() {
        int offset = (int) marioX - MARIO_START_X;
        if (offset > 757 && offset < 14150 - 757) {
            root1.setLayoutX(-(offset - 757));
            backgroundImageView.setLayoutX(-(offset - 757));
        }
    }

    public void handleKeyRelease(KeyEvent event) {
        KeyCode code = event.getCode();
        if (code == KeyCode.LEFT) {
            isMovingLeft = false;
        } else if (code == KeyCode.RIGHT) {
            isMovingRight = false;
        }
    }

    public void CheckWin() {

        if (getx() >= 13813) {
            marioX = MARIO_START_X;
            marioY = MARIO_START_Y;
            isMovingRight = false;
            isMovingLeft = false;
            MainPage.MainStage.setScene(GameWin.display());
        }

    }

    public void handleMovement() {
        boolean collided = false;
        if (isMovingLeft && marioX > 0) {

            double newX = marioX - MOVE_SPEED;
            if (!checkBlockCollision(newX, marioY)) {
                marioX = newX;
            } else {
                collided = true;
            }
        } else if (isMovingRight && marioX + MARIO_WIDTH < 13860) {
            double newX = marioX + MOVE_SPEED;
            if (!checkBlockCollision(newX, marioY)) {
                marioX = newX;
            } else {
                collided = true;
            }
        }

        if (!isJumping && !checkBlockCollision(marioX, marioY + 1)) {
            marioVelocityY += GRAVITY;
            marioY += marioVelocityY;
            if (marioY + MARIO_HEIGHT > LEVEL_GROUND) {
                marioY = LEVEL_GROUND - MARIO_HEIGHT;
                marioVelocityY = 0;
            }
        }

        if (!collided) {
            marioImageView.setX(marioX);
        }
    }

    public void handleJumping() {
        if (isJumping) {
            marioVelocityY += GRAVITY;
            double newY = marioY + marioVelocityY;
            if (checkBlockCollision(marioX, newY)) {
                if (marioVelocityY > 0) {
                    
                    marioY = Math.floor((newY + MARIO_HEIGHT) / BLOCK_SIZE) * BLOCK_SIZE - MARIO_HEIGHT - 1; 
                    marioVelocityY = 0;
                    isJumping = false;
                } else if (marioVelocityY < 0) {
                    
                    marioY = Math.ceil(newY / BLOCK_SIZE) * BLOCK_SIZE; 
                    marioVelocityY = 0;
                }
            } else {
                marioY = newY;
                if (marioY + MARIO_HEIGHT > LEVEL_GROUND) {
                    marioY = LEVEL_GROUND - MARIO_HEIGHT;
                    marioVelocityY = 0;
                    isJumping = false;
                }
            }
            marioImageView.setY(marioY);
        }
    }

    public void handleAnimation() {
        frameCounter++;
        if (frameCounter >= FRAME_DELAY) {
            currentFrame = (currentFrame + 1) % currentRunningImages.length;
            frameCounter = 0;
        }

        if (isJumping) {
            marioImageView.setImage(currentJumpingImages[currentFrame]);
        } else if (isMovingRight) {
            marioImageView.setImage(currentRunningImages[currentFrame]);
        } else if (isMovingLeft) {
            marioImageView.setImage(currentRunningImages[currentFrame]);
        } else {
            marioImageView.setImage(currentStandingImage);
        }

    }

    public void handleSleeping() {
        long currentTime = System.nanoTime();
        if (!isMovingLeft && !isMovingRight && !isJumping) {
            long elapsedTime = currentTime - lastMoveTime;
            if (elapsedTime > SLEEP_TIMEOUT) {
                marioImageView.setImage(currentSleepingImage);
            }
        } else {
            lastMoveTime = currentTime; 
        }
    }



    public boolean checkBlockCollision(double newX, double newY) {
        double collisionMarginX = 0.05; 
        double collisionMarginY = 0.05; 

        BoundingBox marioBounds = new BoundingBox(newX + collisionMarginX, newY - collisionMarginY, MARIO_WIDTH - 2 * collisionMarginX, MARIO_HEIGHT + 2 * collisionMarginY);
        for (Block block : obstacles) {
            Bounds blockBounds = block.getBoundsInParent();
            if (marioBounds.intersects(blockBounds)) {
                return true;
            }
        }
        return false;
    }

    /**
     * *******************
     */
    public void selectBackground() {
        switch (selectedbackground) {
            case "Crystali":
                backgroundImageView.setImage(backgroundCrystal);
                break;
            case "coralreefs":
                backgroundImageView.setImage(backgroundcoralreefs);

                break;
            case "horror": // Super Mario is the default character
                backgroundImageView.setImage(backgroundhorror);

                break;
        }
    }

    public void selectCharacter() {

        switch (selectedCharacter) {
            case "Fire Mario Luigi":

                currentStandingImage = fireMarioStandingImage;
                currentRunningImages = fireMarioRunningImages;
                currentJumpingImages = fireMarioJumpingImages;
                currentSleepingImage = fireMarioSleepingImage;

                break;
            case "Mario Luigi":

                currentStandingImage = luigiStandingImage;
                currentRunningImages = luigiRunningImages;
                currentJumpingImages = luigiJumpingImages;
                currentSleepingImage = luigiSleepingImage;

                break;
            case "Super Mario": 

                currentStandingImage = marioStandingImage;
                currentRunningImages = marioRunningImages;
                currentJumpingImages = marioJumpingImages;
                currentSleepingImage = marioSleepingImage;

                break;
        }
    }

    public void PutHealthText() {

        HealthText.setText("Health : ");
        HealthText.setTranslateX(30);
        HealthText.setTranslateY(100);
        HealthText.setFont(Font.loadFont("file:///C:/Users/ah456/Desktop/New folder (3)/Super-Mario/src/Fonts/mario-font.ttf", 15));

        HealthImageView.setFitWidth(450);
        HealthImageView.setFitHeight(220);
        HealthImageView.setTranslateX(-60);
        HealthImageView.setTranslateY(-23);

    }

    public void putBird() {

        Bird b1 = new Bird(-2000, 200, 16000, 200);
        Bird b2 = new Bird(-100, 100, 16000, 100);
        Bird b3 = new Bird(-4000, 200, 16000, 100);
        root1.getChildren().addAll(b1, b2, b3);

    }

    public void costumizeBackground() {

        backgroundImageView.setFitWidth(311 * BLOCK_SIZE);
        backgroundImageView.setFitHeight(17 * BLOCK_SIZE);

    }

    /**
     * *******************blocks************************
     */
    public void putBlocks() {
        String line;
        // to put the brick, bonus block , stones and pipe
        // first loop for the horizontal of the background 0 => 16 (colum)
        for (int i = 0; i < LevelData.levels[levelNumber].length; i++) {
            line = LevelData.levels[levelNumber][i];
            // second loop for the vertical of the background 0 => 310 (colum)
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    // every (character == 1) in the array (line) we create object from Block with block type (PLATFORM) and make x and y for the object
                  
                    case '1':
                        // every (character == 2) in the array (line) we create object from Block with block type (BRICK) and make x and y for the object
                        Block brick = new Block(Block.BlockType.BRICK, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '2':
                        // every (character == 3) in the array (line) we create object from Block with block type (BONUS) and make x and y for the object
                        Block bonus = new Block(Block.BlockType.BONUS, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '3':
                        // every (character == 4) in the array (line) we create object from Block with block type (STONE) and make x and y for the object
                        Block stone = new Block(Block.BlockType.STONE, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '4':
                        // every (character == 5) in the array (line) we create object from Block with block type (PIPE_TOP) and make x and y for the object
                        Block PipeTopBlock = new Block(Block.BlockType.PIPE_TOP, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '5':
                        // every (character == 6) in the array (line) we create object from Block with block type (PIPE_BOTTOM) and make x and y for the object
                        Block PipeBottomBlock = new Block(Block.BlockType.PIPE_BOTTOM, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;
                    case '6':
                        // every (character == 8) in the array (line) we create object from Block with block type (INVISIBLE_BLOCK) and make x and y for the object
                        Block InvisibleBlock = new Block(Block.BlockType.INVISIBLE_BLOCK, j * BLOCK_SIZE, i * BLOCK_SIZE);
                        break;

                }
            }

        }
    }

    //////////********** coins *********///////////////
    public void makeCoins() {
        for (int i = 0; i < coins.length; i++) {
            coins[i] = new Coin();
        }
    }

    int[] coinsX = {14, 19, 21, 79, 84, 91, 98, 100, 104, 106, 129, 130, 147, 153, 155, 158, 159, 179, 181, 207, 208, 213, 216, 238, 239, 246, 249, 253, 257, 258, 290};
    int[] coinsY = {11, 11, 11, 11,  7,  7,  7,   7,   7,   7,   7,   7,  11,   7,   7,   7,   7,   7,   7,   7,   7,   7,   7,  11,  11,   7,   7,   7,   7,   7, 4};

    public void putCoins() {

        for (int i = 0; i < Coin.Get_NUM_COINS(); i++) {
            coins[i].getCoinsView()[i].setLayoutX(coinsX[i] * BLOCK_SIZE - 19);
            coins[i].getCoinsView()[i].setLayoutY(coinsY[i] * BLOCK_SIZE - 4);
            root1.getChildren().addAll(Coin.getCoinsView()[i]);
        }

    }

    public void CoinsScorePrint() {
        ScoreImageView.setFitWidth(250);
        ScoreImageView.setFitHeight(200);
        ScoreImageView.setTranslateX(-25);
        ScoreImageView.setTranslateY(-75);

        textScore.setText("Score : " + Coin.getScore());
        textScore.setTranslateX(29);
        textScore.setTranslateY(37);
        textScore.setFont(Font.loadFont("file:///C:/Users/ah456/Desktop/New folder (3)/Super-Mario/src/Fonts/mario-font.ttf", 15));

    }

    public void checkCoinsCollision() {
        for (int i = 0; i < Coin.Get_NUM_COINS(); i++) {
            ImageView c = Coin.coinImgView[i];
            if (marioImageView.getBoundsInParent().intersects(c.getBoundsInParent())) {
                coinsX[i] = 16000;
                coins[i].getCoinsView()[i].setLayoutY(coinsX[i]);
                GameSounds gameSounds = new GameSounds();
                if (selectedMute == "mute_off") {
                    gameSounds.playCoinSound();

                }
                Coin.setScore(Coin.getScore() + Coin.getCOIN_SCORE());;
                System.out.println("Score = " + Coin.getScore());
                Coin.coinImgView[i].setVisible(false);
            }

        }
    }

    /**
     * **************************************************holes**************************************************************
     */
    int[] holesStartX = {3090, 5475, 7680, 9885, 12135};
    int[] holesEndX = {3230, 5595, 7800, 10025, 12270};

    public final int NUM_HOLES = 5;

    public void setHoles() {

        for (int i = 0; i < NUM_HOLES; i++) {
            // check if the mario fall into the hole or not
            if (marioImageView.getX() > holesStartX[i] && marioImageView.getX() < holesEndX[i] && (!(isJumping)) && (757 - marioY - MARIO_HEIGHT < 45)) {

                //Play sound when super mario fall into the hole
                GameSounds gameSounds = new GameSounds();
                if (selectedMute == "mute_off") {
                    gameSounds.playFallSound();

                }

                // when super mario fall into hole the heart will decrease and will be visible
                Hearts.decreaseHearts();

                // if hearts = 0 super mario will lose and the scene of Game Over will appear
                if (Hearts.getHearts() == 0) {
                    MainPage.MainStage.setScene(GameOver.display());
                    gameSounds.stopAllSounds();

                }
                // reset the player and the root to the start point
                root1.setLayoutX(0);
                backgroundImageView.setLayoutX(0);
                marioX = MARIO_START_X;
                marioY = MARIO_START_Y;

            }
        }
    }
    /**
     * **********************************************************************************
     */

}
