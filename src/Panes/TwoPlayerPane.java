package Panes;

import Common.Const;
import RPSGame.Game;
import RPSGame.MainApplication;

import Scenes.ResultScreen;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;



public class TwoPlayerPane extends GridPane {

    int[] images = new int[6];
    Image image;
    ImageView[] imageView = new ImageView[6];
    Text[] text = new Text[6];
    Image image1;
    Image image2;
    ImageView dummyImageView1;
    ImageView dummyImageView2;
    ParallelTransition parallelTransition;


    public static String player1;
    public static String player2;

    public TwoPlayerPane() {


        this.setVgap(15);
        this.setHgap(5);
        //Array for images
        for (int i = 0; i < 6; i++) {
            images[i] = i;
        }
        text[0] = new Text("Rock");
        text[1] = new Text("Paper");
        text[2] = new Text("Scissor");
        text[3] = new Text("Hunter");
        text[4] = new Text("Bird");
        text[5] = new Text("Water");

        Text selectText = new Text(player1+" Select Your Option");
        selectText.setFont(Const.criteriaFontStyle);
        selectText.setFill(Color.DARKMAGENTA);
        this.add(selectText, 0, 0, 6, 1);
        GridPane.setHalignment(selectText, HPos.CENTER);


        for (int i = 0; i < 6; i++) {
            image = new Image("images/" + images[i] + ".png");
            imageView[i] = new ImageView(image);
            this.add(imageView[i], i, 2);
        }

        for (int i = 0; i < 6; i++) {
            text[i].setFont(Const.textFntStyle);
            this.add(text[i], i, 4);
            GridPane.setHalignment(text[i], HPos.CENTER);
        }

        Text player1Text = new Text();
        player1Text.setText(player1);
        player1Text.setFont(Font.font(20));
        this.add(player1Text, 0, 6, 3, 1);
        GridPane.setHalignment(player1Text, HPos.CENTER);

        Text player2Text = new Text();
        player2Text.setText(player2);
        player2Text.setFont(Font.font(20));
        this.add(player2Text, 3, 6, 3, 1);
        GridPane.setHalignment(player2Text, HPos.CENTER);


        for (int i = 0; i < 6; i++) {
            int option1 = i;
            imageView[i].setOnMouseClicked(e -> {

                SettingsPane.soundEffects();
                if(SettingsPane.soundButton.isSelected()){
                    SettingsPane.gameMediaPlayer.play();
                }
                dummyImageView1 = new ImageView(new Image("icons/question_icon.png"));
                image1 = new Image("images/" + images[option1] + ".png");
                this.add(dummyImageView1, 0, 7, 3, 1);
                GridPane.setHalignment(dummyImageView1, HPos.CENTER);
                selectText.setText(player2 + " Select Your Option");

                for (int j = 0; j < 6; j++) {
                    int option2 = j;
                    imageView[j].setOnMouseClicked(e2 -> {

                        SettingsPane.soundEffects();
                        if(SettingsPane.soundButton.isSelected()){
                            SettingsPane.gameMediaPlayer.play();
                        }
                        dummyImageView2 = new ImageView(new Image("icons/question_icon.png"));
                        image2 = new Image("images/" + images[option2] + ".png");
                        this.add(dummyImageView2, 3, 7, 3, 1);
                        GridPane.setHalignment(dummyImageView2, HPos.CENTER);

                        Game.user = option1;
                        Game.player1= player1;
                        Game.player2 = player2;
                        ResultPane.playerText.setText(player1);
                        ResultPane.userImageView = new ImageView("images/" + images[option1] + ".png");
                        ResultPane.playerChosenText.setText(text[option1].getText());

                        Game.computer = option2;
                        ResultPane.computerText.setText(player2);
                        ResultPane.computerImageView = new ImageView("images/" + images[option2] + ".png");
                        ResultPane.computerChosenText.setText(text[option2].getText());

                        parallelTransition = new ParallelTransition(slowFade(dummyImageView1), slowFade(dummyImageView2));
                        parallelTransition.play();
                        parallelTransition.setOnFinished(e1 -> {
                            dummyImageView1.setImage(image1);
                            dummyImageView2.setImage(image2);

                            Text chosenOption = new Text();
                            chosenOption.setText(text[option1].getText());
                            chosenOption.setFont(Const.textFntStyle);
                            this.add(chosenOption, 0, 8, 3, 1);
                            GridPane.setHalignment(chosenOption, HPos.CENTER);

                            Text chosenOption2 = new Text();
                            chosenOption2.setText(text[option2].getText());
                            chosenOption2.setFont(Const.textFntStyle);
                            GridPane.setHalignment(chosenOption2, HPos.CENTER);
                            this.add(chosenOption2, 3, 8, 3, 1);

                            Button nextButton = new Button("Next");
                            nextButton.setPadding(new Insets(10, 30, 10, 30));
                            nextButton.setTextFill(Color.DARKMAGENTA);
                            nextButton.setFocusTraversable(false);
                            this.add(nextButton, 0, 9, 6, 1);
                            GridPane.setHalignment(nextButton, HPos.CENTER);
                            nextButton.setOnAction(ex -> {
                                MainApplication.mainStage.setScene(new ResultScreen());
                            });
                        });
                        reset();
                    });
                }

            });
        }


        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: burlyWood;");

    }


    public void reset() {
        for (int i = 0; i < 6; i++) {
            imageView[i].setDisable(true);
        }
    }

    public FadeTransition slowFade(Node node) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), node);
        fadeTransition.setFromValue(10);
        fadeTransition.setToValue(0.2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(6);
        fadeTransition.play();
        return fadeTransition;
    }

}


