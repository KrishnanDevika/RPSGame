package Panes;

import Common.Const;
import RPSGame.MainApplication;
import Scenes.GameScene;
import Scenes.NameScene;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.util.Duration;




public class PlayOptionsPane extends BorderPane {

    public static Button vsComputer;
    public static Button vsFriends;


    public PlayOptionsPane(){

        Text titleText = new Text("Rock Paper Scissor");
        titleText.setFont(Const.criteriaFontStyle);
        titleText.setFill(Color.INDIGO);

        ImageView rpsImage = new ImageView(new Image("images/rockPaperScissor.jpg"));
        rpsImage.setFitWidth(300);
        rpsImage.setFitHeight(200);

        scaleTransition(rpsImage);

        vsComputer = new Button();
        vsComputer.setText("Vs Computer");
        vsComputer.setPadding(new Insets(30, 50, 30, 50));
        vsComputer.setFocusTraversable(false);
        vsComputer.setTextFill(Color.INDIGO);

        vsComputer.setOnMouseClicked(e->{
            vsComputer.setStyle("-fx-background-color: Beige;");
            TextField playerName = new TextField();
            playerName.setFocusTraversable(false);
            playerName.setPromptText("Your Name");
            Label nameLabel = new Label("Enter your name:");
            nameLabel.setFont(Const.textFntStyle);
            nameLabel.setAlignment(Pos.CENTER);


            Button okButton = new Button("OK");
            okButton.setPadding(new Insets(10, 20, 10, 20));
            okButton.setFocusTraversable(false);

            okButton.setOnAction(e1->{
                GamePane.playerName = String.valueOf(playerName.getText().charAt(0)).toUpperCase() + playerName.getText().substring(1);
                MainApplication.mainStage.setScene(new GameScene());

            });


            VBox vBox = new VBox();
            HBox hBox = new HBox();
            hBox.getChildren().addAll(nameLabel, playerName);
            hBox.setSpacing(20);

            vBox.getChildren().addAll(hBox, okButton);
            vBox.setPadding(new Insets(40, 75, 100, 40));
            vBox.setAlignment(Pos.BOTTOM_RIGHT);
            vBox.setSpacing(20);
            this.setRight(vBox);
            BorderPane.setAlignment(vBox, Pos.BOTTOM_RIGHT);
        });

        vsFriends = new Button();
        vsFriends.setText("Pass n Play");
        vsFriends.setPadding(new Insets(30, 60, 30, 60));
        vsFriends.setFocusTraversable(false);
        vsFriends.setTextFill(Color.INDIGO);

        vsFriends.setOnAction(e->{
            MainApplication.mainStage.setScene(new NameScene());

        });


        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        vBox.getChildren().addAll(titleText, rpsImage, vsComputer, vsFriends);

        this.setCenter(vBox);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: burlyWood;");
    }

    public void scaleTransition(Node node){

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1500), node);
        scaleTransition.setByX(.20f);
        scaleTransition.setByY(.20f);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(Animation.INDEFINITE);
        scaleTransition.play();
    }
}
