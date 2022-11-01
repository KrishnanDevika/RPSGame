package Scenes;

import Common.Const;
import Panes.LoadingPane;
import javafx.scene.Scene;

public class LoadingScene extends Scene {
    public LoadingScene() {
        super(new LoadingPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
