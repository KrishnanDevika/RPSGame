package Panes;

import Common.Const;
import RPSGame.MainApplication;
import RPSGame.Game;
import Scenes.CreditScene;
import Scenes.ExitScene;
import Scenes.SettingsScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class WelcomePane extends BorderPane {

    public WelcomePane(){
        Text welcomeText = new Text("Welcome to the Ultimate\n"+
                "ROCK PAPER SCISSOR Game");
        welcomeText.setFont(Const.titleFont);
        welcomeText.setFill(Color.DEEPSKYBLUE);
        welcomeText.setStroke(Color.BLACK);

        Button playButton = new Button("Play");
        playButton.setTextFill(Color.CRIMSON);
        playButton.setPadding(new Insets(10, 60, 10, 60));
        playButton.setFocusTraversable(false);

        Button exitButton = new Button("Exit");
        exitButton.setTextFill(Color.CRIMSON);
        exitButton.setPadding(new Insets(10, 20, 10, 20));
        exitButton.setFocusTraversable(false);


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.getChildren().addAll(welcomeText, playButton);

        playButton.setOnAction(e->{
            MainApplication.mainStage.setScene(new CreditScene());
            Game.userScore = 0;
            Game.computerScore = 0;
            ScorePane.playerScore.setText(Integer.toString(0));
            ScorePane.computerScore.setText(Integer.toString(0));

        });

        Button settingsButton = new Button("Settings");
        settingsButton.setTextFill(Color.CRIMSON);
        settingsButton.setPadding(new Insets(10, 20, 10, 20));
        settingsButton.setFocusTraversable(false);
        settingsButton.setOnAction(e->{
            new SettingsPane();
            SettingsPane.backgroundMediaPlayer.stop();
            MainApplication.mainStage.setScene(new SettingsScene());
        });
        exitButton.setOnAction(e->{
           MainApplication.mainStage.setScene(new ExitScene());
        });
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(settingsButton, exitButton);
        this.setBottom(hBox);
        this.setCenter(vBox);
        this.setPadding(new Insets(40, 40, 40, 40));
        this.setStyle("-fx-background-color: burlyWood;");
    }
}
