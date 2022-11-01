package Scenes;
import Panes.ScorePane;
import Common.Const;
import javafx.scene.Scene;

public class ScoreScene extends Scene {
    public ScoreScene() {
        super(new ScorePane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
