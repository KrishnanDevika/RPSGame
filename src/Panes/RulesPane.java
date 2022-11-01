package Panes;

import Common.Const;
import RPSGame.MainApplication;
import Scenes.PlayOptionScene;
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


public class RulesPane extends GridPane {

    public RulesPane(){

        this.setVgap(10);
        this.setHgap(20);

        Text titleText = new Text("Rules");
        titleText.setFont(Const.titleFont);
        titleText.setFill(Color.SADDLEBROWN);
        titleText.setStroke(Color.BLACK);
        this.add(titleText, 0, 0, 3, 1);
        GridPane.setHalignment(titleText, HPos.CENTER);

        Text gameText = new Text("This game contains 6 options:");
        gameText.setFont(Font.font(20));
        this.add(gameText, 0, 1, 3, 1);


        Image image = new Image("images/game.png");
        ImageView imageView= new ImageView(image);
        imageView.setFitWidth(350);
        imageView.setFitHeight(200);
        this.add(imageView, 0, 2, 3, 1);
        GridPane.setHalignment(imageView, HPos.CENTER);

        Text winningTitle = new Text("Wining Criteria");
        winningTitle.setFont(Const.criteriaFontStyle);
        winningTitle.setFill(Color.FIREBRICK);
        winningTitle.setStroke(Color.BLACK);
        this.add(winningTitle, 0, 3, 3, 1);

        Text criteria1 = new Text("Rock Smash Scissor");
        criteria1.setFont(Font.font(20));
        this.add(criteria1, 0, 4);

        Text criteria2 = new Text("Rock Beats Hunter");
        criteria2.setFont(Font.font(20));
        this.add(criteria2, 0, 5);

        Text criteria3 = new Text("Rock Beats Bird");
        criteria3.setFont(Font.font(20));
        this.add(criteria3, 0, 6);

        Text criteria4 = new Text("Paper Floats on Water");
        criteria4.setFont(Font.font(20));
        this.add(criteria4, 0, 7);

        Text criteria5 = new Text("Paper Covers Rock");
        criteria5.setFont(Font.font(20));
        this.add(criteria5, 0, 8);

        Text criteria6 = new Text("Hunter Shoots Bird");
        criteria6.setFont(Font.font(20));
        this.add(criteria6, 1, 4);

        Text criteria7 = new Text("Scissor Cuts Paper");
        criteria7.setFont(Font.font(20));
        this.add(criteria7, 1,5);

        Text criteria8 = new Text("Scissor Cuts Hunter");
        criteria8.setFont(Font.font(20));
        this.add(criteria8, 1,6);

        Text criteria9 = new Text("Scissor Cuts Bird");
        criteria9.setFont(Font.font(20));
        this.add(criteria9, 1,7);

        Text criteria10 = new Text("Hunter Tear Paper");
        criteria10.setFont(Font.font(20));
        this.add(criteria10, 1,8);

        Text criteria11 = new Text("Hunter Drinks Water");
        criteria11.setFont(Font.font(20));
        this.add(criteria11, 2,4);

        Text criteria12 = new Text("Water Erodes Rock");
        criteria12.setFont(Font.font(20));
        this.add(criteria12, 2,5);

        Text criteria13 = new Text("Water Rusts Scissor");
        criteria13.setFont(Font.font(20));
        this.add(criteria13, 2,6);

        Text criteria14 = new Text("Bird Tears Paper");
        criteria14.setFont(Font.font(20));
        this.add(criteria14, 2,7);

        Text criteria15 = new Text("Bird Drinks Water");
        criteria15.setFont(Font.font(20));
        this.add(criteria15, 2,8);

        Button playButton = new Button("Ready Set Go");
        playButton.setTextFill(Color.CRIMSON);
        playButton.setPadding(new Insets(10,50,10,50));
        playButton.setFocusTraversable(false);
        this.add(playButton, 0, 9, 3, 1);
        GridPane.setHalignment(playButton, HPos.CENTER);
        playButton.setOnAction(e->{
            MainApplication.mainStage.setScene(new PlayOptionScene());
        });


        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: burlyWood;");

    }
}
