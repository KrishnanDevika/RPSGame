package Scenes;
import Panes.GamePane;
import Common.Const;
import javafx.scene.Scene;

public class GameScene extends Scene {
    public GameScene() {
        super(new GamePane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
