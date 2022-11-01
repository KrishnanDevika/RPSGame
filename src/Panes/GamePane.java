package Panes;
import Common.Const;
import RPSGame.MainApplication;
import RPSGame.Game;
import Scenes.ResultScreen;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;


public class GamePane extends GridPane {

    int[] images = new int[6];
    Image image;
    ImageView[] imageView = new ImageView[6];
    Text[] text = new Text[6];
    ImageView imageView1;

    public static String playerName;

    public GamePane(){


        this.setVgap(15);
        this.setHgap(5);
        //Array for images
        for(int i = 0; i< 6; i++){
            images[i] = i;
        }
        text[0] = new Text("Rock");
        text[1] = new Text("Paper");
        text[2] = new Text("Scissor");
        text[3] = new Text("Hunter");
        text[4] = new Text("Bird");
        text[5] = new Text("Water");


            Text selectNameText = new Text();
            selectNameText.setText(playerName);
            selectNameText.setFont(Const.criteriaFontStyle);
            selectNameText.setFill(Color.DARKMAGENTA);
            this.add(selectNameText, 0, 1, 6, 1);
            GridPane.setHalignment(selectNameText, HPos.CENTER);

            Text selectText = new Text("Select your option");
            selectText.setFont(Const.optionFontStyle);
            selectText.setFill(Color.DARKMAGENTA);
            this.add(selectText, 0, 2, 6, 1);
            GridPane.setHalignment(selectText, HPos.CENTER);


            for(int i = 0 ; i < 6; i++){
                image = new Image("images/"+images[i]+".png");
                imageView[i] = new ImageView(image);
                this.add(imageView[i], i, 3);
            }

            for(int i = 0 ; i < 6; i++){
                text[i].setFont(Const.textFntStyle);
                this.add(text[i], i, 4);
                GridPane.setHalignment(text[i], HPos.CENTER);
            }


            for (int i = 0; i < 6; i++) {
                int num = i;
                imageView[i].setOnMouseClicked(e1 -> {
                   SettingsPane.soundEffects();
                   if(SettingsPane.soundButton.isSelected()){
                        SettingsPane.gameMediaPlayer.play();
                    }

                    Text chosenText = new Text("You Chose:");
                    chosenText.setFont(Font.font(20));
                    this.add(chosenText, 0, 6, 2, 1);
                    GridPane.setHalignment(chosenText, HPos.CENTER);

                    imageView1 = new ImageView("images/" + images[num] + ".png");
                    this.add(imageView1, 2, 6, 2, 1);
                    Text chosenOption = new Text();
                    chosenOption.setText(text[num].getText());
                    chosenOption.setFont(Const.textFntStyle);
                    this.add(chosenOption, 2, 7, 2, 1);
                    GridPane.setHalignment(imageView1, HPos.CENTER);
                    GridPane.setHalignment(chosenOption, HPos.CENTER);

                    Button nextButton = new Button("Next");
                    nextButton.setPadding(new Insets(10, 30, 10, 30));
                    nextButton.setTextFill(Color.DARKMAGENTA);
                    nextButton.setFocusTraversable(false);
                    this.add(nextButton, 4, 6, 2, 1);
                    GridPane.setHalignment(nextButton, HPos.CENTER);
                    nextButton.setOnAction(ex -> {
                        MainApplication.mainStage.setScene(new ResultScreen());
                    });

                    Game.user = num;
                    Game.player1= playerName;
                    Game.player2 = "Computer";
                    ResultPane.playerText.setText(playerName);
                    ResultPane.userImageView = new ImageView("images/" + images[num] + ".png");
                    ResultPane.playerChosenText.setText(text[num].getText());
                    reset();

                    Random r = new Random();
                    int computerOption = r.nextInt(6);
                    int compOption = computerOption;
                    Game.computer = computerOption;
                    ResultPane.computerText.setText("Computer");
                    ResultPane.computerImageView = new ImageView("images/" + images[compOption] + ".png");
                    ResultPane.computerChosenText.setText(text[compOption].getText());

                });
            }
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: burlyWood;");

    }

    public void reset(){
        for(int i = 0; i < 6; i++){
            imageView[i].setDisable(true);
        }
    }
}
