package Panes;

import Common.Const;
import RPSGame.MainApplication;
import Scenes.ExitScene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ScorePane extends GridPane {


    public static Label player = new Label();
    public static Label computer = new Label();
    public static TextField playerScore = new TextField();
    public static TextField computerScore = new TextField();
    public static TextArea scoreDialogue = new TextArea();

    ArrayList<String> scoreList;

    public ScorePane(){

        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setVgap(30);
        this.setHgap(15);
        this.setStyle("-fx-background-color: burlyWood;");

        Text scoreText = new  Text("Scores");
        scoreText.setFont(Const.optionFontStyle);
        scoreText.setFill(Color.DARKVIOLET);
        this.add(scoreText, 3,0, 3, 1);

        player.setFont(Const.resFntStyle);
        this.add(player, 0, 2, 3, 1);

        this.add(playerScore, 3,2,3,1);
        playerScore.setEditable(false);
        playerScore.setFocusTraversable(false);

        computer.setFont(Const.resFntStyle);
        this.add(computer, 0, 4, 3, 1);

        this.add(computerScore, 3,4,3,1);
        computerScore.setEditable(false);
        computerScore.setFocusTraversable(false);

        int userPoints = Integer.parseInt(playerScore.getText());
        int computerPoints = Integer.parseInt(computerScore.getText());

        try {
            BufferedWriter out =
                    new BufferedWriter(new FileWriter("highScore.txt", true));
            out.write(playerScore.getText());
            out.write(" ");
            if(!computer.getText().equals("Computer")) {
                out.write(computerScore.getText());
                out.write(" ");
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader in = new BufferedReader(new FileReader("highScore.txt"));
            String line = "";
            while((line = in.readLine())!=null){
                scoreList = new ArrayList<>(Arrays.asList(line.split(" ")));
            }

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


        ArrayList<Integer> listInteger = new ArrayList<>();
        for(String sc : scoreList){
            listInteger.add(Integer.valueOf(sc));
        }

        Collections.sort(listInteger, Collections.reverseOrder());

        if(userPoints > computerPoints){
            scoreDialogue.setText(player.getText()+" Won the Game. "+computer.getText()+" Lost");
        }else if(userPoints < computerPoints){
            scoreDialogue.setText(player.getText()+" Lost the Game. "+computer.getText()+" Won");
        }else{
            scoreDialogue.setText("Both are Draw");
        }
        scoreDialogue.setFont(Const.resFntStyle);
        scoreDialogue.setEditable(false);
        scoreDialogue.setPrefHeight(100);
        scoreDialogue.setPrefWidth(400);
        scoreDialogue.setWrapText(true);
        scoreDialogue.setFocusTraversable(false);
        this.add(scoreDialogue, 0, 6, 6, 1);

        Label highScoreText = new Label("HighScore");
        highScoreText.setFont(Const.resFntStyle);
        this.add(highScoreText, 0, 7, 3,1);
        TextField highScore = new TextField();
        highScore.setText(listInteger.get(0).toString());
        highScore.setEditable(false);
        highScore.setFocusTraversable(false);
        this.add(highScore,3,7, 3, 1);


        Button quitButton = new Button("Quit");
        quitButton.setTextFill(Color.CRIMSON);
        quitButton.setFocusTraversable(false);
        quitButton.setPadding(new Insets(10, 20, 10, 20));
        this.add(quitButton, 0, 8,6,1);
        GridPane.setHalignment(quitButton, HPos.CENTER);

        quitButton.setOnAction(e->{
            MainApplication.mainStage.setScene(new ExitScene());

        });

    }
}
