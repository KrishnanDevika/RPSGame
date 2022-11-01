package Panes;
import Common.Const;
import RPSGame.MainApplication;
import Scenes.WelcomeScreen;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;




public class IntroPane extends BorderPane {

    public IntroPane(){
        SettingsPane.musicButton.setSelected(true);
        SettingsPane.soundButton.setSelected(true);
        new SettingsPane();
        if(SettingsPane.musicButton.isSelected()){
            SettingsPane.backgroundMediaPlayer.play();
            SettingsPane.backgroundMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }

        Text nameText = new Text("Devika Krishnan");
        nameText.setFont(Const.nameFont);
        nameText.setFill(Color.BROWN);
        nameText.setStroke(Color.BLACK);

        Text titleText = new Text("Ultimate Rock Paper Scissor");
        titleText.setFont(Const.titleFont);
        titleText.setFill(Color.CRIMSON);
        titleText.setStroke(Color.BLACK);

        ImageView imageView = new ImageView(new Image("images/rps.jpg"));
        imageView.setFitWidth(350);
        imageView.setFitHeight(250);
        BorderPane.setAlignment(imageView, Pos.BOTTOM_CENTER);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(nameText, titleText);


        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), titleText);
        scaleTransition.setByX(.75f);
        scaleTransition.setByY(1f);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);

        FillTransition fillTransition = new FillTransition(Duration.millis(100), nameText,Color.BROWN, Color.BLUE);
        FillTransition fillTransition2 = new FillTransition(Duration.millis(1000), titleText,Color.CRIMSON, Color.DEEPSKYBLUE);

        rotate(vBox, 360);
        rotate(imageView, 360);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(slowFade(vBox),slowFade(imageView));

        ParallelTransition parallelTransition2 = new ParallelTransition();
        parallelTransition2.getChildren().addAll(translateTransition(vBox),translateTransition2(imageView));
        SequentialTransition seq = new SequentialTransition();
        seq.getChildren().addAll(
                parallelTransition2,
                fillTransition,
                fillTransition2,
                parallelTransition,
                scaleTransition);
        seq.play();



        seq.setOnFinished(e->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            MainApplication.mainStage.setScene(new WelcomeScreen());
        });




        this.setStyle("-fx-background-color: burlyWood;");
        this.setPadding(new Insets(80));
        this.setCenter(vBox);
        this.setBottom(imageView);

    }

    public RotateTransition rotate(Node node, int degree){
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1500), node);
        rotateTransition.setByAngle(degree);
        rotateTransition.setCycleCount(2);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
        return rotateTransition;
    }

    public FadeTransition slowFade(Node node){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), node);
        fadeTransition.setFromValue(10);
        fadeTransition.setToValue(0.2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(2);
        return  fadeTransition;
    }

    public TranslateTransition translateTransition(Node node){
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(4000), node);
        translateTransition.setFromX(-400);
        translateTransition.setFromY(0);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.setAutoReverse(true);
        return translateTransition;
    }

    public TranslateTransition translateTransition2(Node node){
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(4000), node);
        translateTransition.setFromX(400);
        translateTransition.setFromY(0);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.setAutoReverse(true);
        return translateTransition;
    }

}

