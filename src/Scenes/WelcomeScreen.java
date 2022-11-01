package Scenes;
import Panes.WelcomePane;
import Common.Const;
import javafx.scene.Scene;

public class WelcomeScreen extends Scene {
    public WelcomeScreen() {
        super(new WelcomePane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
