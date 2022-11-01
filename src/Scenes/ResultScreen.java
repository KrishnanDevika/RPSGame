package Scenes;
import Panes.ResultPane;
import Common.Const;
import javafx.scene.Scene;

public class ResultScreen extends Scene {
    public ResultScreen() {
        super(new ResultPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
