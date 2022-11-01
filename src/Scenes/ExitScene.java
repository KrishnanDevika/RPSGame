package Scenes;

import Common.Const;
import Panes.ExitPane;
import javafx.scene.Scene;

public class ExitScene extends Scene {
    public ExitScene() {
        super(new ExitPane(), Const.SCREEN_WIDTH_EXIT, Const.SCREEN_HEIGHT_EXIT);
    }
}
