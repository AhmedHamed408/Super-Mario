package main;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class Bird extends Pane {

    private int startlineX;
    private int startlineY;
    private int endlineX;
    private int endlineY;
    private Image bird = new Image("images/bird.gif");
    private ImageView birdview = new ImageView(bird);
    private Line line = new Line();
    private PathTransition path = new PathTransition();

    public Bird(int startX, int startY, int endX, int endY) {
        this.startlineX = startX;
        this.startlineY = startY;
        this.endlineX = endX;
        this.endlineY = endY;
        birdview.setFitWidth(60);
        birdview.setFitHeight(50);
        getChildren().add(birdview);
        line.setStartX(startlineX);
        line.setStartY(startlineY);
        line.setEndX(endlineX);
        line.setEndY(endlineY);
        path.setPath(line);
        path.setNode(birdview);
        path.setDuration(Duration.millis(43000));
        path.setCycleCount(Timeline.INDEFINITE);
        path.play();
    }

}
