package Scenes;

import Common.Const;
import Panes.SettingsPane;
import javafx.scene.Scene;

public class SettingsScene extends Scene {
    public SettingsScene() {
        super(new SettingsPane(), Const.SCREEN_WIDTH_SETTINGS, Const.SCREEN_HEIGHT_SETTINGS);
    }
}
