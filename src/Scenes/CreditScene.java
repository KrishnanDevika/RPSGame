package Scenes;

import Panes.CreditPane;
import Common.Const;
import javafx.scene.Scene;


public class CreditScene extends Scene {
    public CreditScene() {
        super(new CreditPane(), Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
    }
}
