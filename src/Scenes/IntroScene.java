package Scenes;
import Panes.IntroPane;
import Common.Const;
import javafx.scene.Scene;

public class IntroScene extends Scene {
    public IntroScene() {
        super(new IntroPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
