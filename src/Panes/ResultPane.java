package Panes;

import Common.Const;
import RPSGame.MainApplication;
import RPSGame.Game;
import Scenes.ScoreScene;
import Scenes.GameScene;
import Scenes.TwoPlayerScene;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class ResultPane extends GridPane {

    Game game = new Game();

    public static Text playerText = new Text();
    public static Text computerText = new Text();
    public static Text playerChosenText = new Text();
    public static Text computerChosenText = new Text();
    public static  ImageView userImageView;
    public static  ImageView computerImageView;
    public static TextArea resultDialogue= new TextArea();

    public ResultPane(){

        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: burlyWood;");
        this.setVgap(15);
        this.setHgap(30);

         playerText.setFont(Const.optionFontStyle);
        playerText.setFill(Color.DARKBLUE);
        this.add(playerText, 0, 0, 3, 1);
        GridPane.setHalignment(playerText, HPos.CENTER);

        computerText.setFont(Const.optionFontStyle);
        computerText.setFill(Color.DARKBLUE);
        this.add(computerText, 3, 0, 3, 1);
        GridPane.setHalignment(computerText, HPos.CENTER);

       this.add(userImageView, 0, 1, 3, 1);
        GridPane.setHalignment(userImageView, HPos.CENTER);

        this.add(playerChosenText, 0, 2, 3, 1);
        playerChosenText.setFont(Const.textFntStyle);
        GridPane.setHalignment(playerChosenText, HPos.CENTER);

        this.add(computerImageView, 3, 1, 3, 1);
        GridPane.setHalignment(computerImageView, HPos.CENTER);

        this.add(computerChosenText, 3, 2, 3, 1);
        computerChosenText.setFont(Const.textFntStyle);
        GridPane.setHalignment(computerChosenText, HPos.CENTER);


        resultDialogue.setFont(Const.resFntStyle);
        resultDialogue.setEditable(false);
        resultDialogue.setPrefWidth(500);
        resultDialogue.setPrefHeight(100);
        resultDialogue.setWrapText(true);
        resultDialogue.setFocusTraversable(false);
        this.add(resultDialogue, 0, 4, 6, 1);
        GridPane.setHalignment(resultDialogue, HPos.CENTER);


        ImageView continueImageView = new ImageView("icons/Continue-icon.png");
        this.add(continueImageView, 7, 7);
        GridPane.setHalignment(continueImageView, HPos.RIGHT);
        continueImageView.setOnMouseClicked(e->{
            if(computerText.getText().equals("Computer")) {
                MainApplication.mainStage.setScene(new GameScene());
            }else{
                MainApplication.mainStage.setScene(new TwoPlayerScene());
            }
        });

        ImageView exitImageView = new ImageView("icons/Button-Close-icon (1).png");
        this.add(exitImageView, 8, 7);
        GridPane.setHalignment(exitImageView, HPos.RIGHT);
        exitImageView.setOnMouseClicked(e->{
            if(computerText.getText().equals("Computer")) {
                ScorePane.player.setText(Game.player1);
                ScorePane.computer.setText(Game.player2);
            }else {
                ScorePane.player.setText(Game.player1);
                ScorePane.computer.setText(Game.player2);
            }

            MainApplication.mainStage.setScene(new ScoreScene());
        });

        Text continueText = new Text("Continue");
        continueText.setFont(Const.textFntStyle);
        this.add(continueText, 7, 8);
        GridPane.setHalignment(continueText, HPos.RIGHT);
        Text quitText = new Text("Quit");
        quitText.setFont(Const.textFntStyle);
        this.add(quitText, 8, 8);
        GridPane.setHalignment(quitText, HPos.RIGHT);

    }


}
