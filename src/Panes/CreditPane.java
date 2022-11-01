package Panes;


import Common.Const;
import RPSGame.MainApplication;
import Scenes.RulesScreen;

import javafx.animation.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class CreditPane extends GridPane {

    public CreditPane(){

        this.setVgap(15);
        this.setHgap(10);

        Text titleText = new Text("Ultimate Rock Paper Scissor");
        titleText.setFont(Const.titleFont);
        titleText.setFill(Color.SADDLEBROWN);
        titleText.setStroke(Color.BLACK);
        this.add(titleText, 0, 0, 4, 1);
        GridPane.setHalignment(titleText, HPos.CENTER);

        Text creditTitle = new Text("Credits");
        creditTitle.setFont(Const.creditFontStyle);
        creditTitle.setFill(Color.DARKGOLDENROD);
        creditTitle.setStroke(Color.BLACK);
        this.add( creditTitle,0, 1, 4, 1);
        GridPane.setHalignment(creditTitle, HPos.CENTER);

        Text developer = new Text("Developer:");
        developer.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        this.add(developer, 0, 3);
        Text developerName = new Text("Devika Krishnan");
        developerName.setFont(Const.textFntStyle);
        this.add(developerName, 1, 3);

        Text assistance = new Text("Contributor:");
        assistance.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        this.add(assistance, 0, 4);
        Text assistanceName = new Text("Ramana Varma");
        assistanceName.setFont(Const.textFntStyle);
        this.add(assistanceName, 1, 4);

        Text special = new Text("Special Thanks:");
        special.setFont(Font.font("Helvetica", FontWeight.BOLD, 18));
        this.add(special, 3, 3, 2, 1);
        GridPane.setHalignment(special, HPos.CENTER);
        Text guideName = new Text("Cai Filiault (Guidance)");
        guideName.setFont(Const.textFntStyle);
        this.add(guideName, 3, 4,2,1);
        GridPane.setHalignment(guideName, HPos.CENTER);

        Text imageResource1 = new Text("All image resources are found at https://iconarchive.com/ \n"+
                "under the CC0 1.0 Universal (CC0 1.0) Public Domain License");
        imageResource1.setFont(Const.textFntStyle);
        this.add(imageResource1, 0, 7, 4, 1);

        Text imageResource2 = new Text("All image resources are found at <a href='https://www.freepik.com/vectors/people'>\n"+"" +
                "People vector created by macrovector - www.freepik.com</a>");
        imageResource2.setFont(Const.textFntStyle);
        this.add(imageResource2, 0, 9, 4, 1);

        ImageView nextButton = new ImageView("icons/Button-Next-icon (1).png");
        GridPane.setHalignment(nextButton, HPos.CENTER);
        this.add(nextButton, 0, 11, 4, 1);

        nextButton.setOnMouseClicked(e->{
            MainApplication.mainStage.setScene(new RulesScreen());
        });

        FillTransition fillTransition = new FillTransition(Duration.millis(1000), creditTitle, Color.DARKGOLDENROD, Color.DARKCYAN);

        SequentialTransition seq = new SequentialTransition();
        seq.getChildren().addAll(
                fillTransition,
                scaleAnimation(creditTitle));
        seq.play();



        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: burlyWood;");

    }

    public ScaleTransition scaleAnimation(Node node){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), node);
        scaleTransition.setByX(.75f);
        scaleTransition.setByY(1f);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);
        return  scaleTransition;
    }


}

