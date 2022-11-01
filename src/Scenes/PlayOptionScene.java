package Scenes;


import Common.Const;
import Panes.PlayOptionsPane;
import javafx.scene.Scene;

public class PlayOptionScene extends Scene {
    public PlayOptionScene() {
        super(new PlayOptionsPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
