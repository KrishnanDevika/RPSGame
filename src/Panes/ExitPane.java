package Panes;

import Common.Const;
import RPSGame.MainApplication;
import Scenes.WelcomeScreen;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ExitPane extends BorderPane {

    public  ExitPane(){
        Text exitText = new Text("Do You Really Want to Exit?");
        exitText.setFont(Const.optionFontStyle);

         Button yesButton = new Button("Yes");
         yesButton.setPadding(new Insets(10, 20, 10, 20));
         yesButton.setFocusTraversable(false);

         Button noButton = new Button("No");
         noButton.setPadding(new Insets(10, 20, 10, 20));
         noButton.setFocusTraversable(false);

         yesButton.setOnAction(e->{
             SettingsPane.backgroundMediaPlayer.stop();
             MainApplication.mainStage.close();

         });

         noButton.setOnAction(e->{
             MainApplication.mainStage.setScene(new WelcomeScreen());
         });

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(yesButton, noButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(50);

        this.setCenter(exitText);
        this.setBottom(buttonBox);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: burlyWood;");
    }
}
