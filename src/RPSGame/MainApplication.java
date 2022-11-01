package RPSGame;

import Scenes.IntroScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    public static Stage mainStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        mainStage.setScene(new IntroScene());
        mainStage.setTitle("ROCK PAPER SCISSOR");
        mainStage.show();
    }
}
