package Scenes;

import Common.Const;
import Panes.TwoPlayerPane;
import javafx.scene.Scene;

public class TwoPlayerScene extends Scene {
    public TwoPlayerScene() {
        super(new TwoPlayerPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
