package Panes;

import Common.Const;
import RPSGame.MainApplication;
import Scenes.ResultScreen;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class LoadingPane extends GridPane {

    public LoadingPane(){
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: burlyWood;");
        this.setVgap(15);
        this.setHgap(30);

        Text playerText = new Text("Player option");
        playerText.setFont(Const.optionFontStyle);
        playerText.setFill(Color.DARKBLUE);
        this.add(playerText, 0, 0, 3, 1);
        GridPane.setHalignment(playerText, HPos.CENTER);

        Text computerText = new Text("Computer Option");
        computerText.setFont(Const.optionFontStyle);
        computerText.setFill(Color.DARKBLUE);
        this.add(computerText, 3, 0, 3, 1);
        GridPane.setHalignment(computerText, HPos.CENTER);

        ImageView imageView1 = new ImageView(new Image("file:K:\\MAD 2021\\Java Programming 2 MAD 200 001\\UltimateRockPaperScissor\\src\\icons\\question_icon.png"));
        this.add(imageView1, 0, 2, 3, 1);
        GridPane.setHalignment(imageView1, HPos.CENTER);

        ImageView imageView2 = new ImageView(new Image("file:K:\\MAD 2021\\Java Programming 2 MAD 200 001\\UltimateRockPaperScissor\\src\\icons\\question_icon.png"));
        this.add(imageView2, 3, 2, 3, 1);
        GridPane.setHalignment(imageView2, HPos.CENTER);

        ParallelTransition parallelTransition = new ParallelTransition(slowFade(imageView1),slowFade(imageView2));
       parallelTransition.play();

       parallelTransition.setOnFinished(e->{
            MainApplication.mainStage.setScene(new ResultScreen());
        });



    }

    public FadeTransition slowFade(Node node){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), node);
        fadeTransition.setFromValue(10);
        fadeTransition.setToValue(0.2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(6);
        fadeTransition.play();
        return fadeTransition;
    }
}
