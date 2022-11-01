package Panes;

import Common.Const;
import RPSGame.MainApplication;
import Scenes.WelcomeScreen;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;

public class SettingsPane extends BorderPane {
    public static Media backgroundMedia, gameMedia;
    public static MediaPlayer backgroundMediaPlayer, gameMediaPlayer;
    public static  ToggleButton musicButton = new ToggleButton("Background Music");
    public static  ToggleButton soundButton = new ToggleButton("SoundFx");

    public SettingsPane(){
        VBox vBox = new VBox();
        musicButton.setPadding(new Insets(10,20, 10, 20));
        soundButton.setPadding(new Insets(10,40, 10, 40));
        musicButton.setFocusTraversable(false);
        soundButton.setFocusTraversable(false);

        File song = new File("src/Music/Platformer2.mp3");
        backgroundMedia = new Media(song.toURI().toString());
        backgroundMediaPlayer = new MediaPlayer(backgroundMedia);

        if(musicButton.isSelected()) {
            musicButton.setTextFill(Color.CHOCOLATE);
        }

        musicButton.setOnAction(e->{
            if(musicButton.isSelected()){
                musicButton.setTextFill(Color.CHOCOLATE);
                backgroundMediaPlayer.play();
                backgroundMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            }else{
                musicButton.setTextFill(Color.BLACK);
                backgroundMediaPlayer.stop();
            }

        });

        soundEffects();


        Label settings = new Label("Settings");
        settings.setFont(Const.criteriaFontStyle);

        Slider slider = new Slider(0, 1, 0.5);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(0.2);
        slider.setMaxWidth(150);

        slider.valueProperty().addListener(
                new ChangeListener<Number>() {

                    public void changed(ObservableValue<? extends Number >
                                                observable, Number oldValue, Number newValue)
                    {

                       backgroundMediaPlayer.setVolume(newValue.doubleValue());
                       gameMediaPlayer.setVolume(newValue.doubleValue());
                    }
                });

        Button backButton = new Button("OK");
        backButton.setPadding(new Insets(10, 20, 10, 20));
        backButton.setOnAction(e->{
            if(musicButton.isSelected())
                backgroundMediaPlayer.play();
            MainApplication.mainStage.setScene(new WelcomeScreen());
        });
        vBox.getChildren().addAll(settings, musicButton, soundButton, slider, backButton);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        this.setCenter(vBox);
        this.setPadding(new Insets(40));

        this.setStyle("-fx-background-color: burlyWood;");

    }

    public static void soundEffects(){
        File song2 = new File("src/Music/move2.wav");
        gameMedia = new Media(song2.toURI().toString());
        gameMediaPlayer = new MediaPlayer(gameMedia);

        if(soundButton.isSelected()) {
            soundButton.setTextFill(Color.CHOCOLATE);
        }

        soundButton.setOnAction(e->{
            if(soundButton.isSelected()) {
                soundButton.setTextFill(Color.CHOCOLATE);
            }
            else{
                soundButton.setTextFill(Color.BLACK);
                gameMediaPlayer.stop();
            }
        });
    }
}
