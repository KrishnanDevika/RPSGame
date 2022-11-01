package Panes;


import Common.Const;
import RPSGame.MainApplication;
import Scenes.TwoPlayerScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class NamePane extends BorderPane {

    public NamePane(){

        TextField player1Name = new TextField();
        player1Name.setPrefWidth(300);
        player1Name.setPromptText("Name");
        player1Name.setFocusTraversable(false);

        TextField player2Name = new TextField();
        player2Name.setPrefWidth(300);
        player2Name.setPromptText("Name");
        player2Name.setFocusTraversable(false);

        Label player1Label = new Label();
        player1Label.setFont(Const.textFntStyle);
        Label player2Label = new Label();
        player2Label.setFont(Const.textFntStyle);

        Button nextButton = new Button("Next");
        nextButton.setFocusTraversable(false);
        nextButton.setPadding(new Insets(10, 20, 10, 10));

        VBox vBox = new VBox();
        player1Label.setText("Player 1 Enter you Name:");
        player2Label.setText("Player 2 Enter you Name:");
        vBox.getChildren().addAll(player1Label, player1Name, player2Label, player2Name,nextButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(25);
        nextButton.setOnAction(e->{
            TwoPlayerPane.player1 = String.valueOf(player1Name.getText().charAt(0)).toUpperCase() + player1Name.getText().substring(1);
            TwoPlayerPane.player2 = String.valueOf(player2Name.getText().charAt(0)).toUpperCase() + player2Name.getText().substring(1);
            MainApplication.mainStage.setScene(new TwoPlayerScene());
        });
        this.setCenter(vBox);
        this.setPadding(new Insets(100, 300, 100, 300));
        this.setStyle("-fx-background-color: burlyWood;");


    }
}
