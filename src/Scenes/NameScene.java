package Scenes;

import Common.Const;
import Panes.NamePane;
import javafx.scene.Scene;

public class NameScene extends Scene {
    public NameScene() {
        super(new NamePane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
